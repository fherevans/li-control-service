/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> CuentasFiltrosDTO.java
* <br><b>Description:</b> Clase DTO para transportar los datos de la peticion
* de cuentas paginadas.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
@Setter
@Getter
public class CuentasFiltrosDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7632257673120832344L;

    /**
     * Variable tipoCuenta de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private Long tipoCuenta;
    
    /**
     * Variable clabe de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String clabe;
    
    /**
     * Variable cuenta de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String cuenta;
    
    /**
     * Variable pagina de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int pagina;
    
    /**
     * Variable size de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int size;
}
