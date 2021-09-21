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
* <br><b>Class:</b> RespSpeiSpidDTO.java
* <br><b>Description:</b> Clase DTO con la respuesta de la consulta de seguimiento
* de SPEI y SPID.
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
public class RespSpeiSpidDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7756461859037017922L;
    
    /**
     * Variable banco de tipo String
     */
    private String cveBanco;
    
    /**
     * Variable cvePago de tipo String
     */
    private String cvePago;
    
    /**
     * Variable descPago de tipo String
     */
    private String descPago;
    
    /**
     * Variable cveCanal de tipo String
     */
    private String cveCanal;
    
    /**
     * Variable totalReci de tipo String
     */
    private String totalReci;
    
    /**
     * Variable totalEnv de tipo String
     */
    private String totalEnv;
    
    /**
     * Variable saldoProy de tipo String
     */
    private String saldoProy;

    /**
     * Variable nombreBanco de tipo String
     */
    private String nombreBanco;

}
