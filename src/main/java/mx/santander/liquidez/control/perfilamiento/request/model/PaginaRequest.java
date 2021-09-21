package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> PaginaRequest.java
* <br><b>Description:</b> Pagina Request.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 6 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 6 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Getter
@Setter
public class PaginaRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 2287431273089559234L;

    /**
     * Nombre de la pagina creada.
     */
    private String nombre;

    /**
     * id de pagina creada.
     */
    private Long idPage;

    /**
     * nivel de prioridad de la pagina creada.
     */
    private String nivPrio;

    /**
     * Descripcion de la pagina creada.
     */
    private String desc;
    
    /**
     * Id de usuario logeado.
     */
    private String idUsuario;

}