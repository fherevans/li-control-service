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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.GruposOperacion;
import mx.santander.liquidez.control.parametria.model.GruposOperacionesRequest;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> GruposOperacionesService.java
* <br><b>Description:</b> Clase de implementacion de los metodos de negocio de los
* grupos de operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service.
*
*/
@Service
public class GruposOperacionesService implements IGruposOperacionesService {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GruposOperacionesService.class);
    
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
     * uri para Grupos.
     */
    @Value("${control.endpoint.grupos.get.all}")
    private String uriConsultaGruposGet;
    
    /**
     * uri para Grupos.
     */
    @Value("${control.endpoint.grupos.pag}")
    private String uriConsultaGrupos;
    
    /**
     * Variable uricreaGrupos de tipo String
     */
    @Value("${control.endpoint.grupos.post}")
    private String uriCreaGrupos;
    
    /**
     * Variable uriActualizaGrupos de tipo String
     */
    @Value("${control.endpoint.grupos.put}")
    private String uriActualizaGrupos;
    
    /**
     * Variable uriEliminaGrupos de tipo String
     */
    @Value("${control.endpoint.grupos.delete}")
    private String uriEliminaGrupos;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public CustomPageImpl<GruposOperacion> consultaTodosFiltros(GruposOperacionesRequest request, String audit) throws ServiceException {
        //CONSULTA PAGINADA GRUPOS OPERACIONES
        Gson gson = new Gson();
        String json = gson.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<GruposOperacion>> response = restTemplate.exchange(uriConsultaGrupos, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<GruposOperacion>>() {});
        LOGGER.info("Obtencion de instituciones con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    @Override
    public Object guardaGrupoOper(GruposOperacion grupo, String audit) throws ServiceException {    
        //CREA UN NUEVO GRUPO DE OPERACIONES
        HttpEntity<GruposOperacion> entity = new HttpEntity<>(grupo, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriCreaGrupos, HttpMethod.POST, entity, Object.class).getBody();
    }

    @Override
    public Object eliminaGripoOper(Long id, String audit) throws ServiceException {
        //ELIMINA UN GRUPO DE OPERACIONES
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriEliminaGrupos.replaceAll("\\?", id.toString()), HttpMethod.DELETE, entity, Object.class).getBody();
    }

    @Override
    public Object actualizarGrupoOper(GruposOperacion grupo, Long id, String audit) throws ServiceException {
        //CONSULTA FECHA DE CARGA DEL GRUPO
        HttpEntity<GruposOperacion> entity = new HttpEntity<>(grupo, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriActualizaGrupos.replaceAll("\\?", id.toString()), HttpMethod.PUT, entity, Object.class).getBody();
    }

    @Override
    public Object consultaTodos(String audit) throws ServiceException {
        //CONSULTA TODOS LOS GRUPOS
        try {
            HttpEntity<String> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaGruposGet, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL CLIENTE
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaGruposGet, e);
        }
    }
    
}