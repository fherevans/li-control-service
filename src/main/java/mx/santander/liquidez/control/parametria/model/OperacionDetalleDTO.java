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
* <br><b>Class:</b> OperacionDetalleDTO.java
* <br><b>Description:</b> Clase con la informacion de la operacion del seguimiento de SPEI y SPID.
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
public class OperacionDetalleDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -7620809377105310244L;
    
    /**
     * Variable cveRastreo de tipo String
     */
    private String cveRastreo;
    
    /**
     * Variable tipoTrans de tipo String
     */
    private String tipoTrans;
    
    /**
     * Variable descPago de tipo String
     */
    private String descPago;

    /**
     * Variable estado de tipo String
     */
    private String estado;
    
    /**
     * Variable claveMeca de tipo String
     */
    private String claveMeca;
    
    /**
     * Variable referencia de tipo String
     */
    private String referencia;
    
    /**
     * Variable cveOpera de tipo String
     */
    private String cveOpera;

}
