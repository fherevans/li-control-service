package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageRol.java <br>
 * <b>Description:</b> Entidad para crear relacion con la tabla
 * LIQ_MX_REL_FRNT_PAGE_ROL.
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
public class PaginaRol implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7330149834004374218L;

    /**
     * id de rol.
     */
    private Long idRol;

    /**
     * id de pagina.
     */
    private Long idPage;

    /**
     * numero de prioridad para el rol.
     */
    private String numeroPrioridad;

    /**
     * Usuario que realizo la ultima modificación del rol a la pagina
     */
    private String usuarioUltimaModificacion;

    /**
     * fecha de carga de rol asignado a una pagina.
     */
    private Date fechaCarga;

    /**
     * fecha de ultima modificacion de rol a la pagina.
     */
    private Date fechaUltimaModificacion;

    /**
     * set fecha de ultima modificacion.
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
     * get fecha de carga del rol.
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
     * get fecha de ultima modificacion al rol.
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

}
