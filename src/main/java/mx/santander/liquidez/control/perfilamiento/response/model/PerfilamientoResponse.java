package mx.santander.liquidez.control.perfilamiento.response.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import mx.santander.liquidez.control.perfilamiento.model.Preferencias;
import mx.santander.liquidez.control.perfilamiento.model.Usuario;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoResponse.java <br>
 * <b>Description:</b> Clase que regresara un objeto de perfilamieno por usuario
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 2 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 2 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio.
 * 
 * @category Modelo.
 * 
 */
@Getter
@Setter
public class PerfilamientoResponse implements Serializable {

    /**
     * UID generado. 
     */
    private static final long serialVersionUID = 3524896065630953086L;

    /**
     * Datos del usuario que quien se realiza la consulta.
     */
    private Usuario usuario;

    /**
     * Roles asignados al usuario.
     */
    private List<UsuarioRolResponse> usuarioRoles;

    /**
     * Permisos asignados a usuario.
     */
    private List<PermisoResponse> permisosUsuario;

    /**
     * Preferencias de renglon de usuario al ingresar.
     */
    private List<Preferencias> preferenciasFila;

    /**
     * Preferencia de columna de usuario al ingresar
     */
    private List<Preferencias> preferenciasColumna;

    /**
     * Regresa el valor del atributo usuarioRoles
     * 
     * @return el atributo usuarioRoles
     */
    public List<UsuarioRolResponse> getUsuarioRoles() {
        return Collections.unmodifiableList(usuarioRoles);
    }

    /**
     * Establece el valor del atributo usuarioRoles
     * 
     * @param usuarioRoles el valor de usuarioRoles a establecer
     */
    public void setUsuarioRoles(List<UsuarioRolResponse> usuarioRoles) {
        this.usuarioRoles = Collections.unmodifiableList(usuarioRoles);
    }

    /**
     * Regresa el valor del atributo preferencias.
     * 
     * @return el atributo preferencias.
     */
    public List<Preferencias> getPreferenciasFila() {
        return Collections.unmodifiableList(preferenciasFila);
    }

    /**
     * Establece el valor del atributo preferencias.
     * 
     * @param preferencias el valor de preferencias a establecer.
     */
    public void setPreferenciasFila(List<Preferencias> preferenciasFila) {
        this.preferenciasFila = Collections.unmodifiableList(preferenciasFila);
    }

    /**
     * Regresa el valor del atributo preferencias.
     * 
     * @return el atributo preferencias.
     */
    public List<Preferencias> getPreferenciasColumna() {
        return Collections.unmodifiableList(preferenciasColumna);
    }

    /**
     * Establece el valor del atributo preferencias.
     * 
     * @param preferencias el valor de preferencias a establecer.
     */
    public void setPreferenciasColumna(List<Preferencias> preferenciasColumna) {
        this.preferenciasColumna = Collections.unmodifiableList(preferenciasColumna);
    }

}
