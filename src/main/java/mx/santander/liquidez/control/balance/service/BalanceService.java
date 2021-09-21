/**
 * 
 */
package mx.santander.liquidez.control.balance.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.balance.repository.IBalanceRepository;
import mx.santander.liquidez.control.balance.socket.repository.IBalanceSocketRepository;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> BalanceService.java
 * <br><b>Description:</b>
 * Implementacion de la interfaz de servicio para balance.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 * 
 * @see IBalanceService
 */
@Service
@RefreshScope
public class BalanceService implements IBalanceService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BalanceService.class);
    
    /**
     * Constante FORMATO_FECHA de tipo String
     */
    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.balance}")
    private String wsDestinationBalance;
    
    /**
     * Un template para mensajeria SIMP.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    /**
     * Instancia para un repositorio socket de balance.
     */
    @Autowired
    private IBalanceSocketRepository balanceSocketRepository;
              
    /**
     * Instancia para repositorio Redis de balance.
     */
    @Autowired
    private IBalanceRepository balanceRepository;
    
    /**
     * Constructor for defecto.
     */
    public BalanceService() {
        super();
    }
    
    /**
     * Obtiene los ultimos balances de cache de Redis.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @return una lista de objetos de tipo {@link BalanceDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public List<BalanceDTO> obtenerUltimos(String fechaLiquidacion) 
            throws ServiceException {
        try {
            /* Consulta. */
            List<BalanceDTO> balances = balanceRepository
                    .findAllByFechaLiquidacion(fechaLiquidacion);
            
            LOGGER.info("Se obtienen los ultimos balances con determinada fecha de liquidacion");
            
            return balances;
            
        } catch (org.springframework.dao.DataAccessException e) {
            /* Envia error. */
            throw new ServiceException(CodigoError.REPOSITORY_REDIS,
                    IBalanceRepository.class.getCanonicalName(), e);
        }
    }
    
    
    /**
     * Envia el balance a los subscriptores de un web socket.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @param balance es la informacion del balance calculado
     */
    @Override
    public void enviar(BalanceDTO balance, String fechaLiquidacion) 
        throws DataAccessException{
        
        try {
            simpMessagingTemplate.convertAndSend(StringUtil
                    .concat(wsDestinationBalance, fechaLiquidacion), balance);
            LOGGER.info("Balance enviado via web socket");    
        } catch (MessagingException e) {
            /* Envia error. */
            throw new DataAccessException(CodigoError.CLIENTE_SOCKET,
                    wsDestinationBalance, e);
        }
        
    }
    
    /**
     * Envia un lista de balances a los subscriptores de un web socket.
     * @param balanceDTOs la lista de {@link BalanceDTO}s a enviar
     */
    @Override
    public void enviar(List<BalanceDTO> balanceDTOs) {
        simpMessagingTemplate.convertAndSend(wsDestinationBalance, balanceDTOs);
        LOGGER.info("Balances enviados via web socket: {}", balanceDTOs.size());
    }

    /**
     * Obtiene las fechas en las que existe balance.
     * @return la lista de fechas en formato de string: DD-MM-YYYY
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public String[] consultarFechas() throws ServiceException {
        String fechaLiquidacion;
        Set<String> fechas = new HashSet<>();
        List<String> lista = new ArrayList<String>();
        try {
            /* Consulta todos los balances. */
            for (BalanceDTO balance : balanceRepository.findAll()) {
                /* Agrega. */
                fechaLiquidacion = balance.getFechaLiquidacion();
                if (fechaLiquidacion != null && !fechaLiquidacion.isEmpty()) {
                    fechas.add(fechaLiquidacion);
                }
            }
            lista.addAll(fechas);
            this.ordenamientoFechaLiquidacion(lista);
            LOGGER.info("Se obtienen las fechas en las que existen balances");
            return lista.toArray(new String[fechas.size()]);
            
        } catch (org.springframework.dao.DataAccessException e) {
            /* Envia error. */
            throw new ServiceException(CodigoError.REPOSITORY_REDIS,
                    IBalanceRepository.class.getCanonicalName(), e);
        }
    }

    /**
     * Envia los balances en cache de Redis a los subscriptores de un web socket.
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public void enviarTodos() throws ServiceException {
        try {
            /* Fechas. */
            int total = 0;
            for (String fechaLiquidacion: this.consultarFechas()) {
                List<BalanceDTO> balances = balanceRepository
                        .findAllByFechaLiquidacion(fechaLiquidacion);
                balanceSocketRepository.enviar(fechaLiquidacion, balances);
                total += balances.size();
            }
            LOGGER.info("Balances enviados: total={}", total);
            
        } catch (org.springframework.dao.DataAccessException e) {
            /* Envia error. */
            throw new ServiceException(CodigoError.REPOSITORY_REDIS,
                    IBalanceRepository.class.getCanonicalName(), e);
            
        } catch (DataAccessException e) {
            /* Enviar error. */
            throw ErrorUtil.obtenerUsando(e);
        }
    }
    
    /**
     * Ordenamiento fecha liquidacion.
     * Metodo que se encarga de generar el ordenamiento
     * de forma asecendente de las fechas de liquidacion
     * @param lista que contiene las fechas encontradas en la consulta
     */
    private void ordenamientoFechaLiquidacion(List<String> lista) {
        
        Collections.sort(lista, new Comparator<String>() {
               private DateFormat format = new SimpleDateFormat(FORMATO_FECHA);
               @Override
               public int compare(String o1, String o2) {
                 try {
                   return format.parse(o1).compareTo(format.parse(o2));
                 } catch (ParseException e) {
                     LOGGER.error("Error al parsear la fecha" , e);
                 }
                return 0;
               }
             });
    }

}
