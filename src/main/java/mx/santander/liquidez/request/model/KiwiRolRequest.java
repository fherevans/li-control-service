package mx.santander.liquidez.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PaginaPermisoIdRequest.java <br>
 * <b>Description:</b> Kiwi rol request.
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
 * @category Modelo
 * 
 */
@Getter
@Setter
public class KiwiRolRequest implements Serializable {

    /**
     * uid serializable
     */
    private static final long serialVersionUID = 9061529578242065560L;

    /**
     * id kiwi fk.
     */
    private Long idKiwiFk;

    /**
     * id rol fk.
     */
    private Long idRolFk;

}
