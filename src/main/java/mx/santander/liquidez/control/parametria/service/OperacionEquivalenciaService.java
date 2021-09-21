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
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaOperDTO;
import mx.santander.liquidez.control.parametria.model.OperacionEquivalencia;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> OperacionEquivalenciaService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 5 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Service
public class OperacionEquivalenciaService implements IOperacionEquivalenciaService {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionEquivalenciaService.class);
    
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
     * Variable uriConsultaOperaciones de tipo String
     */
    @Value("${control.endpoint.equivalencia.operaciones.get.all}")
    private String uriConsultaOperaciones;
    
    /**
     * Variable uriConsultaOperacionesTodas de tipo String
     */
    @Value("${control.endpoint.equivalencia.operaciones.detalle}")
    private String uriConsultaOperacionesTodas;
    
    /**
     * Variable uricreaOperaciones de tipo String
     */
    @Value("${control.endpoint.equivalencia.operaciones.post}")
    private String uriCreaOperaciones;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Variable uriActualizaOperaciones de tipo String
     */
    @Value("${control.endpoint.equivalencia.operaciones.put}")
    private String uriActualizaOperaciones;
    
    /**
     * Variable uriEliminaOperaciones de tipo String
     */
    @Value("${control.endpoint.equivalencia.operaciones.delete}")
    private String uriEliminaOperaciones;

    /**
     * Metodo para crear un operacion equivalencia.
     * 
     * @param operacionEquivalencia {@link OperacionEquivalencia}.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return operacion equivalencia creada.
     * @throws ServiceException 
     */
    @Override
    public Object crearOperacionEquivalencia(OperacionEquivalencia operacionEquivalencia, String audit) throws ServiceException {
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(operacionEquivalencia, encabezados, uriCreaOperaciones, HttpMethod.POST);
    }

    /**
     * Metodo para obtener operaciones equivalencia paginado
     * 
     * @param filtro parametro validos para filtro.
     * @param page   filtro.
     * @param size   filtro.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List de operacionEquivalencia con paginacion.
     */
    @Override
    public CustomPageImpl<OperacionEquivalencia> obtenerOperacionesEquivalenciasPage(FiltroEquivalenciaOperDTO filtros, String audit) {
        Gson gson = new Gson();
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<OperacionEquivalencia>> response = restTemplate.exchange(uriConsultaOperaciones, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<OperacionEquivalencia>>() {});
        LOGGER.info("Obtencion de operaciones equivalencia con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    /**
     * Metodo para eliminar operacion equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @param id identificador unico de operacion equivalencia
     */
    @Override
    public Object eliminarOperacionEquivalencia(Long id, String audit) throws ServiceException {
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(null, encabezados, 
                uriEliminaOperaciones.replaceAll("\\?", id.toString()), HttpMethod.DELETE);
    }

    /**
     * Metodo para actualizar una operacion equivalencia.
     * 
     * @param opEq operacion equivalencia request.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Operacion equivalencia actualizado.
     */
    @Override
    public Object actualizarOperacionEquivalencia(OperacionEquivalencia opEq, Long id, String audit) throws ServiceException {
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(opEq, encabezados, 
                uriActualizaOperaciones.replaceAll("\\?", id.toString()), HttpMethod.PUT);
    }

    @Override
    public Object consultaTodasOper(String audit) throws ServiceException {
        //CONSULTA OPERACIONES EQUIVALENCIA
        try {            
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaOperacionesTodas, HttpMethod.GET, entity, Object.class).getBody();    
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaOperacionesTodas, e);
        }
    }

}
