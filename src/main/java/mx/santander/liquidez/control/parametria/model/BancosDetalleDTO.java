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
* <br><b>Class:</b> BancosDetalleDTO.java
* <br><b>Description:</b> Clase con la informacion de los bancos del seguimiento de SPEI y SPID.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO.
*
*/
@Setter
@Getter
public class BancosDetalleDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 5601584496746750129L;
    
    /**
     * Variable cveBancoOrd de tipo String
     */
    private String cveBancoOrd;
    
    /**
     * Variable nomBancoOrd de tipo String
     */
    private String nomBancoOrd;
    
    /**
     * Variable cveBancoRec de tipo String
     */
    private String cveBancoRec;
    
    /**
     * Variable nomBancoRec de tipo String
     */
    private String nomBancoRec;

}
