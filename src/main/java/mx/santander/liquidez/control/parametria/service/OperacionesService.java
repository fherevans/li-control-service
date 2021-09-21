/**
 * 
 */
package mx.santander.liquidez.control.parametria.service;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.OperacionesLiq;
import mx.santander.liquidez.control.parametria.model.OperacionesRequest;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> OperacionesService.java
* <br><b>Description:</b> Clase de implementacion de los metodos de negocio de las
* operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class OperacionesService implements IOperacionesService{
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesService.class);
    
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
     * Variable AUDIT de tipo String
     */
    private static final String AUDIT = "audit";
    
    /**
     * uri para Operaciones.
     */
    @Value("${control.endpoint.operaciones.get.all}")
    private String uriConsultaOperacionesGet;
    
    /**
     * uri para Operaciones.
     */
    @Value("${control.endpoint.operaciones.pag}")
    private String uriConsultaOperaciones;
    
    /**
     * Variable uricreaOperaciones de tipo String
     */
    @Value("${control.endpoint.operaciones.post}")
    private String uriCreaOperaciones;
    
    /**
     * Variable uriActualizaOperaciones de tipo String
     */
    @Value("${control.endpoint.operaciones.put}")
    private String uriActualizaOperaciones;
    
    /**
     * Variable uriEliminaOperaciones de tipo String
     */
    @Value("${control.endpoint.operaciones.delete}")
    private String uriEliminaOperaciones;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CustomPageImpl<OperacionesLiq> consultaOperacionesPag(OperacionesRequest request, String audit) throws ServiceException {
        //CONSULTA OPERACIONES PAGINADA
        Gson gson = new Gson();
        String json = gson.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        //LLAMA SERVICIO PARAMETRIA
        ResponseEntity<CustomPageImpl<OperacionesLiq>> response = restTemplate.exchange(uriConsultaOperaciones, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<OperacionesLiq>>() {});
        LOGGER.info("Obtencion de instituciones con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    @Override
    public Object guardaOperacion(OperacionesLiq operacion, String audit) throws ServiceException {
        //CREA UNA NUEVA OPERACION
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(operacion, encabezados, uriCreaOperaciones, HttpMethod.POST);
    }

    @Override
    public Object eliminaOperacion(Long id, String audit) throws ServiceException {
        //ELIMINA OPERACION
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(null, encabezados, 
                uriEliminaOperaciones.replaceAll("\\?", id.toString()), HttpMethod.DELETE);
    }

    @Override
    public Object actualizaOperacion(OperacionesLiq operacion, Long id, String audit) throws ServiceException {
        //ACTUALIZA UNA OPERACION
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(operacion, encabezados, 
                uriActualizaOperaciones.replaceAll("\\?", id.toString()), HttpMethod.PUT);
    }

    @Override
    public Object consultaOperaciones(String audit) throws ServiceException {    
        //CONSULTA OPERACIONES
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaOperacionesGet, HttpMethod.GET, entity, Object.class).getBody();    
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaOperacionesGet, e);
        }
    }

    //Agregar java doc
    @Override
    public Object getAllTypesOperations() throws ServiceException {
        try {
            return restTemplate.exchange(uriConsultaOperacionesGet + "/operaciones_indeval", HttpMethod.GET, null, Object.class).getBody();    
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaOperacionesGet, e);
        }
    }

}