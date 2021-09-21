package mx.santander.liquidez.control.parametria.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> AprovisionamientoRequest.java <br>
 * <b>Description:</b> clase para aprovisionamiento request.
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
 * @category Model.
 * 
 */
@Getter
@Setter
public class AprovisionamientoRequest implements Serializable {

    
    /**
     * UID generado.
     */
    private static final long serialVersionUID = 4401088201303941230L;

    /**
     * id aprovisionamiento.
     */
    private Long idAprov;

    /**
     * Id sistema.
     */
    private Long idSist;

    /**
     * Id canal.
     */
    private Long idCanal;

    /**
     * Clave aprovisionamiento.
     */
    private String claveAprov;


}
