package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> DivisaEquivalencia.java <br>
 * <b>Description:</b> Entity para crear relacion con LIQ_MX_MAE_CAT_DIV_EQUIV.
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
public class DivisaEquivalencia implements Serializable {

    /**
     * UID generado. 
     */
    private static final long serialVersionUID = 6633782656161881547L;
    
    /**
     * Variable idEquiv de tipo Long
     */
    private Long idEquiv;

    /**
     * Id de divisa.
     */
    private Long idDivisa;
    
    /**
     * Variable institucion de tipo Institucion
     */
    private Divisas divisa;
    
    /**
     * Variable idSistema de tipo Long
     */
    private Long idSistema;
    
    /**
     * Variable sistema de tipo Sistema
     */
    private Sistema sistema;
    
    /**
     * Valor de clave.
     */
    private String clave;

    /**
     * Id de usuario que realizo la ultima modificiacion.
     */
    private String idUltUsrMod;

    /**
     * fecha de la modificacion.
     */
    private Date fchUltMod;

    /**
     * fecha de carga.
     */
    private Date fchCarga;

}
