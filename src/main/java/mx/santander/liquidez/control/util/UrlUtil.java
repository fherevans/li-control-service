package mx.santander.liquidez.control.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.owasp.encoder.Encode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> UrlUtil.java
* <br><b>Description:</b> Clase para validar si una url es valida
*
* @author Carlos Rafael Robles Rodriguez
* @company Praxis
* @created 22 oct. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 22 oct. 2020 FSW Praxis, Nombre del autor: Carlos Rafael Robles Rodriguez
* Creacion de clase
*
* @category Util
*
*/
public final class UrlUtil {
    
     /**Constante URL_EXPRESION de tipo String */
     private static final String URL_EXPRESION =
                "^((((https?|http?)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)([).!';/?:, ][[:blank:]])?$";
          
    /**
     * Constructor privado de la clase
     */
    private UrlUtil() {
        
    }
    
    /** Metodo para obtener del Throwable la traza 
     * de una forma segura     
     * @param  t  Throwable objeto con la informacion de la traza      
     * @return String   Cadena con la traza codificada      
     */  
    public static String getSafeTrace(Throwable t) {
    
        /**
         *  se utiliza la libreria para obtener la traza en cadena 
         */
        String resp = "\n".concat(ExceptionUtils.getStackTrace(t));
        /**
         *  se realiza la codificacion 
         */
        resp = Encode.forJava(resp); 
        return (resp);     
        }

    /**
     * is valida Url.
     * Metodo que realiza la validacion de la url
     * que se va invocar
     * @param url the url
     * @return the url
     * @throws ServiceException the service exception
     */
    public static URI isValidaURL(String url) throws ServiceException{
        URI uri = null;
        UrlValidator validar = new UrlValidator();
        try {
            if(validar.isValid(url)) {
                uri = new URI(url);
                return uri;    
            } else {
                throw new ServiceException(CodigoError.CONFLICTO, 
                        StringUtil.concat("ERROR URL INVALIDA ", url),  
                        new MalformedURLException() );
            }
        } catch (URISyntaxException e) {
            /* Error*/
            throw new ServiceException("ERROR URL NO CORRECTA: ", e);
        }
    }
    
    /**
     * Checks if is valida URL expresion.
     * Metodo que valida la url
     * con una expresion regular para
     * determinar si es valida o incorrecta
     * @param url the url
     * @return the uri
     * @throws ServiceException the service exception
     */
    public static URI isValidaURLExpresion(String url) throws ServiceException {
        Pattern pattern = Pattern.compile(URL_EXPRESION);
        Matcher matcher = pattern.matcher(url);
        URI uri = null;
        try {
            if (matcher.matches()) {
                uri = new URI(url);
                return uri;
            } else {
                throw new ServiceException(CodigoError.CONFLICTO, 
                        StringUtil.concat("ERROR URL INVALIDA ", url),
                        new MalformedURLException());
            }
        } catch (URISyntaxException e) {
            /* Error*/
            throw new ServiceException("ERROR URL SYNTAX NO CORRECTA: ", e);
        }
    }

}
