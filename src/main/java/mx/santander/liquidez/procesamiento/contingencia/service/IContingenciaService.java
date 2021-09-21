/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.service;

import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.contingencia.model.ActualizacionContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.ContingenciaDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IContingenciaService.java
 * <br><b>Description:</b>
 * Define la interfaz para el servicio de contingencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 28 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 28 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 * 
 */
public interface IContingenciaService {
    
    /**
     * Envia la senial de activacion de contingencia 
     * al servicio de procesamiento.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @throws ServiceException si un error ocurre durante el proceso
     */
    void activar(String idUsuario, String ipRemota) throws ServiceException;
    
    /**
     * Envia la actualizacion del estatus de contingencia 
     * al servicio de contingencia.
     * @param actualizacionContingencia datos para actualizacion de contingencia
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    ContingenciaDTO actualizar(ActualizacionContingenciaDTO actualizacionContingencia) 
            throws ServiceException;

    /**
     * Obtiene el estatus que guarda el proceso de contingencia
     * desde el servicio de contingencia.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    ContingenciaDTO obtenerEstatus(String idUsuario, String ipRemota)
            throws ServiceException;
    
}
