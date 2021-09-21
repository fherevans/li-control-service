package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserRolPK.java <br>
 * <b>Description:</b> Creacion de llave primaria para UserRol.
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
@EqualsAndHashCode
public class UsuarioRolPK implements Serializable {

    /**
     * serial version uid para creacion de objetos unicos.
     */
    private static final long serialVersionUID = 1L;

    /**
     * id de usuario para crear llave primaria de User rol.
     */
    private String idUser;

    /**
     * id de rol para crear llave primaria de UserRol
     */
    private Long idRol;
    
    /**
     * Id de usuario.
     */
    private String idUsuario;


}
