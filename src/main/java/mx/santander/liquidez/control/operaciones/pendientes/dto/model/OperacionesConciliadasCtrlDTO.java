package mx.santander.liquidez.control.operaciones.pendientes.dto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-ctrl-monitor-service <br>
 * <b>Class:</b> OperacionesConciliadasCtrlDTO.java <br>
 * <b>Description:</b> Clase embebida en la entidad Operaciones Conciliadas
 *
 * @author FSW Marcos Magana Hernandez
 * @company Praxis
 * @created 18 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana
 *          Hernandez Creacion de clase
 *
 * @category Entity
 *
 */
@Embeddable
@Getter
@Setter
public class OperacionesConciliadasCtrlDTO implements Serializable {

    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -4369346413233751544L;

    /** Variable claveInstitucion de tipo String. */
    protected String claveInstitucion;

    /** Variable idCorrelacionFk de tipo String. */
    protected String conciliado;

    /** Variable idCorrelacionFk de tipo String. */
    protected String tipoOperacion;
    
    /** Variable numCuentaNostro de tipo String. */
    protected String numCuentaNostro;
    
    /** Variable bic de tipo String. */
    protected String bic;

    /** Variable fechaValor de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",locale = "es_MX",timezone = "America/Mexico_City")
    @JsonProperty("fechaValor")
    protected Date fechaValor;

}
