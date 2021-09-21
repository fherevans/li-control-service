package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Rol.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla
 * LIQ_MX_MAE_FRNT_ROL.
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
public class Rol implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -6728328973546661899L;

    /**
     * nombre de rol.
     */
    private String nombre;

    /**
     * Id de rol.
     */
    private Long idRol;

    /**
     * descripcion del rol.
     */
    private String desc;
    
    /**
     * Id Usuario
     */
    private String idUsuario;

    /**
     * fecha de carga del rol.
     */
    private Date fechaCarga;

    /**
     * metodo para obtener fecha de carga del rol.
     * 
     * @return fechaCarga del rol.
     */
    public Date getFechaCarga() {
        if (fechaCarga != null) {
            return new Date(fechaCarga.getTime());
        } else {
            return null;
        }
    }

    /**
     * metodo para asignar fecha de carga del rol.
     * 
     * @param fechaCarga del rol.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga != null) {
            this.fechaCarga = new Date(fechaCarga.getTime());
        } else {
            this.fechaCarga = null;
        }
    }

}
