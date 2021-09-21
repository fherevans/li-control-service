package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import lombok.Data;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RequestSegIndevalDetalleDTO.java <br>
 * <b>Description:</b> Clase Request con parametros de entrada para la consulta
 * del detalle de las operaciones de indeval
 *
 * @author Christian Ivan Miranda Paulin
 * @company Praxis
 * @created 24 feb. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 24 feb. 2021 IVPA, Creacion de clase
 *
 * @category DTO
 *
 */
@Data
public class RequestSegIndevalDetalleDTO implements Serializable {
    
    /**
     * Version Serial
     */
    private static final long serialVersionUID = 7668604058393097032L;

    /**
     * Variable area de tipo String
     */
    private String area;
    
    /**
     * Variable numFolInst de tipo Integer
     */
    private Integer numFolInst;
    
    /**
     * Variable institucion de tipo Integer
     */
    private Integer idInst;

    /**
     * Variable folioContra de tipo Integer
     */
    private Integer folioContra;

    /**
     * Variable idContra de tipo Integer
     */
    private Integer idContra;
    
    /**
     * Variable segIndevalAux de tipo RequestSegIndevalOperAuxDTO
     */
    private RequestSegIndevalOperAuxDTO segIndevalAux;
}
