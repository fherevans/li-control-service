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
import mx.santander.liquidez.control.parametria.model.Institucion;
import mx.santander.liquidez.control.parametria.request.model.InstitucionRequest;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> InstitucionService.java
* <br><b>Description:</b> Clase de implementacion de los metodos de negocio de las
* instituciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 19 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 19 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class InstitucionService implements IInstitucionService{
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitucionService.class);
    
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
     * uri para institucion.
     */
    @Value("${control.endpoint.instituciones.get.all}")
    private String uriConsultaInstitucionGet;
    
    /**
     * uri para institucion.
     */
    @Value("${control.endpoint.instituciones.pag}")
    private String uriConsultaInstitucion;
    
    /**
     * Variable uricreainstitucion de tipo String
     */
    @Value("${control.endpoint.instituciones.post}")
    private String uriCreaInstitucion;
    
    /**
     * Variable uriActualizainstitucion de tipo String
     */
    @Value("${control.endpoint.instituciones.put}")
    private String uriActualizaInstitucion;
    
    /**
     * Variable uriEliminainstitucion de tipo String
     */
    @Value("${control.endpoint.instituciones.delete}")
    private String uriEliminaInstitucion;
    
    /**
     * uri para institucion.
     */
    @Value("${control.endpoint.instIndeval}")
    private String uriCatalogInstitucionGet;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Implementacion del metodo para consultar todas las instituciones de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object consultaInstituciones(String audit) throws ServiceException {
        //CONSULTA TODAS LAS INSTITUCIONES
        try {
            HttpEntity<String> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaInstitucionGet, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaInstitucionGet, e);
        }
    }
    
    /**
     * Implementacion del metodo para consultar todas las instituciones de liquidez por filtros
     * @param request objeto que contiene los filtros a utilizar en consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public CustomPageImpl<Institucion> consultaInstitucionesPag(InstitucionRequest filtros, String audit) throws ServiceException {        
        //RETORNA LISTA DE INSTITUCIONES ENCONTRADOS
        Gson gson = new Gson();
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<Institucion>> response = restTemplate.exchange(uriConsultaInstitucion, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<Institucion>>() {});
        LOGGER.info("Obtencion de instituciones con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    /**
     * Implementacion del metodo para crear una nueva institucion de liquidez
     * @param institucion datos de la institucion a crear en liqudiez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la institucion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object guardarInstitucion(Institucion institucion, String audit) throws ServiceException {
        HttpEntity<Institucion> entity = new HttpEntity<>(institucion, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriCreaInstitucion, HttpMethod.POST, entity, Object.class).getBody();
    }

    /**
     * Implementacion del metodo para actualizar una institucion de liquidez
     * @param institucion datos de la institucion a actualizar en liqudiez
     * @id identificador unico de equivalencia de institucion
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la institucion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object actualizaInstitucion(Institucion institucion, Long id, String audit) throws ServiceException {
        // ACTUALIZA UNA INSTITUCION
        HttpEntity<Institucion> entity = new HttpEntity<>(institucion, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriActualizaInstitucion.replaceAll("\\?", institucion.getIdInst().toString()), HttpMethod.PUT, entity, Object.class).getBody();
    }

    /**
     * Implementacion del metodo para eliminar una institucion de liquidez
     * @param id identificador unico de la institucion de liquidez
     * @return objeto de la institucion eliminada en liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object eliminaInstitucion(Long id, String audit) throws ServiceException {    
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriEliminaInstitucion.replaceAll("\\?", id.toString()), HttpMethod.DELETE, entity, Object.class).getBody();
    }
    
}
