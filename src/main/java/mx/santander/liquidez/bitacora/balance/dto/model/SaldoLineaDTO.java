package mx.santander.liquidez.bitacora.balance.dto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> LineaCreditoIrisCtrlDTO.java
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
public class SaldoLineaDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long usado en la clase.
     * by: tori 
     */
    private static final long serialVersionUID = -4637189805172395654L;

    /** Variable valor de tipo Double */    
    protected BigDecimal valor;
    
    /** Variable fecha de tipo Date */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fecha")
    protected Date fecha;

}
