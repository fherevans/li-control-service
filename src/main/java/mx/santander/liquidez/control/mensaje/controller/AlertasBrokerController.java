
/**
 * 
 */
package mx.santander.liquidez.control.mensaje.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.mensaje.service.IAlertaService;
import mx.santander.liquidez.notificacion.toast.model.MensajeFrontDTO;

/**
 * @author tori
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/alertas")
public class AlertasBrokerController {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AlertasBrokerController.class);
    
    /**
     * Variable de tipo {@link IAlertaService} para realizar el llamado a los 
     * metodos de alertas para el front en redis
     */
    @Autowired
    private IAlertaService iAlertaService;
    /**
     * Metodo que realiza el envio de notificaciones a pantalla a traves 
     * de webSocket
     * 
     * @param mensajeDTO - objeto mensaje que trae informacion necesaria 
     * para el envio de mensaje.
     * @return retorna un 200 si fue publicado o un 400 badRequest 
     */
    @SubscribeMapping("/queue/mensajes")
    @SendTo(value = "/queue/mensajes")
    public @Payload List<MensajeFrontDTO> enviarNotificacion(){
        List<MensajeFrontDTO> listaMensajes = this.iAlertaService.obtenerInformacion();
        LOGGER.info("Lista de mensajes generados : {}", listaMensajes.size());
        return listaMensajes;
    }
    
    
    /**
     * Recibe los SemaforoBalancesRedis para enviarlos a los subscriptores correspondientes.
     * @param mensajeDTO - mensaje DTO informacion    
     * @return lista
     */
    @MessageMapping(value = "/recibe/mensajes")
    public @Payload MensajeFrontDTO enviarNotificacionWS(@RequestBody MensajeFrontDTO mensajeDTO){
        this.iAlertaService.enviar(mensajeDTO);
        return mensajeDTO;
    }
    
}
