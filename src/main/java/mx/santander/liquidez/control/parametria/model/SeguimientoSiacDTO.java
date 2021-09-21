/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SeguimientoSiacDTO.java
* <br><b>Description:</b> Clase DTO para ingresar los filtros de la consulta del 
* Seguimiento de SIAC.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
public class SeguimientoSiacDTO implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 4796415985675897542L;

    /**
     * Variable divisa de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    private String divisa;

    /**
     * Variable tipo de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    private String tipo;
    
    /**
     * Variable fecha de tipo Date
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", locale = "es_MX", timezone = "America/Mexico_City")
    @JsonProperty("fecha")
    private String fecha;

}
