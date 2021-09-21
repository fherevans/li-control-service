package mx.santander.liquidez.control.efectivo.dali.model;

import org.springframework.http.HttpStatus;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Clase:</b> BusinessException.java
 * <br><b>Description:</b>
 * Clase que define una excepción de negocio
 *
 * @author FSW Gustavo Adolfo Arellano Sandoval
 * @company CECoaching
 * @created 10 sep. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 0 sep. 2021: Creacion de la clase
 *
 * @category Exception
 * 
 */
public class BusinessException extends ControllerException {
    /**
     * Serial Version ID
     */
    private static final long serialVersionUID = 2712732146405212689L;

    /**
     * Constructor por defecto. Asigna valores fijos y arbitrarios a sus estado.
     */
    public BusinessException() {
        super(
            HttpStatus.INTERNAL_SERVER_ERROR, 
            "code", 
            "message", 
            "description", 
            "level",
            "moreInfo");
    }
    
    /**
     * Constructor basado en los parámetros definidos en un mensaje de error.
     * 
     * @param code
     * @param message
     * @param description
     * @param level
     * @param moreInfo
     */
    public BusinessException(String code, String message, String description, String level, String moreInfo) {
        super(
            HttpStatus.INTERNAL_SERVER_ERROR, 
            code, 
            message, 
            description, 
            level,
            moreInfo);
    }
}
