package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> OperacionEquivalencia.java <br>
 * <b>Description:</b> Clase Entity para obtener los datos de la tabla LIQ_MX_MAE_CAT_OPER_EQUIV
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
public class OperacionEquivalencia implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 3388645292536448142L;
    
    /**
     * Variable idEquiv de tipo Long
     */
    private Long idEquiv;

    /**
     * Id tipo operacion.
     */
    private Long idTipoOperacion;
    
    /**
     * Variable grupo de tipo GruposOperacion
     */
    private OperacionesLiq operacion;
    
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
    private String claveOper;

    /**
     * id usuario que realizo la ultima modificacion.
     */
    private String idUltUsrMod;

    /**
     * fecha de ultima modificacion.
     */
    private Date fchUltMod;

    /**
     * fecha de carga.
     */
    private Date fechaCarga;

}
