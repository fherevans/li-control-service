/**
 * 
 */
package mx.santander.liquidez.control.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.santander.liquidez.control.util.Error.ErrorMessage;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> ErrorUtil.java
 * <br><b>Description:</b>
 * Clase util para crear instancias de errores.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 6 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Util
 * 
 */
public final class ErrorUtil {
    
    /**
     * La instancia de logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ErrorUtil.class);
    
    /**
     * Constructor privado.
     */
    private ErrorUtil() {
        super();
    }
    
    /**
     * Obtiene un objeto {@link Error} con la informacion proporcionada.
     * @param e referencia a una excepcion de servicio
     * @return la instancia de error generada
     */
    public static Error obtenerUsando(ServiceException e) {
        Error error = new Error();
        ErrorMessage errorMessage = new ErrorMessage();
        
        /* Codigo de error. */
        CodigoError codigoError = e.getCodigoError();
        if (codigoError != null) {
            errorMessage.setCode(codigoError.valor());
            errorMessage.setMessage(codigoError.razon());
            errorMessage.setLevel(codigoError.nivel().valor());
        } else {
            errorMessage.setCode(CodigoError.NO_ESPECIFICADO.valor());
            errorMessage.setMessage(CodigoError.NO_ESPECIFICADO.razon());
            errorMessage.setLevel(CodigoError.NO_ESPECIFICADO.nivel().valor());
        }
        
        /* Excepcion. */
        errorMessage.setDescription(e.getMessage());
        if (e.getCause() != null) {
            errorMessage.setMoreInfo(e.getCause().getMessage());
        }
        
        /* Agrega */
        error.addError(errorMessage);
        return error;
    }
    
    /**
     * Obtiene un objeto {@link Error} con la informacion proporcionada.
     * @param e referencia a una excepcion de runtime
     * @return la instancia de error generada
     */
    public static Error obtenerUsando(RuntimeException e) {
        Error error = new Error();
        ErrorMessage errorMessage = new ErrorMessage();
        
        /* Codigo de error. */
        errorMessage.setCode(CodigoError.CONFLICTO.valor());
        errorMessage.setMessage(CodigoError.CONFLICTO.razon());
        errorMessage.setLevel(CodigoError.CONFLICTO.nivel().valor());
        
        /* Excepcion. */
        errorMessage.setDescription(e.getMessage());
        if (e.getCause() != null) {
            errorMessage.setMoreInfo(e.getCause().getMessage());
        }
        
        /* Agrega */
        error.addError(errorMessage);
        return error;
    }
    
    /**
     * Crea una instancia de excepcion de servicio a partir de una
     * excepcion de acceso a datos.
     * @param dae es la referencia a una excepcion a acceso a datos
     * @return una instancia del tipo {@link ServiceException}
     */
    public static ServiceException obtenerUsando(DataAccessException dae) {
        /* Codigo. */
        CodigoError codigo = dae.getCodigoError();
        /* Mensaje. */
        StringBuilder mensaje = new StringBuilder();
        if (dae.getCause() != null) {
            mensaje.append("Causa: ");
            mensaje.append(dae.getCause().getMessage());
        } else {
            mensaje.append("Causa no especificada");
        }
        /* Crea. */
        return new ServiceException(codigo, mensaje.toString(), dae);    
    }
    
    /**
     * Metodo para parsear respuesta de error de los servicios de liqudiez.
     * @param exception excepcion que contiene el cuerpo del error
     * @return una instancia de {@link Error} con la informacion del error
     */
    public static Error responseBodyToError(HttpStatusCodeException exception) {
        Error result = null;
        String responseString = exception.getResponseBodyAsString();
        ObjectMapper mapper = new ObjectMapper();
        try {
             result = mapper.readValue(responseString, Error.class);
        } catch (JsonParseException e) {
            result = obtenerUsando(e);
            LOGGER.error("ERROR AL PARSEAR VALOR DE LAS PROPIEDADES DE LA RESPUESTA A UN OBJETO ERROR ........ \n", e);
        } catch (JsonMappingException e) {
            result = obtenerUsando(e);
            LOGGER.error("ERROR AL MAPEAR PROPIEDADES DE LA RESPUESTA A UN OBJETO ERROR ........ \n", e);
        } catch (IOException e) {
            result = obtenerUsando(e);
            LOGGER.error("ERROR AL PARSEAR RESPONSE BODY DE LA PETICION ........ \n", e);
        }
        return result;
    }
    
    /**
     * Obtiene un objeto {@link Error} con la informacion proporcionada.
     * @param e es la referencia a una excepcion
     * @return la instancia de error generada
     */
    public static Error obtenerUsando(Exception e) {
        Error error = new Error();
        ErrorMessage errorMessage = new ErrorMessage();
        
        /* Codigo de error. */
        errorMessage.setCode(CodigoError.CLIENTE_REST.valor());
        errorMessage.setMessage(CodigoError.CLIENTE_REST.razon());
        errorMessage.setLevel(CodigoError.CLIENTE_REST.nivel().valor());
        
        /* Excepcion. */
        errorMessage.setDescription(e.getMessage());
        if (e.getCause() != null) {
            errorMessage.setMoreInfo(e.getCause().getMessage());
        }
        
        /* Agrega */
        error.addError(errorMessage);
        return error;
    }
    
}
