/**
 * 
 */
package mx.santander.liquidez.control.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> Error.java
 * <br><b>Description:</b>
 * Define una clase de transporte para un conjunto de errores.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 6 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category DTO
 *
 */
public class Error implements Serializable {
    
    /**
     * La version de serial.
     */
    private static final long serialVersionUID = -1637824595285330980L;
    
    /**
     * Lista de errores.
     */
    private List<ErrorMessage> errors;
    
    /**
     * Constructor por defecto.
     */
    public Error() {
        super();
        errors = new ArrayList<>();
    }

    /** 
     * Regresa el valor del atributo errors
     * @return el atributo errors
     */
    public List<ErrorMessage> getErrors() {
        return new ArrayList<ErrorMessage>(errors);
    }

    /**
     * Establece el valor del atributo errors
     * @param errors el valor de errors a establecer
     */
    public void setErrors(List<ErrorMessage> errors) {
        List<ErrorMessage> copiaErrores = new ArrayList<>();
        copiaErrores.addAll(errors);
        this.errors = copiaErrores;
    }

    /**
     * Agrega el mensaje de error especifico en la lista de errores.
     * @param error el mensaje de error a agregar no nulo
     */
    public void addError(ErrorMessage error) {
        if (error != null) {
            errors.add(error);
        }
    }
    
    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Error [errors=");
        builder.append(errors);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Santander Mexico<br>
     * <br><b>Project:</b> li-procesamiento-service
     * <br><b>Class:</b> ErrorMessage.java
     * <br><b>Description:</b>
     * Clase de transporte para mensajes de error.
     *
     * @author FSW Lacertus Ricardo Camacho Montoya
     * @company Praxis
     * @created 6 ago. 2019
     * @since JDK1.8
     *
     * @version Control de cambios:
     * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
     *
     * @category DTO
     *
     */
    @Getter
    @Setter
    public static class ErrorMessage implements Serializable {
        
        /**
         * La version de serial.
         */
        private static final long serialVersionUID = -3877646673754254527L;
        
        /**
         * Es el codigo de mensaje.
         */
        protected String code;
        
        /**
         * Contiene una descripcion breve del error.
         */
        protected String message;
        
        /**
         * Es la descripcion del error.
         */
        protected String description;
        
        /**
         * Define el nivel del error.
         */
        protected String level;
        
        /**
         * Contiene informacion adicional que puede ayudar al usuario
         * a identificar la fuente del error.
         */
        protected String moreInfo;
        
        /**
         * Constructor por defecto.
         */
        public ErrorMessage() {
            super();
        }

        /**
         * Devuelve la representacion del objeto en <code>string</code>.
         * @return un <code>string</code>
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("ErrorMessage [code=");
            builder.append(code);
            builder.append(", message=");
            builder.append(message);
            builder.append(", description=");
            builder.append(description);
            builder.append(", level=");
            builder.append(level);
            builder.append(", moreInfo=");
            builder.append(moreInfo);
            builder.append("]");
            return builder.toString();
        }
        
    }

}
