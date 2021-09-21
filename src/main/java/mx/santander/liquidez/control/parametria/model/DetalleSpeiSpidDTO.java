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
* <br><b>Class:</b> DetalleSpeiSpidDTO.java
* <br><b>Description:</b> Clase DTO con la respuesta del detalle de la consulta de seguimiento
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
public class DetalleSpeiSpidDTO implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -8379696870401238629L;

    /**
     * Variable bancos de tipo BancosDetalleDTO
     */
    private BancosDetalleDTO bancos;
    
    /**
     * Variable operacion de tipo OperacionDetalleDTO
     */
    private OperacionDetalleDTO operacion;
    
    /**
     * Variable impCargo de tipo String
     */
    private String impCargo;
    
    /**
     * Variable impAbono de tipo String
     */
    private String impAbono;
    
    /**
     * Variable fchApli de tipo String
     */
    private String fchApli;
    
}
