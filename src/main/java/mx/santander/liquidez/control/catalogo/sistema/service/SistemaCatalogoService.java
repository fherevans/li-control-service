/**
 * 
 */
package mx.santander.liquidez.control.catalogo.sistema.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.parametria.model.Sistema;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SistemaCatalogoService.java
 * <br><b>Description:</b>
 * Implementa la interfaz de servicio de catalogo de sistemas.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 * @see RestTemplate
 *
 */
@Service
public class SistemaCatalogoService implements ISistemaCatalogoService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SistemaCatalogoService.class);
    
    /**
     * Un REST template.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Ruta GET hacia el servicio de catalogo de sistemas.
     */
    @Value("${control.endpoint.catalogo.sistema.get.all}")
    private String uriObtenerSistemas;

    /**
     * Obtiene el catalogo completo de sistemas.
     * @return un arreglo de {@link Sistema}s
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @Override
    public Sistema[] obtenerTodos() throws ServiceException {
        try {
            /* Invoca GET */
            ResponseEntity<Sistema[]> response = restTemplate
                    .getForEntity(uriObtenerSistemas, Sistema[].class);
            int code = response.getStatusCodeValue();
            /* Asume es 200 */
            assert(code == 200);
            LOGGER.info(StringUtil.concat("Obtencion de todos los sistemas.",
                    " Code: ", code));
            return response.getBody();
            
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,
                    uriObtenerSistemas, e);
        }
    }

}
