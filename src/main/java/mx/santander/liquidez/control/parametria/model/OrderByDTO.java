package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Data;
/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> OrderByDTO.java
 * <br><b>Description:</b>
 * Clase DTO generica que contiene la informacion
 * del order by enviado en la peticion
 *
 * @author Christian Ivan Miranda Paulin
 * @company Praxis
 * @created 02 mar. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 02 mar. 2021 IVPA: Creacion de la clase
 *
 * @category DTO
 *
 */
@Data
public class OrderByDTO implements Serializable {
    
    /**
     * Version serial
     */
    private static final long serialVersionUID = -7256834487773452461L;

    /**
     * Variable order de tipo String
     */
    private String order;
    
    /**
     * Variable by de tipo String
     */
    private String by;
}
