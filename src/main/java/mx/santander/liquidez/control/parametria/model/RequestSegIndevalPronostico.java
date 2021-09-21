package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RequestSegIndevalPronostico.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Victor Basurto Alonso
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Praxis, Nombre del autor: VBA Creacion de clase
 *          RequestSegIndevalPronostico
 * 
 * @since JDK1.8
 * 
 * @company Praxis
 * @created 29 Oct. 2020
 * @category DTO
 */

@Data
@ToString
@EqualsAndHashCode
public class RequestSegIndevalPronostico implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Variable idInst de tipo entero Getter Setter
     */
    private int idInst;

    /**
     * Variable numFolInst de tipo entero Getter Setter
     */
    private int numFolInst;

    /**
     * Variable para mapear una cadena de tipo fecha String Getter Setter
     */
    @NotNull
    private String fecha;

}
