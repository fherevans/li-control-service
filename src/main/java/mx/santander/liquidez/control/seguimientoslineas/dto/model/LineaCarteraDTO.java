package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> LineaCarteraDTO.java
 * <br><b>Description:</b> DTO para almacenar los datos Lineas Cartera
 *
 * @author FSW Marcos Magana Hernandez
 * @company Praxis
 * @created 17 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 *
 * @category DTO.
 *
 */
@Getter
@Setter
public class LineaCarteraDTO implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 531058354675224799L;
    
    /** Variable idLineaFk de tipo Long. */
    protected Long idLineaFk;
        
    /** Variable centro de tipo String. */
    protected String centro;
    
    /** Variable descCentro de tipo String. */
    protected String descCentro;
    
    /** Variable sucursal de tipo String. */
    protected String sucursal;
    
    /** Variable descSucursal de tipo String. */
    protected String descSucursal;
    
    /** Variable descSucursal de tipo String. */
    protected String subProducto;
    
    /** Variable descSubProducto de tipo String. */
    protected String descSubProducto;
    
    /** Variable tipoCredito de tipo String. */
    protected String tipoCredito;
    
    /** Variable numCuenta de tipo int. */
    protected int numCuenta;
    
    /**  Variable lineaCarteraCte de tipo LineaCarteraCteDTO. */
    @Embedded
    @Valid
    protected LineaCarteraCteDTO lineaCarteraCte = new LineaCarteraCteDTO();
    
    
    


}
