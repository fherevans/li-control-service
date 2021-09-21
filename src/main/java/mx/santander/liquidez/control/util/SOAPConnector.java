package mx.santander.liquidez.control.util;
 
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> SOAPConnector.java
* <br><b>Description:</b> Objeto para consumir un WS Soap como cliente.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo, 
* Creacion de clase
*
* @category Util
*
*/
public class SOAPConnector extends WebServiceGatewaySupport {
 
    /**
     * Metodo para llamar un WS Soap
     * @param url end point donde esta expuesto el WS Soap
     * @param request objeto de entrada para el WS Soap
     * @return response objeto de salida del WS Soap
     */
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}