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
* <br><b>Class:</b> LineaCarteraDisponibleDTO.java
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
public class LineaCarteraDisponibleDTO implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = -5801369509256683587L;
            
    /** Variable fechaIngreso de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaIngreso")
    private Date fechaIngreso;
    
    /** Variable fechaVencimiento de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaVencimiento")
    private Date fechaVencimiento;
    
    /** Variable fechaTraspaso de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaTraspaso")
    private Date fechaTraspaso;
    
    /** Variable tazaBanco de tipo BigDecimal. */
    private double tasaBanco;
    
    /** Variable tazaBase de tipo BigDecimal. */
    private String tasaBase;
    
    /** Variable cveVigenciaVencida de tipo String. */
    private String cveVigenciaVencida;
    
    /** Variable fechaOperacion de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaOperacion")
    private Date fechaOperacion;
    
    /** Variable impConcedido de tipo BigDecimal. */
    private double impConcedido;
    
    /** Variable impDisponible de tipo BigDecimal. */
    private double impDisponible;

}
