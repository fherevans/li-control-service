package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageRolIdRequest.java <br>
 * <b>Description:</b> clase para crear llave en el request para eliminar rol
 * asignado a la pagina.
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
public class PaginaRolIdRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 2423157883062932007L;

    /**
     * id page para crear llave.
     */
    private Long idPage;

    /**
     * id rol para crear llave
     */
    private Long idRol;
    
    /**
     * id usuario
     */
    private String usuarioUltimaModificacion;

    
}
