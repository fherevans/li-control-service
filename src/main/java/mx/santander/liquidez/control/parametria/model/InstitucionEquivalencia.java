package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> InstitucionEquivalencia.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
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
public class InstitucionEquivalencia implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 56052175227031836L;
    
    /**
     * Variable idEquiv de tipo Long
     */
    private Long idEquiv;

    /**
     * Id de institucion.
     */
    private Long idInstitucion;
    
    /**
     * Variable institucion de tipo Institucion
     */
    private Institucion institucion;
    
    /**
     * Variable idSistema de tipo Long
     */
    private Long idSistema;
    
    /**
     * Variable sistema de tipo Sistema
     */
    private Sistema sistema;

    /**
     * Valor de equivalencia.
     */
    private String claveInst;

    /**
     * Id de usuario de ultima modificacion.
     */
    private String idUltUsrMod;

    /**
     * Fecha de ultima modificacion.
     */
    private Date fchUltMod;

    /**
     * Fecha de carga.
     */
    private Date fchCarga;

}
