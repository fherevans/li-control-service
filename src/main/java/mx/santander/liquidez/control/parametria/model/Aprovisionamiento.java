package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> Aprovisionamiento.java <br>
 * <b>Description:</b> Entity para crear relacion con LIQ_MX_MAE_APROV.
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
public class Aprovisionamiento implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -4672739677495550016L;

    /**
     * Id aprovisionamiento.
     */
    private Long idAprov;

    /**
     * id del sistema
     */
    private Long idSist;

    /**
     * id del canal
     */
    private Long idCanal;

    /**
     * clave aprovisionamiento.
     */
    private String claveAprov;

    /**
     * Fecha de carga.
     */
    private Date fechaCarga;

    /**
     * Sistema
     */
    private Sistema sistema;

    /**
     * Canal
     */
    private Canal canal;

}
