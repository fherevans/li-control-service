/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.rest.repository;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.procesamiento.contingencia.model.ActualizacionContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.ContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.SolicitudContingenciaDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ContingenciaRestRepository.java
 * <br><b>Description:</b>
 * Implementa la interfaz para el repositorio REST de contingencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 30 sep 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 30 sep 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Repository
 *
 */
@Repository
@RefreshScope
public class ContingenciaRestRepository implements IContingenciaRestRepository {
    
    /**
     * La instancia de logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ContingenciaRestRepository.class);
    
    /**
     * Endpoint al servicio de procesamiento.
     */
    @Value("${control.endpoint.procesamiento.contingencia.patch}")
    private String uriProcesamientoActivacionPatch;
    
    /**
     * Endpoint al servicio de contingencia.
     */
    @Value("${control.endpoint.contingencia.actualizacion.patch}")
    private String uriContingenciaActualizacionPatch;
    
    /**
     * Endpoint al servicio de contingencia.
     */
    @Value("${control.endpoint.contingencia.consulta}")
    private String uriContingenciaConsultaGet;
    
    /**
     * Instancia de REST template.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Constructor por defecto.
     */
    public ContingenciaRestRepository() {
        super();
    }

    /**
     * Envia el aviso de activacion de contingencia via REST a procesamiento.
     * @param solicitudContingencia son datos de la solicitud de contingencia
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    @Override
    public void avisar(SolicitudContingenciaDTO solicitudContingencia) 
            throws DataAccessException {
        try {    
            /* Crea request. */
            URI uri = URI.create(uriProcesamientoActivacionPatch);
            RequestEntity<SolicitudContingenciaDTO> request = RequestEntity
                    .patch(uri)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .body(solicitudContingencia);
            
            /* Envia. */
            ResponseEntity<String> response = restTemplate
                    .exchange(request, String.class);
            
            /* Asume es 200 */
            assert(response.getStatusCodeValue() == 200);
            LOGGER.info("Aviso de contingencia enviado a procesamiento");
            
        } catch (RestClientException e) {
            /* Envia error. */
            throw new DataAccessException(CodigoError.CLIENTE_REST,
                    uriProcesamientoActivacionPatch, e);
        }
    }

    /**
     * Envia actualizacion de estatus de contingencia via REST a contingencia.
     * @param actualizacionContingencia son datos para actualizacion de contingencia
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    @Override
    public ContingenciaDTO actualizar(ActualizacionContingenciaDTO 
            actualizacionContingencia) throws DataAccessException {
        try {    
            /* Crea request. */
            URI uri = URI.create(uriContingenciaActualizacionPatch);
            RequestEntity<ActualizacionContingenciaDTO> request = RequestEntity
                    .patch(uri)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .body(actualizacionContingencia);
            
            /* Envia. */
            ResponseEntity<ContingenciaDTO> response = restTemplate
                    .exchange(request, ContingenciaDTO.class);
            
            /* Asume es 200 */
            assert(response.getStatusCodeValue() == 200);
            LOGGER.info("Actualizacion de contingencia enviada a contingencia");
            
            return response.getBody();
            
        } catch (RestClientException e) {
            /* Envia error. */
            throw new DataAccessException(CodigoError.CLIENTE_REST,
                    uriContingenciaActualizacionPatch, e);
        }
    }

    /**
     * Solicita el estatus de contingencia via REST a contingencia.
     * @param idUsuario es el Id de usuario solicitante
     * @param ipRemota es la IP remota del solicitante
     * @return informacion de contingencia en un objeto {@link ContingenciaDTO}
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    @Override
    public ContingenciaDTO obtenerEstatus(String idUsuario, String ipRemota) 
            throws DataAccessException {
        try {
            /* Crea URI.  */
            URI uri = UriComponentsBuilder.fromUriString(uriContingenciaConsultaGet)
                    .queryParam("idUsuario", idUsuario)
                    .queryParam("ipRemota", ipRemota)
                    .build().toUri();
            
            /* Crea request.  */
            RequestEntity<Void> request = RequestEntity.get(uri)
                     .accept(MediaType.APPLICATION_JSON_UTF8)
                     .build();
            
            /* Envia. */
            ResponseEntity<ContingenciaDTO> response = restTemplate
                    .exchange(request, ContingenciaDTO.class);
            
            /* Asume es 200 */
            assert(response.getStatusCodeValue() == 200);
            LOGGER.info("Consulta de estatus de contingencia obtenido");
            
            return response.getBody();

        } catch (RestClientException e) {
            /* Envia error. */
            throw new DataAccessException(CodigoError.CLIENTE_REST,
                    uriContingenciaConsultaGet, e);
        }
    }

}
