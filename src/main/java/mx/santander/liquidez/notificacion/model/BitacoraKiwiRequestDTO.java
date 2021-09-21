package mx.santander.liquidez.notificacion.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> BitacoraKiwiRequestDTO.java
* <br><b>Description:</b> Clase DTO para paginacion de bitacora de kiwis.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
public class BitacoraKiwiRequestDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 8312838313908514980L;
    
    /**
     * Variable idRol de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String idRol;
    
    /**
     * Variable fecha de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String fecha;
    
    /**
     * Variable color de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String color;
    
    /**
     * Variable sistema de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String sistema;
    
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
