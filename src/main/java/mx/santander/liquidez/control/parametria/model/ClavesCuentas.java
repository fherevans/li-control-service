/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> ClavesCuentas.java
* <br><b>Description:</b> Clase auxiliar Entity para mapear la tabla LIQ_MX_MAE_CAT_CTA_APROV.
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
public class ClavesCuentas implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3976984816269101808L;

    /**
     * Variable cuenta de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    @Size(min = 1, max = 25, message = "message.size.maxima")
    private String cuenta;

    /**
     * Variable ctaClabe de tipo String
     */
    @NotNull(message = "message.validate.null")
    @Size(min = 0, max = 20, message = "message.size.maxima")
    private String clabe;
    
    /**
     * Variable codBuc de tipo String
     */
    @NotNull(message = "message.validate.null")
    @Size(min = 0, max = 25, message = "message.size.maxima")
    private String codBuc;
    
    /**
     * Variable codBic de tipo String
     */
    @NotNull(message = "message.validate.null")
    @Size(min = 0, max = 13, message = "message.size.maxima")
    private String codBic;
    
    /**
     * Variable stat de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    @Size(min = 1, max = 1, message = "message.size.maxima")
    private String estatus;
    
    /**
     * Variable nombre de tipo String
     */
    @NotNull(message = "message.validate.null")
    @NotBlank(message = "message.validate.blank")
    @Size(min = 1, max = 35, message = "message.size.maxima")
    private String nombre;
    
}
