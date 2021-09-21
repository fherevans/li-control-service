package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserPermPK.java <br>
 * <b>Description:</b> Creacion de llave compuesta para UserPerm.
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
@EqualsAndHashCode
@Getter
@Setter
public class UsuarioPermisoPK implements Serializable {

    /**
     * Serial version uid para la llave.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id user para la llave.
     */
    private String idUser;

    /**
     * id del permiso para la llave.
     */
    private Long idPerm;
    
    
    /**
     * id Usuario.
     */
    private String idUsuario;

}
