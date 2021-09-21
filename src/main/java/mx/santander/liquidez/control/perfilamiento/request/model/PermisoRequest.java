package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> PermisoRequest.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 2 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Getter
@Setter
public class PermisoRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 3958927628017751217L;

    /**
     * Id de permiso
     */
    private Long idPerm;

    /**
     * nombre del permiso.
     */
    private String nombre;

    /**
     * Descripcion del permiso.
     */
    private String desc;
    
    /**
     * Id de usuario.
     */
    private String idUsuario;

}