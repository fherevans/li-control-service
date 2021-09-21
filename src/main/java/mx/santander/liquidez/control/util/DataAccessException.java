/**
 * 
 */
package mx.santander.liquidez.control.util;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> DataAccessException.java
 * <br><b>Description:</b>
 * Una clase wrapper enfocada a manejar excepciones que se
 * originen en la capa de acceso a datos.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Wrapper
 *
 */
public class DataAccessException extends Exception {
    
    /**
     * La serial version.
     */
    private static final long serialVersionUID = 3776905226153743029L;

    /**
     * Contiene un codigo de error.
     */
    private final CodigoError codigoError;

    /**
     * Crea una instancia con el mensaje y la causa especificados.
     * @param message el mensaje a establecer
     * @param cause la causa a establecer
     */
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
        this.codigoError = null;
    }

    /**
     * Crea una instancia con la causa especificada.
     * @param cause la causa a establecer
     */
    public DataAccessException(Throwable cause) {
        super(cause);
        this.codigoError = null;
    }
    
    /**
     * Crea una instancia con codigo de error, mensaje y causa especificados.
     * @param errorCode es el codigo de error a establecer
     * @param message el mensaje a establecer
     * @param cause la causa a establecer
     */
    public DataAccessException(CodigoError errorCode, String message,
            Throwable cause) {
        super(message, cause);
        this.codigoError = errorCode;
    }

    /** 
     * Regresa el valor del atributo codigoError.
     * @return el atributo codigoError
     */
    public CodigoError getCodigoError() {
        return codigoError;
    }
    
}
