package mx.santander.liquidez.control.parametria.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> DivisaEquivalenciaRequest.java <br>
 * <b>Description:</b> Divisa equivalencia request.
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
 * @category Model.
 *
 */
@Getter
@Setter
public class DivisaEquivalenciaRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -8955142208081895920L;

    /**
     * Id divisa.
     */
    private Long idDivisa;

    /**
     * Id aprovisionamiento.
     */
    private Long idAprovisionamiento;

    /**
     * Valor de divisa.
     */
    private String valorEquivalencia;

    /**
     * Id del usuario que realizo su ultima modificacion.
     */
    private String idUltUsrMod;

}
