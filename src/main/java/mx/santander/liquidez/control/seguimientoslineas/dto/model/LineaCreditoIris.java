package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import javax.persistence.Embedded;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> LineaCreditoIris.java
 * <br><b>Description:</b> Clase entity para obtener los datos de la tabla LIQ_MX_MAE_LINEA.
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 8 ago. 2019
 * @category Entity
 */
@Setter
@Getter
public class LineaCreditoIris implements Serializable {
    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = 5159045641008917919L;
    
    /**
     * Variable idLineaFk de tipo Long
     */
    private Long idLineaFk;
    
    /**
     * Variable lineas de tipo Linea
     */
    private Linea lineas;
                
    /**
     * Variable idDate de linea de crédito iris
     */
    @Embedded
    private IdDateLineaCreditoIris idDate;    
    
    /** Variable contraParte de tipo String. */
    private String contraParte;
        
    /** Variable lineaIntradiaDisponible de tipo Double. */
    private Double lineaIntradiaDisponible;
    
    /** Variable overNight de tipo Double. */
    private Double overNight;
    
    /** Variable lineaUtilizada de tipo Double. */
    private Double lineaUtilizada;
    
    /** Variable disponible de tipo Double. */
    private Double disponible;
                        
    /** Variable portafolio de tipo String. */
    private String portafolio;
        
    /** Variable lineaCreditoIrisCtrl de tipo LineaCreditoIrisCtrl */
    private LineaCreditoIrisCtrl lineaCreditoIrisCtrl;

}
