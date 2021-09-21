/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SeguimientoSpeiSpidDTO.java
* <br><b>Description:</b> Clase DTO para ingresar los filtros de la consulta del 
* Seguimiento de SPEI y SPID.
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
public class SeguimientoSpeiSpidDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7477548623078432978L;
    
    /**
     * Variable bancos de tipo List<String>
     */
    @NotNull(message = "{message.validate.null}")
    private List<String> bancos;
    
    /**
     * Variable tiposPagos de tipo List<String>
     */
    @NotNull(message = "{message.validate.null}")
    private List<String> tiposPagos;
    
    /**
     * Variable canales de tipo List<String>
     */
    @NotNull(message = "{message.validate.null}")
    private List<String> canales;
    
    /**
     * Variable fecha de tipo Date
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", locale = "es_MX", timezone = "America/Mexico_City")
    @JsonProperty("fecha")
    private String fecha;
    
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
