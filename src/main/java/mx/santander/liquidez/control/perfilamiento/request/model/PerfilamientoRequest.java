package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoRequest;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoRequest.java <br>
 * <b>Description:</b> API para perfilamiento.
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
public class PerfilamientoRequest implements Serializable {

    /**
     * Uid generado.
     */
    private static final long serialVersionUID = -2190299170975607224L;

    /**
     * Permiso asignado a usuario del que se crea perfil.
     */
    private List<UsuarioPermisoRequest> usuarioPermisoRequest;

    /**
     * Lista de roles asignados a usuario.
     */
    private List<UsuarioRolRequest> usuarioRolRequest;

    /**
     * Regresa el valor del atributo usuarioPermisoRequest
     * 
     * @return el atributo usuarioPermisoRequest
     */
    public List<UsuarioPermisoRequest> getUsuarioPermisoRequest() {
        return Collections.unmodifiableList(usuarioPermisoRequest);
    }

    /**
     * Establece el valor del atributo usuarioPermisoRequest
     * 
     * @param usuarioPermisoRequest el valor de usuarioPermisoRequest a establecer
     */
    public void setUsuarioPermisoRequest(List<UsuarioPermisoRequest> usuarioPermisoRequest) {
        this.usuarioPermisoRequest = Collections.unmodifiableList(usuarioPermisoRequest);
    }

    /**
     * Regresa el valor del atributo usuarioRolRequest
     * 
     * @return el atributo usuarioRolRequest
     */
    public List<UsuarioRolRequest> getUsuarioRolRequest() {
        return Collections.unmodifiableList(usuarioRolRequest);
    }

    /**
     * Establece el valor del atributo usuarioRolRequest
     * 
     * @param usuarioRolRequest el valor de usuarioRolRequest a establecer
     */
    public void setUsuarioRolRequest(List<UsuarioRolRequest> usuarioRolRequest) {
        this.usuarioRolRequest = Collections.unmodifiableList(usuarioRolRequest);
    }

}
