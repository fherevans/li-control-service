package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-seguimiento-valores-service <br>
 * <b>Class:</b> Valores.java <br>
 * <b>Description:</b> Valores.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 7 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 7 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Model.
 *
 */
@Getter
@Setter
public class Valores implements Serializable {

    /**
     * serial UID generado.
     */
    private static final long serialVersionUID = 4505083311083324539L;

    /**
     * Valor opics.
     */
    private Integer opics;

    /**
     * Valor dali.
     */
    private Integer dali;

    /**
     * Valor extrangero.
     */
    private Integer extranjeros;

}
