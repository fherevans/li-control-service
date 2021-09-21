package mx.santander.liquidez.control.parametria.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> InstitucionEquivalenciaRequest.java <br>
 * <b>Description:</b> Institucion equivalencia request.
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
public class InstitucionEquivalenciaRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -5391731355133293071L;

    private Long idInstitucion;

    private Long idAprovisionamiento;

    private String valorEquivalencia;

    private String idUltUsrMod;

}
