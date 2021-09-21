package mx.santander.liquidez.notificacion.model;

import java.io.Serializable;

import lombok.Data;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ReporteContraparte.java
* <br><b>Description:</b> DTO.
*
* @author Victor Basurto Alonso
* @company Praxis
* @created 01 Nov. 2020
* @since JDK:1.8
*
* @category DTO.
*
*/

@Data
public class ReporteContraparte implements Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6481891480033067791L;

    /**
     * Variable nombreContraparte de tipo String
     */
    private String nombreContraparte;
    
    /**
     * Variable montoContraparte de tipo String
     */
    private String montoContraparte;
    
    /**
     * Variable fechaLiquidacion de tipo String
     */
    private String fechaLiquidacion;
    
    /**
     * Variable pagoCobro de tipo String
     */
    private String pagoCobro;
}
