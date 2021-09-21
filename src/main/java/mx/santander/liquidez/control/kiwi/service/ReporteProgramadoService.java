package mx.santander.liquidez.control.kiwi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ReporteProgramadoService.java
 * <br><b>Description:</b>
 * Clase creada para 
 *
 * @author FSW Lacertus Herwin Toral Rios
 * @company Praxis
 * @created 2 dic 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0  2 dic 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 *
 */
@Service
public class ReporteProgramadoService implements IReporteProgramadoService {
    
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
     * Variable urlConsSemaforo de tipo String
     */
    @Value("${control.endpoint.notificacion.programados.cons}")
    private String urlConsProgramados;
    
    /**
     * metodo para realizar la validacion y consulta de las operaciones progrmada
     * para saber cuanto nos deben y debemos 
     * 
     * @param fechaLiquidacion -  fecha a la cual se realiza la consulta
     * @return retorna el objeto con la informacion consultada.
     * @throws ServiceException - lanza una exception requerida
     */
    @Override
    public Object obtenerProgramadosByFecha(String fechaLiquidacion) throws ServiceException{
        String uriProgramadas = StringUtil.concat(urlConsProgramados, fechaLiquidacion);
        try {            
            Map<String, String> encabezados = new HashMap<String, String>();
            encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
            encabezados.put(ACCEPT, APPLICATION_JSON);
            return UtilRestClient.executeServiceRest(null, encabezados, uriProgramadas, HttpMethod.GET);            
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST, uriProgramadas, e);
        }    
    }
}
