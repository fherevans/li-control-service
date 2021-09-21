package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Usuario.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla LIQ_MX_MAE_USR_DRO.
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
public class Usuario implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -8237152204462168666L;

    /**
     * Id de usuario.
     */
    private String idUsr;

    /**
     * Nombre de usuario.
     */
    private String nombre;

    /**
     * Apellido paterno de usuario.
     */
    private String apePat;

    /**
     * Apelldio materno de usuario.
     */
    private String apeMat;

    /**
     * telefono de usuario.
     */
    private String tel;

    /**
     * Fecha de ultima conexion de usuario.
     */
    private Date ultimaConexion;

    /**
     * fecha de carga de usuario.
     */
    private Date fechaCarga;

    /**
     * correo de usuario.
     */
    private String correo;
    
    /**
     * Id usuario.
     */
    private String idUsuario;

    /**
     * metodo para obtener fecha de carga del usuario.
     * 
     * @return fechaCarga de usuario.
     */
    public Date getFechaCarga() {
        if (fechaCarga != null) {
            return new Date(fechaCarga.getTime());
        } else {
            return null;
        }
    }

    /**
     * metodo para asignar la ultima conexion del usuario.
     * 
     * @param ultimaConexion del usuario.
     */
    public void setUltimaConexion(Date ultimaConexion) {
        if (ultimaConexion != null) {
            this.ultimaConexion = new Date(ultimaConexion.getTime());
        } else {
            this.ultimaConexion = null;
        }
    }

    /**
     * metodo para asignar fecha de carga de usuario.
     * 
     * @param fechaCarga de usuario.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga != null) {
            this.fechaCarga = new Date(fechaCarga.getTime());
        } else {
            this.fechaCarga = null;
        }
    }

    /**
     * metodo para obtener la ultima conexion del usuario.
     * 
     * @return ultimaConexion de usuario.
     */
    public Date getUltimaConexion() {
        if (ultimaConexion != null) {
            return new Date(ultimaConexion.getTime());
        } else {
            return null;
        }
    }

}
