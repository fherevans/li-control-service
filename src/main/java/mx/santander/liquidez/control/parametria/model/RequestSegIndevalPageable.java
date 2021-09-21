package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RequestSegIndevalPageable.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Victor Basurto Alonso
 * @since JDK:1.8
 * 
 * @company Praxis
 * @created 29 Oct. 2020
 * @category DTO
 */
@Data
@ToString
@EqualsAndHashCode
public class RequestSegIndevalPageable implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Variable page de tipo Integer
     */
    private Integer page;

    /**
     * Variable size de tipo Integer
     */
    private Integer size;

    /**
     * Variable idInst de tipo Integer
     */
    private Integer idInst;

    /**
     * Variable numFolInst de tipo Integer
     */
    private Integer numFolInst;

    /**
     * Variable allContrapartes de tipo String
     */
    private Boolean allContrapartes;

    /**
     * Variable fecha de tipo Date
     */

    private String fecha;

    /**
     * Variable mercado de tipo String
     */
    private String mercado;

    /**
     * Variable idContra de tipo Integer
     */
    private Integer idContra;

    /**
     * Variable folioContra de tipo Integer
     */
    private Integer folioContra;
    
    /**
     * Variable orderBy de tipo OrderByDTO
     */
    private OrderByDTO orderBy;

}
