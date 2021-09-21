/**
 * 
 */
package mx.santander.liquidez.control.parametria.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.santander.liquidez.control.parametria.model.RespSiacDTO;
import mx.santander.liquidez.control.parametria.model.SeguimientoSiacDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SeguimientoSiacService.java
* <br><b>Description:</b> Clase Service de implementacion del seguimiento de SIAC.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service.
*
*/
@Service
public class SeguimientoSiacService implements ISeguimientoSiacService {
    
    /**
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguimientoSiacService.class.getName());
    
    /**
     * Variable CONTENT_TYPE de tipo String
     */
    private static final String CONTENT_TYPE = "Content-Type";
    
    /**
     * Variable APPLICATION_JSON de tipo String
     */
    private static final String APPLICATION_JSON = "application/json";
    
    /**
     * Variable ACCEPT de tipo String
     */
    private static final String ACCEPT = "Accept";
    
    /**
     * Variable uriSeguimientoSpeiSpid de tipo String
     */
    @Value("${control.endpoint.seguimientos.siac}")
    private String uriSeguimientoSiac;

    /**
     * Inyeccion de RestTemplate para consumir api.
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object consultaSeguimientoDetalleSiac(SeguimientoSiacDTO seguimiento) throws ServiceException {
        Gson gson = new Gson();
        String json = gson.toJson(seguimiento);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        //LLAMA SERVICIO DE CONSULTA DETALLE DEL SEGUIMIENTO SIAC
        ResponseEntity<RespSiacDTO> response = restTemplate.exchange(
                String.format(uriSeguimientoSiac), HttpMethod.POST, entity,
                new ParameterizedTypeReference<RespSiacDTO>() {});
        LOGGER.info("CODIGO RESPUESTA DE SEGUIMIENTO SIAC DETALLE: " + response.getStatusCodeValue());
        //RETORNA RESULTADO DE LA CONSULTA
        return response;
    }

}
