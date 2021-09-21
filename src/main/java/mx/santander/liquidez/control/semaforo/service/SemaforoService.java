/**
 * 
 */
package mx.santander.liquidez.control.semaforo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.semaforo.repository.ISemaforoRedisGeneralRepository;
import mx.santander.liquidez.control.semaforo.repository.ISemaforoRedisRepository;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceGeneralRedis;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalancesRedis;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SemaforoService.java
 * <br><b>Description:</b>
 * Clase creada para 
 *
 * @author FSW Lacertus Herwin Toral Rios
 * @company Praxis
 * @created 14 nov 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0  14 nov 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 */
@Service
public class SemaforoService implements ISemaforoService {
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SemaforoService.class);

    /**
     * Instancia del semaforoRepository para extraer informacion de Redis
     */
    @Autowired
    private ISemaforoRedisRepository iSemaforoRedisRepository;
    
    /**
     * Variable iSemaforoRedisGeneralRepository de tipo ISemaforoRedisGeneralRepository usado en la clase.
     * by: tori 
     */
    @Autowired
    private ISemaforoRedisGeneralRepository iSemaforoRedisGeneralRepository; 
    
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.semaforot}")
    private String wsDestinationSemaforot;
        
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.semaforoq}")
    private String wsDestinationSemaforoq;
              
    /**
     * Un template para mensajeria SIMP.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    /**
     * ruta para calcular el semaforo en pantalla
     */
    @Value("${control.endpoint.semaforo.get}")
    private String urlCalularSemaforo;

    /**
     * Variable restTemplate de tipo RestTemplate usado en la clase.
     * by: tori 
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Obtiene los ultimos SemaforoBalancesRedis en cache.
     * @param fechaLiquidacion - fecha de la consulta a realizar
     * @return una lista de {@link SemaforoBalancesRedis}s
     */
    @Override
    public List<SemaforoBalancesRedis> obtenerUltimos(Long idRol, String fechaLiquidacion) {
        List<SemaforoBalancesRedis> semaforos = this.iSemaforoRedisRepository.findByIdRolAndFechaLiquidacion(idRol, fechaLiquidacion);
        LOGGER.info("Lista de semaforos por sistema: {}", semaforos.size());
        return semaforos;
    }
    
    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     * @param SemaforoBalancesRedis la lista de {@link SemaforoBalancesRedis}s a enviar
     * @param fechaLiquidacion -fecha a la cual se realiza la consulta de los semaforos
     */
    @Override
    public void enviar(Long idRol, String fechaLiquidacion, SemaforoBalancesRedis semaforo) {
        List<SemaforoBalancesRedis> semaforos = this.iSemaforoRedisRepository.findByIdRolAndFechaLiquidacion(idRol, fechaLiquidacion);
        String rutaWS = StringUtil.concat(this.wsDestinationSemaforoq,"/", idRol, "/",fechaLiquidacion);
        LOGGER.info("Semaforo sistema :: {}" , semaforo);
        LOGGER.info("rutaWS :: {}" , rutaWS);
        this.simpMessagingTemplate.convertAndSend(rutaWS, semaforos);
    }

    /**
     * @param idRol - idRol al cual realiza la consulta
     * @param idUsuario - usuario el cual realiza la consulta
     * @param idDivisa - divisa el cual realiza la consulta
     * @param fechaLiquidacion - fechaLiquidacion que realiza la consulta
     * @return
     */
    @Override
    public String calcular(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion) {
        LOGGER.info("* Calculo semaforo general *");
        String semaforoRuta = this.urlCalularSemaforo+"/";
        return restTemplate.getForObject(semaforoRuta+ "/{idRol}"+"/{idUsuario}"+"/{idDivisa}"+"/{fechaLiquidacion}", String.class, idRol,idUsuario,idDivisa,fechaLiquidacion);
        
    }

    /**
     * Obtiene los ultimos SemaforoBalancesRedis en cache.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param semaforo - objeto semaforo para envio al front
     * @return una lista de {@link SemaforoBalancesRedis}s
     */
    @Override
    public SemaforoBalanceGeneralRedis obtenerUltimos(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion) {
        return this.iSemaforoRedisGeneralRepository.findByIdRolAndIdUsuarioAndIdDivisaAndFechaLiquidacion(idRol, idUsuario, idDivisa, fechaLiquidacion);
    }

    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param semaforo - objeto semaforo para envio al front
     */
    @Override
    public void enviar(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion, SemaforoBalanceGeneralRedis semaforo) {
        String rutaWS = StringUtil.concat(this.wsDestinationSemaforot,"/", "generales", "/", idRol, "/", idUsuario, "/", idDivisa ,"/", fechaLiquidacion);
        LOGGER.info("Envia el semaforo general a control rutaWS :: {}" , rutaWS);
        LOGGER.info("Semaforo general :: {}" , semaforo);
        this.simpMessagingTemplate.convertAndSend(rutaWS, semaforo);
    }

}
