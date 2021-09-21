package mx.santander.liquidez.control.conciliacion.indeval.model;

import java.io.Serializable;
import lombok.Data;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> RequestProcesoConciDTO.java
* <br><b>Description:</b> Clase Request que transporta
* la informacion de la activacion de los procesos de consiliacion
*
* @author Christian Ivan Miranda Paulin
* @company Praxis
* @created 11 mar. 2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 11 mar. 2021 IVPA
* Creacion de clase
*
* @category DTO
*
*/
@Data
public class RequestProcesoConciDTO implements Serializable{
    
    /**
     * Version Serial
     */
    private static final long serialVersionUID = -807598990776073181L;

    /**
     * Variable sistema de tipo String
     */
    private String sistema;
    
    /**
     * Variable sistema de tipo String
     */
    private String fecha;
}
