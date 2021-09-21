package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IdDateLineaCreditoIris.java
 * <br><b>Description:</b> DTO para almacenar los datos Lineas Créditos Iris
 *
 * @author Vic Basurto Alo
 * @company Praxis
 * @created 03 Nov. 2020
 * @since JDK:1.8
 *
 * @category DTO.
 *
 */

@Data
@Embeddable
public class IdDateLineaCreditoIris implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Variable fechaHora de tipo Date. */
    @Column(name = "FCH_VALOR")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "CST")
    @JsonProperty("fechaHora")
    private Date fechaHora;

    /** Variable fechaActualizacion de tipo Date. */
    @Column(name = "FCH_ACT")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "CST")
    @JsonProperty("fechaActualizacion")
    private Date fechaActualizacion;

}
