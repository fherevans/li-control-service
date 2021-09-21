package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> UsuarioRequest.java <br>
 * <b>Description:</b> usuario request.
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
public class UsuarioRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -6644791300235134592L;

    /**
     * Nombre de usuario.
     */
    private String nombre;

    /**
     * Id de usuario.
     */
    private String idUsr;

    /**
     * Apelldio materno de usuario.
     */
    private String apeMat;

    /**
     * Apellido paterno de usuario.
     */
    private String apePat;

    /**
     * Fecha de ultima conexion de usuario.
     */
    private Date ultimaConexion;

    /**
     * telefono de usuario.
     */
    private String tel;

    /**
     * correo de usuario.
     */
    private String correo;
    
    /**
     * Id usuario.
     */
    private String idUsuario;

    /**
     * Regresa el valor del atributo ultimaConexion
     * 
     * @return el atributo ultimaConexion
     */
    public Date getUltimaConexion() {
        if (ultimaConexion != null) {
            return new Date(ultimaConexion.getTime());
        } else {
            return null;
        }

    }

    /**
     * Establece el valor del atributo ultimaConexion
     * 
     * @param ultimaConexion el valor de ultimaConexion a establecer
     */
    public void setUltimaConexion(Date ultimaConexion) {
        if (ultimaConexion != null) {
            this.ultimaConexion = new Date(ultimaConexion.getTime());
        } else {
            this.ultimaConexion = null;
        }

    }

}
