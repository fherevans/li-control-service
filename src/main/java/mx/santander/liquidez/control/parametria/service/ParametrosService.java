package mx.santander.liquidez.control.parametria.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.parametria.model.Parametros;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ParametrosService.java
* <br><b>Description:</b> Clase Service con los metodos de negocio de parametros.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class ParametrosService implements IParametrosService {
    
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
     * Variable uriConsultaParametroGet de tipo String
     */
    @Value("${control.endpoint.parametros.get}")
    private String uriConsultaParametroGet;
    
    /**
     * Variable uriActualizaParametro de tipo String
     */
    @Value("${control.endpoint.parametros.put}")
    private String uriActualizaParametro;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object consultaParametro(String id,  String audit) throws ServiceException {
        //CONSULTA PARAMETRO
        String urlPar = uriConsultaParametroGet.replaceAll("\\?", "");
        return restTemplate.getForObject(urlPar+ "{id}", Object.class, id);
    }

    @Override
    public Object actualizaParametro(String id, String txtValor, String audit) throws ServiceException {
        //ACTUALIZA PARAMETRO
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        //LLAMA SERVICIO PARAMETRIA
        Parametros param = new Parametros();
        param.setId(id);
        param.setTxtValor(txtValor);
        return UtilRestClient.executeServiceRest(param, encabezados, uriActualizaParametro, HttpMethod.PUT);    
    }

    @Override
    public Object getAllStatusIndeval() throws ServiceException {
        return UtilRestClient.executeServiceRest(null, StringUtil.obtenerEncabezados(null), uriActualizaParametro + "/estatus_indeval", HttpMethod.GET);
    }

    /**
     * Consulta parametro especifico.
     * Metodo que realiza la busqueda de parametros
     * especificos de acuerdo a su id
     * @param id identificador del parametro a actualizar
     * @param audit valor que se necesita para el guardado de pistas auditoras
     * @return objeto con datos del parametro
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object consultaParametroEspecifico(String id, String audit) throws ServiceException {
        /*Consulta Parametro */
        String urlParametros = StringUtil.concat(uriConsultaParametroGet, "especificos/").replaceAll("\\?", "");
        return restTemplate.getForObject(urlParametros+ "{id}", Object.class, id);
    }

}
