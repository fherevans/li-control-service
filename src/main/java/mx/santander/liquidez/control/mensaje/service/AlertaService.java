package mx.santander.liquidez.control.mensaje.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.toast.repository.IMensajeFrontRepository;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.notificacion.toast.model.MensajeFrontDTO;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> AlertaService.java
 * <br><b>Description:</b>
 * Clase creada para 
 *
 * @author FSW Lacertus Herwin Toral Rios
 * @company Praxis
 * @created 2 dic 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0  2 dic 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 *
 */
@Service
public class AlertaService implements IAlertaService {

    /**
     * Variable de tipo {@link IMensajeFrontRepository} para realizar 
     * las consultas en redis para realizar la validacion de la informacion.
     */
    @Autowired
    private IMensajeFrontRepository iMensajeFrontRepository;
    
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.mensaje}")
    private String wsDestinationMensaje;
    
    /**
     * Un template para mensajeria SIMP.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    /**
     * Obtiene todos los mensajes generados en Redis
     * @return Lista de {@link MensajeFrontDTO} generados en redis
     */
    @Override
    public List<MensajeFrontDTO> obtenerInformacion(){
        return (List<MensajeFrontDTO>) this.iMensajeFrontRepository.findAll();
    }
    
    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     * @param mensaje la lista de {@link MensajeFrontDTO}s a enviar
     */
    @Override
    public void enviar(MensajeFrontDTO mensaje) {
        String rutaWS = StringUtil.concat(this.wsDestinationMensaje);
        List<MensajeFrontDTO> listMensaje = new ArrayList<MensajeFrontDTO>();
        listMensaje.add(mensaje);
        this.simpMessagingTemplate.convertAndSend(rutaWS, listMensaje);
    }
}
