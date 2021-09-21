/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> OperacionesDate.java
* <br><b>Description:</b> Clase entity para obtener los datos de la tabla LIQ_MX_MAE_CAT_OPER.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Setter
@Getter
public class OperacionesDate implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -5007694816283839828L;

    /**
     * Variable fchUltMod de tipo Date
     */
    private Date fchUltMod;
    
    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchCarga;
    
}
