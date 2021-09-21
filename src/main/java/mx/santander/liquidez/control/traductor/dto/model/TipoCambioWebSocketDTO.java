package mx.santander.liquidez.control.traductor.dto.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-service
* <br><b>Class:</b> TipoCambioWebSocketDTO.java
* <br><b>Description:</b> DTO para almacenar los datos 
* del Tipo de Cambio WebSocket
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, 
* Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
public class TipoCambioWebSocketDTO implements Serializable {


    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 8860711984186437685L;

    /**
     * Variable id de tipo Long
     */
    private Long id;

    /**
     * Variable origen de tipo String
     */
    private String origen;
    
    /**
     * Variable destino de tipo String
     */
    private String destino;
    
    /**
     * Variable precio de tipo String
     */
    private String precio;
    
    /**
     * Variable operacion de tipo String
     */
    private String operacion;
    
    
    
    
}
