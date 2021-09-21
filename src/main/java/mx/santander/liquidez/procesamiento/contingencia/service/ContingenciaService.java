/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.procesamiento.contingencia.model.ActualizacionContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.ContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.SolicitudContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.rest.repository.IContingenciaRestRepository;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ContingenciaService.java
 * <br><b>Description:</b>
 * Implementa el servicio de contingencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 28 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 28 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 * 
 */
@Service
public class ContingenciaService implements IContingenciaService {
    
    /**
     * La instancia de logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ContingenciaService.class);
    
    /**
     * Es un repositorio REST para contingencia.
     */
    @Autowired
    private IContingenciaRestRepository contingenciaRestRepository;

    /**
     * Envia la senial de activacion de contingencia 
     * al servicio de procesamiento.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public void activar(String idUsuario, String ipRemota) 
            throws ServiceException {
        try {
            /* Datos de solicitud. */
            SolicitudContingenciaDTO solicitudContingencia
                    = new SolicitudContingenciaDTO();
            solicitudContingencia.setIdUsuario(idUsuario);
            solicitudContingencia.setIpRemota(ipRemota);
            
            /* Avisa la contingencia. */
            contingenciaRestRepository.avisar(solicitudContingencia);
            
            LOGGER.info("Aviso de contingencia enviado");
            
        } catch (DataAccessException e) {
            /* Enviar error. */
            throw ErrorUtil.obtenerUsando(e);
        }
    }
    
    /**
     * Envia la actualizacion del estatus de contingencia 
     * al servicio de contingencia.
     * @param actualizacionContingencia datos para actualizacion de contingencia
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public ContingenciaDTO actualizar(ActualizacionContingenciaDTO 
            actualizacionContingencia) throws ServiceException {
        try {
            /* Actualiza la contingencia. */
            ContingenciaDTO contingencia = contingenciaRestRepository
                    .actualizar(actualizacionContingencia);
            
            LOGGER.info(StringUtil.concat("Actualizacion de contingencia enviada: ",
                    "info=", actualizacionContingencia));
            return contingencia;
            
        } catch (DataAccessException e) {
            /* Enviar error. */
            throw ErrorUtil.obtenerUsando(e);
        }
    }

    /**
     * Obtiene el estatus que guarda el proceso de contingencia
     * desde el servicio de contingencia.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public ContingenciaDTO obtenerEstatus(String idUsuario, String ipRemota) 
            throws ServiceException {
        try {            
            /* Estatus de la contingencia. */
            ContingenciaDTO contingencia = contingenciaRestRepository
                    .obtenerEstatus(idUsuario, ipRemota);
            
            LOGGER.info("Consulta de estatus de contingencia");
            
            return contingencia;
            
        } catch (DataAccessException e) {
            /* Enviar error. */
            throw ErrorUtil.obtenerUsando(e);
        }
    }
    
}
