/**
 * 
 */
package mx.santander.liquidez.control.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> UtilRestClient.java
* <br><b>Description:</b> Clase generica para llamar un servicio rest.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 30 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 30 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Util
*
*/
public final class UtilRestClient {
    
    /**
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilRestClient.class);
    
    /**
     * Constructor de la clase UtilRestService
     */
    protected UtilRestClient() {
         throw new UnsupportedOperationException("Unsupported Operation Util .......");
    }
    
    /**
     * Metodo generico para llamar un servicio Rest con un request body
     * @param request datos de entrada de la peticion rest
     * @param encabezados de la peticion rest
     * @param url end point del servicio rest
     * @param methodHttp metodo de invocacion http
     * @throws ServiceException service exception.
     * @return ResponseEntity con la respuesta del servicio rest
     */
    public static Object executeServiceRest(Object request, Map<String, String> encabezados, 
            String url, HttpMethod methodHttp) throws ServiceException {
        ResponseEntity<Object> response = null;
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();
        //SE PARSEA OBJETO A JSON STRING
        String json = gson.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        if(null != encabezados) {
            //AGREGA ENCABEZADOS A LA PETICION
            for (Map.Entry<String, String> entry : encabezados.entrySet()) {
                LOGGER.info("******************* ENCABEZADO HTTP *******************");
                LOGGER.info("NOMBRE = " + entry.getKey());
                LOGGER.info("*******************************************************");
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        //VALIDA SI LA PETICION ES GET
        if("GET".equals(methodHttp.name())) {
            //EJECUTA PETICION TIPO GET
            response = restTemplate.getForEntity(UrlUtil.isValidaURLExpresion(url), Object.class);
        }else {
            //EJECUTA PETICION TIPO POST, PUT, DELETE
            HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
            response = restTemplate.exchange(UrlUtil.isValidaURLExpresion(url), methodHttp, entity, Object.class);
        }
        //RESPUESTA DEL SERVICIO
        LOGGER.info("CODIGO DE RESPUESTA DE LA PETICION: " + response.getStatusCodeValue());
        //RETORNA RESPONSE SERVICIO
        return response.getBody();
    }
    
    /**
     * Metodo para crear response entity generico
     * @param objeto el cual se agregara a la respuesta 
     * @param estatus estado de la respuesta de la peticion
     * @return response entity inicializado
     */
    public static ResponseEntity<Object> crearResponseEntity(Object objeto, HttpStatus estatus){
        return ResponseEntity.status(estatus).body(objeto);
    }
    

}
