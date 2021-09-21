package mx.santander.liquidez.control.traductor.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import mx.santander.liquidez.control.traductor.dto.model.ComboBean;
import mx.santander.liquidez.control.traductor.dto.model.TraductorBean;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.tipocambio.model.TipoCambioSocketDTO;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> TraductorService.java
 * <br><b>Description:</b> Clase service de implementacion del negocio de
 * traductor
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 17 ago. 2019 FSW Praxis, 
 * Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category Service
 */
@Service
public class TraductorService implements ITraductorService {

    /** Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraductorService.class);
    
    /**  uri del servicio uriGetComboTablas no asignado expuesto en el api traductor. */
    @Value("${control.endpoint.traductor.get.comboTabla}")
    private String uriGetComboTabla;
    
    /**  uri del servicio uriGetComboTablas no asignado expuesto en el api traductor. */
    @Value("${control.endpoint.traductor.post.procesoTraductor}")
    private String uriPostTraductor;
    
    /** Ruta de destino para enviar balances a los subscriptores del web socket. */
    @Value("${control.websocket.subscribe.destination.cambio}")
    private String wsDestinationDivisa;
    
    /**  Variable urlConsDivisas de tipo String. */
    @Value("${control.endpoint.divisas.cambio}")
    private String urlConsDivisas;
                                
    /** Inyeccion de RestTemplate para consumir api Traductor. */
    @Autowired
    private RestTemplate restTemplate;
    
    /**  Un simpMessagingTemplate para mensajeria SimpMessagingTemplate.  */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    
    
                            
    
    /**
     * Metodo de implementacion para consultar el catalago de tablas.
     *
     * @return List<{@link ComboBean}> lista catalago de tablas
     * @throws ServiceException the service exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ComboBean> comboCatTablas() throws ServiceException{        
        LOGGER.info("consultar catalago de tablas: {} ");
        List<ComboBean> result = new ArrayList<ComboBean>();
        try {
            result = restTemplate.getForObject(uriGetComboTabla, List.class);
            LOGGER.info("La consulta al catalogo de las tablas se ejecuto correctamente ... ");        
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,uriGetComboTabla, e);
        }
        return result;
    }
    
    /**
     * Procesar vector precios.
     * @param bean the bean
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the list
     * @throws ServiceException the service exception
     */            
    @Override
    public List<?> procesarTraductor(TraductorBean bean, String audit) throws ServiceException {
        LOGGER.info("Procesando Carga de Archivo Traductor... ");
        List<?> result = null;
        try {
            HttpEntity<TraductorBean> entity = new HttpEntity<>(bean,  StringUtil.obtenerHeaders(audit));
            result = restTemplate.postForObject(uriPostTraductor, entity, List.class);
            LOGGER.info("Proceso Traductor ejecutado correctamente ... ");        
        } catch (RestClientException e) {
            LOGGER.error(CodigoError.CLIENTE_REST+" : "+uriPostTraductor ,e);
            ArrayList<String> error = new ArrayList<>();            
            error.add("Conexion Rechazada:  Traductor: " + bean.getTipoCarga());
            result = error;            
        }
        return result;
    }
    
    
    
    /**
     * Meotod para Enviar divisa al WebSocket.
     * @param cambio the cambio
     * @throws ServiceException the service exception
     */
    @Override
    public void enviarDivisa(List<TipoCambioSocketDTO> cambio) throws ServiceException {
        LOGGER.info("Enviando al WebSocket la Divisa ... ");
        LOGGER.info("Url envio  ... " + wsDestinationDivisa );
        simpMessagingTemplate.convertAndSend(wsDestinationDivisa, cambio);
        LOGGER.info("La Divisa se ha enviado correctamente al WebSocket. ");
    }
    
    
    
}
