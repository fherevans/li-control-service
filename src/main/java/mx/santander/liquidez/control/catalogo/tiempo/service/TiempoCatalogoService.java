/**
 * 
 */
package mx.santander.liquidez.control.catalogo.tiempo.service;

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
import mx.santander.liquidez.control.parametria.model.RequestTiemposEspecDTO;
import mx.santander.liquidez.control.parametria.model.TiempoEspecifico;
import mx.santander.liquidez.control.parametria.model.TiemposEspecRequest;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> TiempoCatalogoService.java
 * <br><b>Description:</b>
 * Implementa la interfaz de servicio de catalogo de tiempos.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 5 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 * @see RestTemplate
 *
 */
@Service
public class TiempoCatalogoService implements ITiempoCatalogoService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoCatalogoService.class);
    
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
     * Un REST template.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Ruta GET hacia el servicio de catalogo de tiempos.
     */
    @Value("${control.endpoint.catalogo.tiempo.get.all}")
    private String uriObtenerTiempos;
    
    /**
     * Ruta GET hacia el servicio de catalogo de tiempos.
     */
    @Value("${control.endpoint.catalogo.tiempo.detalle}")
    private String uriObtenerTiemposTodos;
    
    /**
     * Ruta GET hacia el servicio de catalogo de tiempos por id.
     */
    @Value("${control.endpoint.catalogo.tiempo.get.byid}")
    private String uriObtenerTiempoPorId;
    
    /**
     * Ruta POST hacia el servicio de catalogo de tiempos.
     */
    @Value("${control.endpoint.catalogo.tiempo.post}")
    private String uriCrearTiempo;
    
    /**
     * Ruta PUT hacia el servicio de catalogo de tiempos.
     */
    @Value("${control.endpoint.catalogo.tiempo.put}")
    private String uriActualizarTiempo;
    
    /**
     * Ruta DELETE hacia el servicio de catalogo de tiempos.
     */
    @Value("${control.endpoint.catalogo.tiempo.delete}")
    private String uriDeleteTiempo;

    /**
     * Obtiene el catalogo completo de tiempos.
     * @param request datos de la consulta de tiempos
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un arreglo de {@link TiempoEspecifico}
     */
    @Override
    public CustomPageImpl<TiempoEspecifico> obtenerTodos(TiemposEspecRequest request, String audit) {
        //CONSULTA TIEMPOS ESPECIFICOS PAGINADO
        Gson gson = new Gson();
        String json = gson.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<TiempoEspecifico>> response = restTemplate.exchange(uriObtenerTiempos, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<TiempoEspecifico>>() {});
        LOGGER.info("Obtencion de tiempos con codigo de respuesta:" + response.getStatusCodeValue());
        return response.getBody();
    }

    /**
     * Obtiene un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un objeto {@link TiempoEspecifico} si existe,
     * en caso contrario <code>null</code>
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object obtenerPorId(String id, String audit) throws ServiceException {
        try {            
            //CONSULTA TIEMPO ESPECIFICO POR ID
            HttpEntity<String> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
            String rutaPorId = uriObtenerTiempoPorId.replaceAll("\\?", "");
            return restTemplate.exchange(rutaPorId+"{id}", HttpMethod.GET, entity, Object.class, id.toString()).getBody();
            
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriObtenerTiempoPorId, e);
        }
    }

    /**
     * Crea o salva el tiempo pasado como argumento de llamada.
     * @param tiempo el tiempo a salvar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un objeto {@link TiempoEspecifico} con su ID generado
     */
    @Override
    public Object crear(RequestTiemposEspecDTO tiempo, String audit) {
        HttpEntity<RequestTiemposEspecDTO> entity = new HttpEntity<>(tiempo, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriCrearTiempo, HttpMethod.POST, entity, Object.class).getBody();
    }

    /**
     * Actualiza un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param tiempo el tiempo a actualizar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return la referencia al objeto {@link TiempoEspecifico} actualizado
     */
    @Override
    public Object actualizar(String id, RequestTiemposEspecDTO tiempo, String audit) {
        //ACTUALIZAR TIEMPO ESPECIFICO
        HttpEntity<RequestTiemposEspecDTO> entity = new HttpEntity<>(tiempo, StringUtil.obtenerHeaders(audit));
        String ruta = uriActualizarTiempo.replaceAll("\\?", "");
        return restTemplate.exchange(ruta+"{id}", HttpMethod.PUT, entity, Object.class, id.toString()).getBody();    
    }

    /**
     * Elimina el tiempo especificado de liquidez
     * @param id identificador unico del tiempo especifico de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto del tiempo especifico eliminado en liquidez
     */
    @Override
    public Object eliminar(String id, String audit) {    
        HttpEntity<String> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        String rutaDelete = uriDeleteTiempo.replaceAll("\\?", "");
        return restTemplate.exchange(rutaDelete + "{id}", HttpMethod.DELETE, entity, Object.class, id.toString()).getBody(); 
    }

    @Override
    public Object obtenerTodos(String audit) throws ServiceException {
        //CONSULTA TIEMPOS ESPECIFICOS
        try {                    
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriObtenerTiemposTodos, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriObtenerTiempoPorId, e);
        }
    }

}
