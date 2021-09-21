/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> Cuentas.java
* <br><b>Description:</b> Clase Entity para mapear la tabla LIQ_MX_MAE_CAT_TIP_CTA.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 20 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 20 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Entity
*
*/
@Setter
@Getter
public class TipoCuentas implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3976984816269101808L;
    
    /**
     * Variable idTipoCuenta de tipo Long
     */
    private Long idTipoCuenta;

    /**
     * Variable nomTipCuenta de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    @Size(min = 1, max = 25, message = "message.size.maxima")
    private String nomTipCuenta;
    
    /**
     * Variable idUsrMod de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    @Size(min = 1, max = 15, message = "message.size.maxima")
    private String idUsrMod ;
    
    /**
     * fecha de la modificacion.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchUltMod")
    private Date fchUltMod;

    /**
     * fecha de carga.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchCarga")
    private Date fchCarga;
}
