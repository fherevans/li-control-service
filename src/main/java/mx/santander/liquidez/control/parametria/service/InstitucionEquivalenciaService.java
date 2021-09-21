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
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaInstDTO;
import mx.santander.liquidez.control.parametria.model.InstitucionEquivalencia;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> DivisaEquivalencia.java <br>
 * <b>Description:</b> Service para crear, actualizar, eliminar y leer operacion
 * institucion equivalencia.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Service
 * 
 */
@Service
public class InstitucionEquivalenciaService implements IInstitucionEquivalenciaService {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitucionEquivalenciaService.class);
    
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
    @Value("${control.endpoint.equivalencia.instituciones.get.all}")
    private String uriConsultaInstitucion;
    
    /**
     * Variable uriConsultaInstitucionDet de tipo String
     */
    @Value("${control.endpoint.equivalencia.instituciones.detalle}")
    private String uriConsultaInstitucionDet;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Variable uricreainstitucion de tipo String
     */
    @Value("${control.endpoint.equivalencia.instituciones.post}")
    private String uriCreaInstitucion;
    
    /**
     * Variable uriActualizainstitucion de tipo String
     */
    @Value("${control.endpoint.equivalencia.instituciones.put}")
    private String uriActualizaInstitucion;
    
    /**
     * Variable uriEliminainstitucion de tipo String
     */
    @Value("${control.endpoint.equivalencia.instituciones.delete}")
    private String uriEliminaInstitucion;

    /**
     * Metodo para crear una nueva institucion equivalencia.
     * 
     * @param institucionEquivalencia {@link InstitucionEquivalencia}
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return institucionEquivalencia creado.
     * @throws ServiceException
     */
    @Override
    public Object crearInstitucionEquivalencia(InstitucionEquivalencia institucionEquivalencia, String audit) throws ServiceException {
        //CREA EQUIVALENCIA ISNTITUCION
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(institucionEquivalencia, encabezados, uriCreaInstitucion, HttpMethod.POST);
    }

    /**
     * Metodo para actualizar una institucion equivalencia.
     * 
     * @param institucionEquivalencia institucion equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return InstitucionEquivalencia actualizada.
     * @throws ServiceException
     */
    @Override
    public Object actualizarInstitucionEquivalencia(InstitucionEquivalencia institucionEquivalencia, Long id, String audit) throws ServiceException {
        //ACTUALIZA EQUIVALENCIA DE INSTITUCION
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(institucionEquivalencia, encabezados, 
                uriActualizaInstitucion.replaceAll("\\?", institucionEquivalencia.getIdEquiv().toString()), HttpMethod.PUT);
        }

    /**
     * Metodo para obtener todas las instituciones equivalencias y paginar.
     * @param filtro  parametros como filtros.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List de todas las instituciones equivalencias.
     */
    @Override
    public CustomPageImpl<InstitucionEquivalencia> obtenerTodasInstitucionesEquivalenciaPage(FiltroEquivalenciaInstDTO filtro, String audit) {    
        Gson gson = new Gson();
        String json = gson.toJson(filtro);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<InstitucionEquivalencia>> response = restTemplate.exchange(uriConsultaInstitucion, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<InstitucionEquivalencia>>() {});
        LOGGER.info("Obtencion de divisas equivalencia con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    /**
     * Metodo para eliminar institucion equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @param institucionEquivalenciaPK llave para eliminar.
     * @throws ServiceException 
     */
    @Override
    public Object eliminarInstitucionEquivalencia(Long id, String audit) throws ServiceException {
        //ELIMINA EQUIVALENCIA DE DIVISA
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(null, encabezados, 
                uriEliminaInstitucion.replaceAll("\\?", id.toString()), HttpMethod.DELETE);
    }

    @Override
    public Object obtenerInstitucionesEquiv(String audit) throws ServiceException {
        //CONSULTA INSTITUCIONES EQUIVALENCIA
        try {            
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaInstitucionDet, HttpMethod.GET, entity, Object.class).getBody();        
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaInstitucionDet, e);
        }
    }

}
