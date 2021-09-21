/**
 * 
 */
package mx.santander.liquidez.control.semaforo.service;

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
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-notificacion-service
* <br><b>Class:</b> KiwiSemaforoService.java
* <br><b>Description:</b> Clase Service que parametriza el rango de activacion
* de los semaforos de los sistemas de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 16 oct. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 16 oct. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*
*/
@Service
public class KiwiSemaforoService implements IKiwiSemaforoService {
    
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
    @Value("${control.endpoint.notificacion.semaforos.cons}")
    private String urlConsSemaforo;
    
    /**
     * Variable urlUpdSemaforo de tipo String
     */
    @Value("${control.endpoint.notificacion.semaforos.upt}")
    private String urlUpdSemaforo;

    /**
     * Metodo que consulta los semaforos del rol solicitado en liquidez
     * @param rol identificador unico de rol del usuario que consulta los semaforos
     * @param flagDia - bandera para identificar si se consulta los kiwis actuales o T + 1
     * @return objeto SemaforoBalanceDTO con los datos de los semaforos obtenidos
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public Object consultaSemaforos(String rol, int flagDia) throws ServiceException {
        //CONSULTA SEMAFOROS
        try {            
            Map<String, String> encabezados = new HashMap<String, String>();
            encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
            encabezados.put(ACCEPT, APPLICATION_JSON);
            return UtilRestClient.executeServiceRest(null, encabezados, StringUtil.concat(urlConsSemaforo.replaceAll("\\?", rol),"/", flagDia), HttpMethod.POST);            
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO NOTIFICACION
            throw new ServiceException(CodigoError.CLIENTE_REST, StringUtil.concat(urlConsSemaforo.replaceAll("\\?", rol),"/", flagDia), e);
        }    
    }

    @Override
    public Object actualizarSemaforo(SemaforoBalanceDTO semaforo) throws ServiceException {
        //GUARDA DIVISAS
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        //LLAMA SERVICIO PARAMETRIA
        return UtilRestClient.executeServiceRest(semaforo, encabezados, urlUpdSemaforo, HttpMethod.PUT);
    }
    
}
