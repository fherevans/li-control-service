/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.rest.repository;

import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.procesamiento.contingencia.model.ActualizacionContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.ContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.SolicitudContingenciaDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IContingenciaRestRepository.java
 * <br><b>Description:</b>
 * Define una interfaz para la funcionalidad de acceso a datos REST para
 * contingencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 25 sep 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 25 sep 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Repository Interface
 *
 */
public interface IContingenciaRestRepository {
    
    /**
     * Envia el aviso de activacion de contingencia via REST a procesamiento.
     * @param solicitudContingencia son datos de la solicitud de contingencia
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    void avisar(SolicitudContingenciaDTO solicitudContingencia) 
            throws DataAccessException;
    
    /**
     * Envia actualizacion de estatus de contingencia via REST a contingencia.
     * @param actualizacionContingencia son datos para actualizacion de contingencia
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    ContingenciaDTO actualizar(ActualizacionContingenciaDTO actualizacionContingencia) 
            throws DataAccessException;

    /**
     * Solicita el estatus de contingencia via REST a contingencia.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    ContingenciaDTO obtenerEstatus(String idUsuario, String ipRemota)
            throws DataAccessException;
    
}
