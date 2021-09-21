package mx.santander.liquidez.control.perfilamiento.response.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoResponse.java <br>
 * <b>Description:</b> Clase para obtener el rol asignado a un usuario.
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
public class UsuarioRolResponse implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -6321468094479483102L;

    /**
     * Id de usuario.
     */
    private Long idRol;

    /**
     * Numero de prioridad.
     */
    private String numeroPrioridad;

    /**
     * Nombre del rol.
     */
    private String nombre;

    /**
     * Descripcion del rol.
     */
    private String desc;

    /**
     * Lista de paginas asignadas a un rol.
     */
    private List<PaginaResponse> paginas;

}
