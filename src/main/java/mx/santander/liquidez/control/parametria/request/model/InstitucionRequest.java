/**
 * 
 */
package mx.santander.liquidez.control.parametria.request.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> InstitucionRequest.java
* <br><b>Description:</b> Clase Request para transportar los datos de la peticion
* de instituciones.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 19 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 19 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
@Setter
@Getter
public class InstitucionRequest implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 649234357401917084L;

    /**
     * Variable clave de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String clave;
    
    /**
     * Variable nombre de tipo int
     */
    @NotNull(message = "{message.validate.null}")
    private String nombre;
    
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
