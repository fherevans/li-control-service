package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserRol.java <br>
 * <b>Description:</b> Entidad para crear relacion con la tabla
 * LIQ_MX_REL_FRNT_USR_ROL.
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
public class UsuarioRol implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -4829460177576926804L;

    /**
     * usario que realizo la ultima modificacion.
     */
    private String idUserUltimaModificacion;

    /**
     * Id de usuario para asignar rol.
     */
    private String idUser;

    /**
     * ¨ fecha de carga.
     */
    private Date fechaCarga;

    /**
     * Id de rol.
     */
    private Long idRol;

    /**
     * fecha de ultima modificacion.
     */
    private Date fechaUltimaModificacion;

    /**
     * numero de prioridad asignado al usuario.
     */
    private String numeroPrioridad;

    /**
     * set fecha de ultima modificacion.
     * 
     * @param fechaUltimaModificacion.
     */
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = new Date(fechaUltimaModificacion.getTime());
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

    /**
     * set fecha de carga.
     * 
     * @param fechaCarga.
     */
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = new Date(fechaCarga.getTime());
    }

    /**
     * get fecha de ultima modificacion.
     * 
     * @return fechaUltimaModificacion.
     */
    public Date getFechaUltimaModificacion() {
        if (fechaUltimaModificacion != null) {
            return new Date(fechaUltimaModificacion.getTime());
        } else {
            return null;
        }
    }

}
