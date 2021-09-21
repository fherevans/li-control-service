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
 * <b>Class:</b> RequestSegIndevalOperPageable.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Victor Basurto Alonso
 * @since JDK:1.8
 * 
 * @company Praxis
 * @created 18 Nov. 2020
 * @category DTO
 */
@Data
@ToString
@EqualsAndHashCode
public class RequestSegIndevalOperPageable implements Serializable {

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
     * Variable institucion de tipo Integer
     */
    private Integer idInst;
    
    /**
     * Variable numFolInst de tipo Integer
     */
    private Integer numFolInst;

    /**
     * Variable idContra de tipo Integer
     */
    private Integer idContra;
    
    /**
     * Variable folioContra de tipo Integer
     */
    private Integer folioContra;
    
    /**
     * Variable area de tipo String
     */
    private String area;

    /**
     * Variable segIndevalAux de tipo RequestSegIndevalOperAuxDTO
     */
    private RequestSegIndevalOperAuxDTO segIndevalAux;

}
