package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> LineaCarteraAuxDTO.java
 * <br><b>Description:</b> DTO para almacenar los datos de producto cartera
 *
 * @author Vic Basurto Alo
 * @company Praxis
 * @created 03 Nov. 2020
 * @since JDK:1.8
 *
 * @category DTO.
 *
 */

@Data
@Embeddable
public class LineaCarteraAuxDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Variable centro de tipo String. */
    private String centro;
    
    /** Variable descCentro de tipo String. */
    private String descCentro;
    
    /** Variable sucursal de tipo String. */
    private String sucursal;
    
    /** Variable descSucursal de tipo String. */
    private String descSucursal;
    
    /** Variable subProducto de tipo String. */
    @Column(name = "TXT_SUB_PROD")
    private String subProducto;

    /** Variable descSubProducto de tipo String. */
    @Column(name = "TXT_DESC_SUB_PROD")
    private String descSubProducto;

}
