package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RequestInstitucionIndeval.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Victor Basurto Alonso
 * @since JDK:1.8
 * 
 * @company Praxis
 * @created 01 Dic. 2020
 * @category DTO
 */

@Data
@ToString
@EqualsAndHashCode
public class RequestInstitucionIndeval implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /**
     * Variable idInst de tipo Integer
     */
    private Integer idInst;
    /**
     * Variable numFolInst de tipo Integer
     */
    private Integer numFolInst;
    /**
     * Variable nombreCorto de tipo String
     */
    private String nombreCorto;
    /**
     * Variable razonSocial de tipo String
     */
    private String razonSocial;
    /**
     * Variable idusrUltMod de tipo String
     */
    private String idusrUltMod;
    /**
     * Variable fchUltMod de tipo Date
     */
    private Date fchUltMod;
    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchCarga;
    
    /**
     * Variable cuentaClabe de tipo String
     */
    private String cuentaClabe;
    
    /**
     * Variable riesgoContrapartida de tipo String
     */
    private BigDecimal riesgoContrapartida;
    
    /**
     * Variable perteneceGrupo de tipo String
     */
    private Boolean perteneceGrupo; 
    
    
}
