package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> DiasInhabiles.java <br>
 * <b>Description:</b> Entity para clase.
 *
 * @author Marcos Magana Hernandez
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus 
 * Nombre del autor: Marcos Magana Hernandez
 *
 * @category DTO.
 *
 */
@Getter
@Setter
public class DiasInhabiles implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -3824673000409916009L;
    
    /**
     * Id dia inhabil.
     */    
    private Long idDia;
        
    /**
     * fecha de inhabil
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaInhabil")
    private Date fechaInhabil;
    
    /**
     * id pais
     */
    private String idPais;

    /**
     * Motivo
     */
    private String motivo;
        
    /**
     * fecha de carga.
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaCarga")
    private Date fechaCarga;

}
