package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> Permiso.java <br>
 * <b>Description:</b> Permiso model.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 2 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Model.
 *
 */
@Getter
@Setter
public class Permiso implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 4350768487331164651L;

    /**
     * id de permiso como llave primaria.
     */
    private Long idPerm;

    /**
     * nombre del permiso.
     */
    private String nombre;

    /**
     * Descripcion del permiso.
     */
    private String desc;

    /**
     * fecha de carga del permiso.
     */
    private Date fechaCarga;
    
    /**
     * Id de usuario
     */
    private String idUsuario;

    /**
     * metodo para obtener la fecha de carga del permiso.
     * 
     * @return fechaCarga del permiso.
     */
    public Date getFechaCarga() {
        if (fechaCarga == null) {
            return null;
        } else {
            return new Date(fechaCarga.getTime());
        }
    }

    /**
     * metodo para asignar la fecha de carga del permiso.
     * 
     * @param fechaCarga del permiso.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga == null) {
            this.fechaCarga = null;
        } else {
            this.fechaCarga = new Date(fechaCarga.getTime());
        }
    }

}