package mx.santander.liquidez.control.sal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> AdaptacionLocalController.java
* <br><b>Description:</b> Clase Controlelr para administrar las peticiones de 
* liquidez intradia al SAL para la validacion de los token de los usuario logeados.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 12 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 12 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RefreshScope
@RestController
@RequestMapping("/sesiones")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AdaptacionLocalController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AdaptacionLocalController.class);
    
    /**
     * Variable urlSal de tipo String
     */
    @Value("${sal.validaUsuario}")
    private String urlSal;
    
    /**
     * Metodo para invocar al SAL y validar si el usuario cuenta con un token valido
     * @param token token del usuario a validar en el SAL
     * @return Respuesta de la validacion del token con los datos del usuario logeado
     */
    @RequestMapping(value = "/{token}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validaUsuario(@PathVariable String token) {
        
        String [] rutaArray = urlSal.split("%s");
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> result = rest.getForEntity(rutaArray[0] + "{token}" + rutaArray[1], String.class, token);
        LOGGER.info("ESTATUS PETICION SAL: " + result.getStatusCodeValue());
        return result.getBody();
    }

}
