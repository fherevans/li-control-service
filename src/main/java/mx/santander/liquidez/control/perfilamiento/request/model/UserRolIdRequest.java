package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserRolIdRequest.java <br>
 * <b>Description:</b> Clase para crear llave unica para eliminar UserRol
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
public class UserRolIdRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -7901908847380537082L;

    /**
     * Id de rol.
     */
    private Long idRol;

    /**
     * Id de usuario.
     */
    private String idUser;
    
    /**
     * Id de usuario.
     */
    private String idUsuario;

}
