package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-seguimiento-valores-service <br>
 * <b>Class:</b> Dali.java <br>
 * <b>Description:</b> Dali model.
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
@ToString
public class Dali implements Serializable {

    /**
     * serial uid.
     */
    private static final long serialVersionUID = -1273505988511151373L;

    /**
     * Caucion.
     */
    private long caucion;

    /**
     * Garantia.
     */
    private long garantia;

    /**
     * Valor
     */
    private long disponible;

}
