package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PagePermRequest.java <br>
 * <b>Description:</b> Request para crear permisos para una pagina.
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
public class PaginaPermisoRequest implements Serializable {

    /**
     * UID generado. 
     */
    private static final long serialVersionUID = -668107848388274526L;

    /**
     * Id permiso a asignar a la pagina.
     */
    private Long idPerm;

    /**
     * Id pagina a asignar permisos.
     */
    private Long idPage;

    /**
     * Ultimo usuario que realizo modificaciones.
     */
    private String usuarioUltimaModificacion;

}
