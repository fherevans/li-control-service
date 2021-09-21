/**
 * 
 */
package mx.santander.liquidez.control.divisa.service;

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
import mx.santander.liquidez.control.parametria.dto.model.DivisasPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.Divisas;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> DivisasService.java
* <br><b>Description:</b> Clase service que contienen los metodos de negocio de 
* divisas de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 6 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 6 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class DivisasService implements IDivisasService {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DivisasService.class);
    
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
     * Variable urlDivisas de tipo String
     */
    @Value("${control.endpoint.divisas.consulta}")
    private String urlDivisas;
    
    /**
     * Variable urlDivisasAll de tipo String
     */
    @Value("${control.endpoint.divisas.detalle}")
    private String urlDivisasAll;
    
    /**
     * uri para Divisas.
     */
    @Value("${control.endpoint.divisas.pag}")
    private String uriConsultaDivisas;
    
    /**
     * Variable uricreaDivisas de tipo String
     */
    @Value("${control.endpoint.divisas.post}")
    private String uriCreaDivisas;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Variable uriActualizaDivisas de tipo String
     */
    @Value("${control.endpoint.divisas.put}")
    private String uriActualizaDivisas;
    
    /**
     * Variable uriEliminaDivisas de tipo String
     */
    @Value("${control.endpoint.divisas.delete}")
    private String uriEliminaDivisas;
    
    @Override
    public Object consultaDivisas(String audit) throws ServiceException {
        //CONSULTA DIVISAS
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(urlDivisasAll, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, urlDivisasAll, e);
        }
    }

    @Override
    public Object consultaDivisasOperativas(String audit) throws ServiceException {
        //CONSULTA DIVISAS
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(urlDivisas, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, urlDivisas, e);
        }
    }

    @Override
    public CustomPageImpl<Divisas> consultaTodosFiltros(DivisasPaginadaRequest filtros, String audit) throws ServiceException {
        //CONSULTA DIVISAS PAGINADA
        Gson gson = new Gson();
        //PARSEA OBJETO A JSON STRING
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        //SE AGREGAN ENCABEZADOS A LA PETICION
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        //EJECUTA SERVICIO DE DIVISAS
        ResponseEntity<CustomPageImpl<Divisas>> response = restTemplate.exchange(uriConsultaDivisas, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<Divisas>>() {});
        LOGGER.info("Obtencion de divisas con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    @Override
    public Object guardaDivisa(Divisas divisa, String audit) throws ServiceException {
        //GUARDA DIVISAS
        //LLAMA SERVICIO PARAMETRIA
        HttpEntity<Divisas> entity = new HttpEntity<>(divisa, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriCreaDivisas, HttpMethod.POST, entity, Divisas.class).getBody();
    }

    @Override
    public Object actualizaDivisa(Divisas divisa, Long id, String audit) throws ServiceException {
        //ACTUALIZA DIVISAS
        //LLAMA SERVICIO PARAMETRIA
        HttpEntity<Divisas> entity = new HttpEntity<>(divisa, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriActualizaDivisas.replaceAll("\\?", id.toString()), HttpMethod.PUT, entity, Divisas.class).getBody();
    }

    @Override
    public Object eliminaDivisa(Long id, String audit) throws ServiceException {
        //ELIMINA DIVISAS
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(null, StringUtil.obtenerEncabezados(audit), 
                uriEliminaDivisas.replaceAll("\\?", id.toString()), HttpMethod.DELETE);
    }

}
