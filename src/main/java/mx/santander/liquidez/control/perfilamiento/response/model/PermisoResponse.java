package mx.santander.liquidez.control.perfilamiento.response.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoResponse.java <br>
 * <b>Description:</b> Clase para obtener la respuesta con los datos de un
 * permiso
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
public class PermisoResponse implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -3524424469212177781L;

    /**
     * Id de permiso.
     */
    private Long idPerm;

    /**
     * Nombre de permiso.
     */
    private String nombre;

}
