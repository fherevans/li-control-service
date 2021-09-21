package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserPerm.java <br>
 * <b>Description:</b> Entidad para crear relacion con la tabla
 * LIQ_MX_REL_FRNT_USR_PERM.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Incluir si la clase es un Modelo, Service, etc.
 * 
 */
@Getter
@Setter
public class UsuarioPermiso implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -2028166661595758918L;

    /**
     * id user.
     */
    private String idUser;

    /**
     * id permiso.
     */
    private Long idPerm;

    /**
     * fecha de carga.
     */
    private Date fechaCarga;

    /**
     * Fecha de ultima modificacion.
     */
    private Date fechaUltimaModificacion;

    /**
     * id de usuario que realizo la ultima modificacion.
     */
    private String idUserUltimaModificacion;

    /**
     * set fecha de carga.
     * 
     * @param fechaCarga.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga != null) {
            this.fechaCarga = new Date(fechaCarga.getTime());
        } else {
            this.fechaCarga = null;
        }

    }

    /**
     * get fecha de ultima modificacion.
     * 
     * @return
     */
    public Date getFechaUltimaModificacion() {
        if (fechaUltimaModificacion != null) {
            return new Date(fechaUltimaModificacion.getTime());
        } else {
            return null;
        }
    }

    /**
     * set fecha de ultima modificacion.
     * 
     * @param fechaUltimaModificacion.
     */
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        if (fechaUltimaModificacion != null) {
            this.fechaUltimaModificacion = new Date(fechaUltimaModificacion.getTime());
        } else {
            this.fechaCarga = null;
        }

    }

    /**
     * get fecha de carga.
     * 
     * @return fechaCarga.
     */
    public Date getFechaCarga() {
        if (fechaCarga != null) {
            return new Date(fechaCarga.getTime());
        } else {
            return null;
        }
    }

}
