package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> Sistema.java <br>
 * <b>Description:</b> Entity para clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Entity.
 *
 */
@Getter
@Setter
public class Sistema implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 4057882143888021488L;

    /**
     * Id sistema.
     */
    private String idSistema;

    /**
     * Nombre del sistema.
     */
    private String nombre;

    /**
     * Tipo de pago.
     */
    private String tipoPago;

    /**
     * Tipo de cobro.
     */
    private String tipoCobro;

    /**
     * Tipo de liquidez.
     */
    private String tipoLiq;
    
    /**
     * fecha de apertura.
     */
    @Column(name = "FCH_APERT")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaApertura")
    private Date fechaApertura;
    
    /**
     * fecha de cierre.
     */
    @Column(name = "FCH_CIERR")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaCierre")
    private Date fechaCierre;
    
    /**
     * fecha de carga.
     */
    @Column(name = "FCH_CARGA")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaCarga")
    private Date fechaCarga;

}
