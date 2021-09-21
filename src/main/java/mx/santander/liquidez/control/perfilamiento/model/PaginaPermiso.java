package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PagePerm.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla
 * LIQ_MX_REL_FRNT_PAGE_PERM.
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
public class PaginaPermiso implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3436188848728742052L;

    /**
     * Id de la pagina a asignar permiso.
     */
    private Long idPage;

    /**
     * Id del permiso a asignar.
     */
    private Long idPerm;

    /**
     * fecha de carga del permiso asignado a la pagina.
     */
    private Date fechaCarga;

    /**
     * fecha de ultima modificacion al permiso.
     */
    private Date fechaUltimaModificacion;

    /**
     * usuario que realizo la ultima modificación.
     */
    private String usuarioUltimaModificacion;

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
     * set fecha de ultima modificacion del permiso asignado a la pagina.
     * 
     * @param fechaUltimaModificacion.
     */
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        if (fechaUltimaModificacion != null) {
            this.fechaUltimaModificacion = new Date(fechaUltimaModificacion.getTime());
        } else {
            this.fechaUltimaModificacion = null;
        }
    }

    /**
     * set fecha de carga.
     * 
     * @param fechaCarga.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga == null) {
            this.fechaCarga = null;
        } else {
            this.fechaCarga = new Date(fechaCarga.getTime());
        }
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
