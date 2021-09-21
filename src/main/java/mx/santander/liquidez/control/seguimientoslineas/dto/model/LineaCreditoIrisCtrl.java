package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TipoCambioDivisa.java
* <br><b>Description:</b> Clase embebida en la entidad TipoCambio.
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Marcos Magana Hernandez
* Creacion de clase
*
* @category Entity.
*
* @see TipoCambioDivisa
*/
@Getter
@Setter
public class LineaCreditoIrisCtrl implements Serializable {

    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = 8078242274806523609L;

    /** Variable instrumento de tipo String. */
    private String instrumento;
    
    /** Variable fechaCargaLinea de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaCargaLinea")
    private Date fechaCargaLinea;
    
}
