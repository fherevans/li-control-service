package mx.santander.liquidez.control.catalogo.canal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.parametria.model.Canal;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> CanalService.java
* <br><b>Description:</b> Clase Service que implementan los metodos de negocio de canales.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 21 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 21 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class CanalService implements ICanalService{
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CanalService.class);
    
    /**
     * Un REST template.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Ruta GET hacia el servicio de catalogo de sistemas.
     */
    @Value("${control.endpoint.catalogo.canal.get.all}")
    private String uriObtenerCanales;

    @Override
    public Canal[] obtenerCanales() throws ServiceException {
        try {
            /* Invoca GET */
            ResponseEntity<Canal[]> response = restTemplate
                    .getForEntity(uriObtenerCanales, Canal[].class);
            int code = response.getStatusCodeValue();
            /* Asume es 200 */
            assert(code == 200);
            LOGGER.info(StringUtil.concat("Obtencion de todos los canales.",
                    " Code: ", code));
            return response.getBody();
            
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriObtenerCanales, e);
        }
    }

}
