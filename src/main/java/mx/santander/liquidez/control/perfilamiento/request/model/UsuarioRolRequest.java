package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserRolRequest.java <br>
 * <b>Description:</b> Request para crear un rol nuevo asignado a un usario.
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
public class UsuarioRolRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 8751766856878601677L;

    /**
     * id de usuario.
     */
    private String idUser;

    /**
     * id de rol.
     */
    private Long idRol;

    /**
     * Prioridad que tiene un usuario para entrar a una pantalla.
     */
    private String numeroPrioridad;

    /**
     * id de usuario que realiza la ultima modificacion.
     */
    private String idUserUltimaModificacion;

}