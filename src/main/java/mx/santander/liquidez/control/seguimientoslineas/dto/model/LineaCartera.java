package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import javax.persistence.Embedded;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> LineaCartera.java
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
public class LineaCartera implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 531058354675224799L;
    
    /**
     * Variable id de tipo LineaId
     */
    private Long id;
    
    /**
     * Variable lineas de tipo Linea
     */
    private Linea lineas;
     
    /**
     * Variable idProducto de linea cartera
     */
    @Embedded
    private LineaCarteraAuxDTO lineaCarteraAux;
    
    /** Variable tipoCredito de tipo String. */
    private String tipoCredito;
    
    /**  Variable lineaCarteraCte de tipo LineaCarteraCteDTO. */
    private LineaCarteraCteDTO lineaCarteraCte;

    /**  Variable lineaCarteraDisponible de tipo LineaCarteraDisponibleDTO. */
    private LineaCarteraDisponibleDTO lineaCarteraDisponible;
    
    /**  Variable lineaCarteraEntidad de tipo LineaCarteraEntidadDTO. */
    private LineaCarteraEntidadDTO lineaCarteraEntidad;
}
