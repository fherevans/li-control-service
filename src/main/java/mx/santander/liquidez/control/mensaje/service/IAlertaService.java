package mx.santander.liquidez.control.mensaje.service;

import java.util.List;

import mx.santander.liquidez.notificacion.toast.model.MensajeFrontDTO;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IAlertaService.java
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
public interface IAlertaService {

    /**
     * Obtiene todos los mensajes generados en Redis
     * @return Lista de {@link MensajeFrontDTO} generados en redis
     */
    List<MensajeFrontDTO> obtenerInformacion();

    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     * @param mensaje la lista de {@link MensajeFrontDTO}s a enviar
     */
    void enviar(MensajeFrontDTO mensaje);

}