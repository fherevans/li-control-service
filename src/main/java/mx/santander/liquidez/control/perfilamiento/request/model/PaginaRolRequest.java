package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageRolRequest.java <br>
 * <b>Description:</b> Request para api de asignacion de rol a una pagina.
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
public class PaginaRolRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 3856559399148053465L;

    /**
     * Id pagina que se le asignara un rol.
     */
    private Long idPage;

    /**
     * id de que se asignara a la pagina.
     */
    private Long idRol;

    /**
     * Usuario que realizo la ultima modificacion.
     */
    private String usuarioUltimaModificacion;

    /**
     * numero de prioridad para el rol.
     */
    private String numeroPrioridad;

}
