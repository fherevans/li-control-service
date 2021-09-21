package mx.santander.liquidez.control.operaciones.pendientes.dto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-ctrl-monitoreo-service <br>
 * <b>Class:</b> OperacionesConciliadas.java <br>
 * <b>Description:</b> Clase entity para obtener los datos de la tabla
 * LIQ_MX_MAE_OPER_CONCI.
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana
 *          Hernandez Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 8 ago. 2019
 * @category Entity
 */
@Getter
@Setter
public class OperacionesConciliadasDTO implements Serializable {

    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = 252904022792438060L;

    /** Variable idCorrelacionFk de tipo String. */
    protected String idCorrelacionFk;

    /** Variable fechaUltimaMod de tipo Date. */
    protected Date fechaLiquidacion;

    /** Variable fechaValor de tipo Date. */
    protected Date fechaContable;

    /** Variable idCorrelacionFk de tipo String. */
    protected String cobroPago;

    /** Variable idCorrelacionFk de tipo String. */
    protected String idReferenciaCan;

    /** Variable idCorrelacionFk de tipo String. */
    protected Double impTotal;

    /** Variable idCorrelacionFk de tipo String. */
    protected Double impRemanente;

    /** Variable idCorrelacionFk de tipo String. */
    protected String claveAprovicionamiento;

    /** Variable claveTipoOperacion de tipo String. */
    protected String claveTipoOperacion;
    
    /** Variable operConciliadasCrl de tipo OperacionesConciliadasCtrl */
    @Embedded
    @Valid
    protected OperacionesConciliadasCtrlDTO operConciliadasCrl = new OperacionesConciliadasCtrlDTO();

}
