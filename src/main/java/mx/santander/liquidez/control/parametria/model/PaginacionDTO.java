package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import lombok.Data;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> PaginacionDTO.java
 * <br><b>Description:</b>
 * Clase DTO generica que contiene la informacion
 * de la paginacion
 *
 * @author Christian Ivan Miranda Paulin
 * @company Praxis
 * @created 09 mar. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 09 mar. 2021 IVPA: Creacion de la clase
 *
 * @category DTO
 *
 */
@Data
public class PaginacionDTO implements Serializable {

    /**
     * Version Serial
     */
    private static final long serialVersionUID = 5505856648214863779L;

    /**
     * Variable page de tipo Integer
     */
    private Integer page;

    /**
     * Variable size de tipo Integer
     */
    private Integer size;
}
