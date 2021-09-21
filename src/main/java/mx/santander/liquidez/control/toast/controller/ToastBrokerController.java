/**
 * 
 */
package mx.santander.liquidez.control.toast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.toast.service.IToastService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;
import mx.santander.liquidez.notificacion.toast.model.ToastRedis;
import mx.santander.liquidez.toast.model.Toast;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ToastBrokerController.java
 * <br><b>Description:</b> 
 * Controlador para agente de mensajeria de toasts.
 * Toasts son notificaciones ligeras que se muestran en front, faciles
 * de alinear y colocar dentro de una pagina web.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 1 ago. 2019 
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 *
 */
@RestController
@RequestMapping(value = "/toasts")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ToastBrokerController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ToastBrokerController.class);
    
    /**
     * La instancia para el servicio de toasts.
     */
    @Autowired
    private IToastService toastService;
    
    /**
     * Recibe un subscripcion a la mensajeria de toasts y
     * envia la lista de las ultimas toasts que corresponden al Id de rol.
     * @param idRol el Id de rol como criterio de subscripcion
     * @return una lista de {@link Toast}s
     */
    @SubscribeMapping(value = "/queue/toasts/{idRol}")
    @SendTo(value = "/queue/toasts/{idRol}")
    public @Payload List<ToastRedis> subscribir(@DestinationVariable long idRol) {
        List<ToastRedis> toasts = toastService.obtenerUltimasPorRol(idRol);
        LOGGER.info("Subscripcion recibida, rol: {}", idRol);
        return toasts;
    }
    
    /**
     * Recibe los toasts para enviarlos a los subscriptores correspondientes.
     * @param idRol el Id de rol como criterio de recepcion
     * @param toasts la lista de {@link Toast}s a enviar
     * @return una lista de {@link Toast}s
     */
    @MessageMapping(value = "/recibe/toasts/{idRol}")
    public void recibir(@DestinationVariable long idRol,
            @Payload ToastRedis toasts) {
        toastService.enviar(idRol, toasts);
        LOGGER.info("Notificaciones enviadas para rol: {}", idRol);
    }
    
    /**
     * Recibe como parametros el idRol y el idToast a eliminar
     *  
     * @param idRol - rol del usuario que elimina las notificaciones
     * @param idToast - id notificacion a eliminar
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return retorna un simple estatus 200 confirmando que fue eliminado
     */
    @DeleteMapping(value = "/{idrol}/{idToast}")
    public ResponseEntity<Object> eliminarToastByRolByIdToast(@PathVariable("idrol") long idRol, 
            @PathVariable("idToast") long idToast, HttpServletRequest requestHttp){
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA TOAST
            response = UtilRestClient.crearResponseEntity(this.toastService.eliminarToast(idRol, idToast, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR TOAST EN EL SERVICIO DE CONTROL MONITOR\n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR TOAST (CONTROL MONITOR) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        LOGGER.info("Notificaciones eliminada {} para rol: {}",idToast, idRol);
        return response;
    }

}
