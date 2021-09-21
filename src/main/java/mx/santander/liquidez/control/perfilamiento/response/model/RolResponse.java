package mx.santander.liquidez.control.perfilamiento.response.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoResponse.java <br>
 * <b>Description:</b> Clase para obtener la respuesta de un Rol.
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
public class RolResponse implements Serializable {

    /**
     * UID generado. 
     */
    private static final long serialVersionUID = -4972300991888494356L;

    /**
     * Id de Rol.
     */
    private Long idRol;

    /**
     * Nombre del Rol
     */
    private String nombre;

}
