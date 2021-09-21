package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PaginaPermisoIdRequest.java <br>
 * <b>Description:</b> Llave compuesta para eliminar un permiso asignado a una
 * pagina
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
public class PaginaPermisoIdRequest implements Serializable {

    /**
     * UID generado
     */
    private static final long serialVersionUID = -2147143798718204256L;

    /**
     * Id del permiso.
     */
    private Long idPerm;

    /**
     * Id de la pagina.
     */
    private Long idPage;
    
    /**
     * Id de usuario.
     */
    private String usuarioUltimaModificacion;

}
