/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SaldosSiacDTO.java
* <br><b>Description:</b> Clase DTO para guardar los saldos de siac.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 20 feb. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 20 feb. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
@Setter
@Getter
public class SaldosSiacDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 5677041102896136767L;
    
    /**
     * Variable descGrupo de tipo String
     */
    private String descGrupo;
    
    /**
     * Variable cobros de tipo String
     */
    private String cobros;
    
    /**
     * Variable pagos de tipo String
     */
    private String pagos;
    
    /**
     * Variable saldoTotal de tipo String
     */
    private String saldoTotal;

}
