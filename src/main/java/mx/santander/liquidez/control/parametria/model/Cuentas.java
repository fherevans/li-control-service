/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> Cuentas.java
* <br><b>Description:</b> Clase Entity para mapear la tabla LIQ_MX_MAE_CAT_CTA_APROV.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 20 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 20 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Entity
*
*/
@Setter
@Getter
public class Cuentas implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3976984816269101808L;
    
    /**
     * Variable idCuenta de tipo Long
     */
    private Long idCuenta;
    
    /**
     * Variable clavesCuenta de tipo ClavesCuentas
     */
    private ClavesCuentas clavesCuenta;
    
    /**
     * Variable tipo de tipo String
     */
    private Long tipo;
    
    /**
     * Variable tipCuenta de tipo TipoCuentas
     */
    private TipoCuentas tipCuenta;
    
    /**
     * Variable idDiv de tipo Long
     */
    private Long idDiv;
    
    /**
     * Variable divisa de tipo Divisas
     */
    private Divisas divisa;
    
    /**
     * Variable idUsrMod de tipo String
     */
    private String idUsrMod ;
    
    /**
     * fecha de la modificacion.
     */
    private String fchUltMod;

    /**
     * fecha de carga.
     */
    private String fchCarga;
}
