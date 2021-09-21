/**
 * 
 */
package mx.santander.liquidez.control.parametria.dto.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> DivisasRequest.java
* <br><b>Description:</b> Clase dto para proporcionar las divisas operativas en liquidez intradia.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 7 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 7 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Request
*
*/
@Setter
@Getter
public class DivisasDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 2472980052079589478L;
    
    /**
     * Variable id de tipo int
     */
    private int id;
    
    /**
     * Variable codDivisa de tipo String
     */
    private String codDivisa;

}
