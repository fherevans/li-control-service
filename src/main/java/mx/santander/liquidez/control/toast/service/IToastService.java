/**
 * 
 */
package mx.santander.liquidez.control.toast.service;

import java.util.List;

import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.notificacion.toast.model.ToastRedis;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IToastService.java <br>
 * <b>Description:</b> Una interfaz que define el comportamiento para procesar
 * notificaciones conocidas como toasts.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category Service Interface
 */
public interface IToastService {

    /**
     * Obtiene las ultimas toasts por Id de rol.
     * 
     * @param idRol el Id de rol
     * @return una lista de toasts
     */
    List<ToastRedis> obtenerUltimasPorRol(long idRol);

    /**
     * Envia una lista de toasts al servicio de control.
     *
     * @param idRol - el Id de rol
     * @param toasts - obejto toast que se recibe 
     */
    void enviar(long idRol, ToastRedis toasts);

    /**
     * ELimina Toast.
     *
     * @param idRol   id rol
     * @param idToast id toast
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the object
     * @throws ServiceException the service exception
     */
    Object eliminarToast(long idRol, long idToast, String audit)  throws ServiceException;

}
