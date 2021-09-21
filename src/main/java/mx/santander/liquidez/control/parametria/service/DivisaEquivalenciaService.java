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
import mx.santander.liquidez.control.parametria.model.DivisaEquivalencia;
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaDivDTO;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> DivisaEquivalenciaService.java <br>
 * <b>Description:</b> Clase Service para implementar los metodos de negocio de divisas
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 4 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Service
 *
 */
@Service
public class DivisaEquivalenciaService implements IDivisaEquivalenciaService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DivisaEquivalenciaService.class);
    
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
     * uri para divisas.
     */
    @Value("${control.endpoint.equivalencia.divisas.get.all}")
    private String uriConsultaDivisas;
    
    /**
     * Variable uricreaDivisas de tipo String
     */
    @Value("${control.endpoint.equivalencia.divisas.post}")
    private String uriCreaDivisas;

    /**
     * Variable uriConsultaDivisasDet de tipo String
     */
    @Value("${control.endpoint.equivalencia.divisas.detalle}")
    private String uriConsultaDivisasDet;
    
    /**
     * Variable uriActualizaDivisas de tipo String
     */
    @Value("${control.endpoint.equivalencia.divisas.put}")
    private String uriActualizaDivisas;
    
    /**
     * Variable uriEliminaDivisas de tipo String
     */
    @Value("${control.endpoint.equivalencia.divisas.delete}")
    private String uriEliminaDivisas;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Implementacion del metodo para crear una nueva equivalencia divisa en liquidez.
     * @param divisaEquivalencia atributos {@link DivisaEquivalencia} de la divisa
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia objeto con la entidad creada de divisa.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object crearDivisaEquivalencia(DivisaEquivalencia divisaEquivalencia, String audit) {
        //CREA EQUIVALENCIA DE DIVISA
        HttpEntity<DivisaEquivalencia> entity = new HttpEntity<>(divisaEquivalencia, StringUtil.obtenerHeaders(audit));
        //LLAMA SERVICIO PARAMETRIA
        return restTemplate.exchange(uriCreaDivisas, HttpMethod.POST, entity, Object.class).getBody();
    }

    /**
     * Implementacion del metodo para obtener todas las equivalencias de divisas paginado.
     * @param filtros fintros para la consulta de equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia lista de divisas de la consulta paginada
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    @Override
    public CustomPageImpl<DivisaEquivalencia> obtenerTodasDivisasEquivalencias(FiltroEquivalenciaDivDTO filtros, String audit) {
        Gson gson = new Gson();
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add("audit", audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<DivisaEquivalencia>> response = restTemplate.exchange(uriConsultaDivisas, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<DivisaEquivalencia>>() {});
        LOGGER.info("Obtencion de divisas equivalencia con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    /**
     * Implementacion del metodo para eliminar divisa equivalencia.
     * @param id identificador unico de divisa equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    @Override
    public Object eliminarDivisaEquivalencia(Long id, String audit) {
        //ELIMINA EQUIVALENCIA DE DIVISA
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        //LLAMA SERVICIO PARAMETRIA
        return restTemplate.exchange(uriEliminaDivisas.replaceAll("\\?", id.toString()), HttpMethod.DELETE, entity, Object.class).getBody();

    }

    /**
     * Metodo para actualizar divisa de equivalencia
     * @param divEqu divisa equivalencia para actualizar.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia entidad de la divisa actualizada.
     */
    @Override
    public Object actualizarDivisaEquivalencia(DivisaEquivalencia divEqu, String audit) {
        //ACTUALIZA EQUIVALENCIA DE DIVISAS
        HttpEntity<DivisaEquivalencia> entity = new HttpEntity<>(divEqu, StringUtil.obtenerHeaders(audit));
        //LLAMA SERVICIO PARAMETRIA
        return restTemplate.exchange(uriActualizaDivisas.replaceAll("\\?", divEqu.getIdEquiv().toString()), HttpMethod.PUT, entity, Object.class).getBody();
    }

    @Override
    public Object consultaDivisas(String audit) throws ServiceException {
        //CONSULTA DIVISAS EQUIVALENCIA
        try {
            HttpEntity<String> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaDivisasDet, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaDivisasDet, e);
        }
    }

}
