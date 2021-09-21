package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RolRequest.java <br>
 * <b>Description:</b> Rol Request.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 6 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Modelo.
 *
 */
@Getter
@Setter
public class RolRequest implements Serializable {

    /**
     * serial uid generado.
     */
    private static final long serialVersionUID = -1064127684888593080L;

    /**
     * nombre de rol.
     */
    private String nombre;

    /**
     * Id de rol.
     */
    private Long idRol;

    /**
     * descripcion del rol.
     */
    private String desc;
    
    /**
     * Id usuario.
     */
    private String idUsuario;

}
