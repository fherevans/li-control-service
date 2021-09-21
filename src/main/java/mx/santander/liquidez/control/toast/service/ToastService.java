/**
 * 
 */
package mx.santander.liquidez.control.toast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.toast.repository.IToastRepository;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;
import mx.santander.liquidez.notificacion.toast.model.ToastRedis;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ToastService.java
 * <br><b>Description:</b> 
 * Implementa la interfaz para procesamiento y envio de notificaciones
 * toasts.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 * 
 */
@Service
public class ToastService implements IToastService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(IToastService.class);
    
    /**
     * La instancia de un repositorio de toast.
     */
    @Autowired
    private IToastRepository toastRepository;
    
    /**
     * Instancia para SIMP messaging template.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    /**
     * Variable CONTENT_TYPE de tipo String
     */
    private static final String CONTENT_TYPE = "Content-Type";
    
    /**
     * Variable APPLICATION_JSON de tipo String
     */
    private static final String APPLICATION_JSON = "application/json";
    
    /**
     * Variable ACCEPT de tipo String
     */
    private static final String ACCEPT = "Accept";
    
    /**
     * Variable AUDIT de tipo String
     */
    private static final String AUDIT = "audit";
    
    /**
     * Ruta de destino para enviar toasts a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.toast}")
    private String wsDestinationToast;
    
    /**
     * 
     */
    @Value("${control.endpoint.toast.delete}")
    private String uriToastRest;

    /**
     * Constructor por defecto.
     */
    public ToastService() {
        super();
    }

    /**
     * Obtiene las ultimas toasts por Id de rol.
     * @param idRol el Id de rol
     * @return una lista de toasts
     */
    @Override
    public List<ToastRedis> obtenerUltimasPorRol(long idRol) {
        List<ToastRedis> toasts = toastRepository.findByIdRolOrderByIdAsc(idRol);
        LOGGER.info("Notificaciones encontradas, rol: {} total: {}", idRol, toasts.size());
        return toasts;
    }
    
    /**
     * Envia una lista de toasts al servicio de control.
     * @param idRol el el Id de rol
     * @param toasts la lista de toasts a enviar
     */
    @Override
    public void enviar(long idRol, ToastRedis toasts) {
        simpMessagingTemplate.convertAndSend(StringUtil
                .concat(wsDestinationToast, idRol), toasts);
        LOGGER.info("Notificaciones enviadas a control, rol: {} ",
                idRol);
    }


    /**
     * ELimina Toast
     * 
     * @param idRol   id rol
     * @param idToast id toast
     * @param audit parametro que guarda la pista como n de la aplicacion
     */
    @Override
    public Object eliminarToast(long idRol, long idToast, String audit) throws ServiceException {
        LOGGER.info("informacion {} ", (StringUtil.concat(this.uriToastRest, "/", idRol + "/", +idToast)));
        //ELIMINA TOAST
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO CONTROL MONITOR
        return UtilRestClient.executeServiceRest(null, encabezados, 
                StringUtil.concat(this.uriToastRest, "/", idRol + "/", +idToast), HttpMethod.DELETE);
    }
    
}
