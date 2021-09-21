/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> RequestTiemposEspecDTO.java
* <br><b>Description:</b> Clase request para realizar una peticion de alta de tiempo especifico.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
@Setter
@Getter
public class RequestTiemposEspecDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7262360245693367852L;
    
    /**
     * Variable id de tipo String
     */
    private Long id;
    
    /**
     * Variable idOper de tipo Long
     */
    private Long idOper;
    
    /**
     * Variable descipcion de tipo String
     */
    private String descripcion;
    
    /**
     * Variable horaMaxLiq de tipo String
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "CST", pattern = "HH:mm:ss")
    @JsonProperty("horaMaxLiq")
    private String horaMaxLiq;

    /**
     * Variable idUser de tipo String
     */
    private String idUserMod;
    
    /**
     * Variable fchCarga de tipo Date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchUltMod")
    private Date fchUltMod;

    /**
     * Variable fchCarga de tipo Date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchCarga")
    private Date fchCarga;

}
