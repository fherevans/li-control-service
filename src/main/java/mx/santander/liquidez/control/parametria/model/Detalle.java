package mx.santander.liquidez.control.parametria.model;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-seguimiento-valores-service <br>
 * <b>Class:</b> Transito.java <br>
 * <b>Description:</b> Transito.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 9 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Model.
 *
 */
@Getter
@Setter
public class Detalle implements Serializable {

    /**
     * serial UID generado.
     */
    private static final long serialVersionUID = -6147796936749002695L;

    /**
     * Opics.
     */
    private Opics opics;

    /**
     * Dali.
     */
    private Dali dali;

    /**
     * Emisora.
     */
    private Emisora emisora;

    /**
     * Transito
     */
    private Integer transito;

    /**
     * Camaras.
     */
    private Integer camaras;

    /**
     * Detalle de operacion.
     */
    private DetalleOperacion detalleOperacion;

}