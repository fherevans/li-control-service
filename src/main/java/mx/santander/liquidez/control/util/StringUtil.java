/**
 * 
 */
package mx.santander.liquidez.control.util;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

/**
 * A util class for any service or component which needs use
 * common functionality.
 * 
 * @author Ricardo Camacho Montoya
 * @version 1.0 
 * @since JDK1.8
 * @category Business Model Class
 * 
 */

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> StringUtil.java
 * <br><b>Description:</b>
 * Clase utilidad para componentes que necesiten ciertos metodos
 * comunes de funcionalidad con <code>Strings</code>.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 26, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 26, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Util
 *
 */
public final class StringUtil {
    
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
     * Constructor privado.
     */
    private StringUtil() {
        super();
    }
    
    /**
     * Concatena los objetos dados en una representacion de <code>String</code>.
     * @param objs los objetos a concatenar
     * @return el <code>String</code> generado
     */
    public static String concat(Object ... objs) {
        if (objs == null) {
            return "null";
        }
        StringBuilder sBuilder = new StringBuilder();
        for (Object obj : objs) {
            sBuilder.append(obj);
        }
        return sBuilder.toString();
    }
        
    
    /**
     * Metodo para parsear un valor numerico de cadena a intero
     * @param cadena valor a parsear
     * @return valor de tipo numero
     */
    public static int parseStringToInt(String cadena) {
        int numero = 0;
        try {
            numero = Integer.parseInt(cadena);
        } catch (NumberFormatException nfe){
            numero = -1;
        }
        return numero;
    }
    
    /**
     * Obtener headers.
     * Metodo que es el encargado
     * de obtener el valor
     * de los headers que corresponde
     * a el ususario para enviarlo, almacenarlo
     * en las pistas auditoras
     * @param request encargado de obtener los valores de los Headers
     * @return regresa el valor obtenido del parametro
     */
    public static String obtenerHeadersAudit(HttpServletRequest request) {
        return request.getHeader(AUDIT);
    }
    
    /**
     * Obtener headers.
     * Metodo que realiza el seteo
     * de los headers a utilizar 
     * para el envio de pistas
     * @param value the value
     * @return the http headers
     */
    public static HttpHeaders obtenerHeaders (String value) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON);
        headers.set(ACCEPT, APPLICATION_JSON);
        headers.set(AUDIT, value);
        return headers;
    }
    
    /**
     * Metodo que realiza
     * el seteo de los valores de encabezado para
     * el consumo del rest template 
     * @param audit parametro n utilizado para las pistas auditoras
     * @return mapeo de valores
     */
    public static Map<String, String> obtenerEncabezados(String audit){
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        encabezados.put(AUDIT, audit);
        return encabezados;
    }
}
