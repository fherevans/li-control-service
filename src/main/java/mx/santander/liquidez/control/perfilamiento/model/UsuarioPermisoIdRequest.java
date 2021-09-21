package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserPermIdRequest.java <br>
 * <b>Description:</b> Clase para crear llave unica para eliminar permisos de
 * usuario.
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
public class UsuarioPermisoIdRequest implements Serializable {

    /**
     * uid generado.
     */
    private static final long serialVersionUID = 7612190289583378832L;

    /**
     * id de permiso para crear llave.
     */
    private Long idPerm;

    /**
     * id de usuario para crear llave.
     */
    private String idUser;
    
    /**
     * id usuario.
     */
    private String idUsuario;

}
