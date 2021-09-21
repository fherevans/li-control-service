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
* <br><b>Class:</b> OperacionesRequest.java
* <br><b>Description:</b> Clase Request para transportar los datos de la peticion
* de operaciones.
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
public class OperacionesRequest implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 6138411716742000797L;

    /**
     * Variable clave de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String clave;
    
    /**
     * Variable grupo de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int grupo;
    
    /**
     * Variable canal de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int canal;

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
