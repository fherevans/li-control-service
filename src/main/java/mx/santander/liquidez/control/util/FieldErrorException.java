package mx.santander.liquidez.control.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-service
* <br><b>Class:</b> FieldErrorException.java
* <br><b>Description:</b> Excepcion generica para parametros incorrectos en las 
* peticiones de los servicios.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Exeption
*
*/
public class FieldErrorException extends Exception{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 3917757431882609829L;
    
    /**
     * Variable fieldsErrors de tipo List<FieldError>
     */
    private final List<FieldError> fieldsErrors;
    
    /**
     * Variable message de tipo String
     */
    private final String message;
    
    /**
     * Constructor de la excepcion generica FieldErrorBean
     * @param message mensaje de la excepcion
     * @param fieldsErrors errores de validaciones
     */
    public FieldErrorException(String message, List<FieldError> fieldsErrors) {
        super(message);
         this.fieldsErrors = new ArrayList<FieldError>(fieldsErrors);
         this.message = message;
    }

    /**
     * Metodo get para obtener el valor de la propiedad fieldsErrors
     * @return the fieldsErrors
     */
    public List<FieldError> getFieldsErrors() {
        return  new ArrayList<FieldError>(fieldsErrors);
    }

    /**
     * Metodo get para obtener el valor de la propiedad message
     * @return the message
     */
    @Override
    public String getMessage() {
        return message;
    }

}
