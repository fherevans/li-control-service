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
import mx.santander.liquidez.control.parametria.model.Cuentas;
import mx.santander.liquidez.control.parametria.model.CuentasFiltrosDTO;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> CuentasService.java <br>
 * <b>Description:</b> Clase Service para consumir los servicios de cuentas de liquidez
 *
 * @author Manuel Gonzalez Quillo
 * @company Praxis
 * @created 21 nov. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 sep. 2019 FSW Lacertus Nombre del autor: Jose Manuel Gonzalez Quillo
 * Creacion de clase
 *
 * @category Controller
 *
 */
@Service
public class CuentasService implements ICuentasService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CuentasService.class);

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
     * Variable uriConsultaCuentas de tipo String
     */
    @Value("${control.endpoint.cuentas.get.all}")
    private String uriConsultaCuentas;
    
    /**
     * Variable uriCreaCienta de tipo String
     */
    @Value("${control.endpoint.cuentas.post}")
    private String uriCreaCuenta;

    /**
     * Variable uriConsultaCuentasDet de tipo String
     */
    @Value("${control.endpoint.cuentas.detalle}")
    private String uriConsultaCuentasDet;
    
    /**
     * Variable uriActualizaCuentas de tipo String
     */
    @Value("${control.endpoint.cuentas.put}")
    private String uriActualizaCuentas;

    /**
     * Variable uriEliminaCuentas de tipo String
     */
    @Value("${control.endpoint.cuentas.delete}")
    private String uriEliminaCuentas;
    
    /**
     * Variable uriConsultaTiposCuentas de tipo String
     */
    @Value("${control.endpoint.cuentas.tipos}")
    private String uriConsultaTiposCuentas;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object crearCuenta(Cuentas cuentas, String audit) {
        //LLAMA SERVICIO PARAMETRIA
        HttpEntity<Cuentas> entity = new HttpEntity<>(cuentas, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriCreaCuenta, HttpMethod.POST, entity, Cuentas.class).getBody();
    }

    @Override
    public CustomPageImpl<Cuentas> obtenerCuentas(CuentasFiltrosDTO filtros, String audit) {
        Gson gson = new Gson();
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        headers.add(AUDIT, audit);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<Cuentas>> response = restTemplate.exchange(uriConsultaCuentasDet, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<Cuentas>>() {});
        LOGGER.info("Obtencion de cuentas con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

    @Override
    public Object eliminarCuenta(Long id, String audit) throws ServiceException {
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(null, StringUtil.obtenerEncabezados(audit), 
                uriEliminaCuentas.replaceAll("\\?", id.toString()), HttpMethod.DELETE);
    }

    @Override
    public Object actualizarCuenta(Cuentas cuenta, String audit) {
        //ACTUALIZA CUENTA
        //LLAMA SERVICIO PARAMETRIA
        HttpEntity<Cuentas> entity = new HttpEntity<>(cuenta, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriActualizaCuentas.replaceAll("\\?", cuenta.getIdCuenta().toString()), HttpMethod.PUT, entity, Cuentas.class).getBody();

    }

    @Override
    public Object consultaCuentas(String audit) throws ServiceException {
        //CONSULTA CUENTAS
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaCuentas, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaCuentas, e);
        }
    }

    @Override
    public Object consultaTipoCuentas(String audit) throws ServiceException {
        //CONSULTA TIPO DE CUENTAS
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            return restTemplate.exchange(uriConsultaTiposCuentas, HttpMethod.GET, entity, Object.class).getBody();
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriConsultaTiposCuentas, e);
        }
    }

}
