package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> LineaCarteraEntidadDTO.java
* <br><b>Description:</b> Clase embebida en la Linea Cartera
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 18 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category Entity
*
*/
@Getter
@Setter
public class LineaCarteraEntidadDTO implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 4376625544638642868L;
    
    /** Variable impDisposiciones de tipo BigDecimal. */
    private double impDisposiciones;
    
    /** Variable codigoEntidad de tipo String. */
    private String codigoEntidad;
    
    /** Variable impTotalDeuda de tipo BigDecimal. */
    private double impTotalDeuda;
    
    /** Variable situacionCredito de tipo String. */
    private String situacionCredito;
    
    /** Variable tipoCuenta de tipo String. */
    private String tipoCuenta;    
    
    /** Variable numCuenta de tipo int. */
    private int numCuenta;

}
