package mx.santander.liquidez.control.parametria.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> OperacionEquivalenciaRequest.java <br>
 * <b>Description:</b> Operacion equivalencia request.
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
public class OperacionEquivalenciaRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -7220515748887461437L;

    /**
     * Id tipo operacion.
     */
    private Long idTipoOperacion;

    /**
     * Id de aprovisionamiento.
     */
    private Long idAprovisionamiento;

    /**
     * valor de equivalencia.
     */
    private String valorEquivalencia;

    /**
     * Id de ultimo usuario modificado.
     */
    private String idUltUsrMod;

}
