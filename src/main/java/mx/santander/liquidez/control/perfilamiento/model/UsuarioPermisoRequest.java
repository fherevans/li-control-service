package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserPermRequest.java <br>
 * <b>Description:</b> Clase para request de permisos asignados a usuarios.
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
public class UsuarioPermisoRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -5457654583539430923L;

    /**
     * Id de permiso.
     */
    private Long idPerm;

    /**
     * Id de usuario.
     */
    private String idUser;

    /**
     * id de usuario de la ultima modificacion.
     */
    private String idUserUltimaModificacion;

}
