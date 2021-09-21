package mx.santander.liquidez.tipocambio.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> TipoCambioDTO.java
* <br><b>Description:</b> DTO para almacenar los datos del Tipo de Cambio
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
@ToString
public class TipoCambioSocketDTO implements Serializable {
    
    
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
