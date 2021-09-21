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
 * <b>Description:</b> Clase para obtener la respuesta con los datos de una
 * pagina.
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
public class PaginaResponse implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -8483148997145110793L;

    /**
     * Id de la pagina.
     */
    private Long idPage;

    /**
     * Nombre de la pagina.
     */
    private String nombre;

    /**
     * descripcion de la pagina.
     */
    private String desc;

    /**
     * Lista de permisos.
     */
    private List<PermisoResponse> permisos;
}
