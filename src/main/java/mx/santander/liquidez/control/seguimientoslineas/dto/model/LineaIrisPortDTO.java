package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> LineaIrisPortDTO.java
* <br><b>Description:</b> Clase embebida en la Linea Iris.
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
@Embeddable
@Getter
@Setter
public class LineaIrisPortDTO implements Serializable {
    
    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 2694368790848033030L;

    /** Variable portafolio de tipo String. */
    protected String portafolio;
    
    /** Variable instrumento de tipo String. */
    protected String instrumento;
    
    /** Variable fechaVencimiento de tipo Date. */
    protected Date fechaVencimiento;
    
    
    
}
