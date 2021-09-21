package mx.santander.liquidez.tipocambio.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TipoCambioCtrlDTO.java
* <br><b>Description:</b> Clase embebida en la entidad Tipo Cambio.
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 18 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category Entity
*
* @see Saldo
*/
@Embeddable
@Getter
@Setter
public class TipoCambioCtrlDTO implements Serializable {

    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -5959139579755886401L;
    
    /** Variable codUsrSol de tipo String. */
    protected String codUsrSol;    
    
    /** Variable fechaOperacion de tipo String. */
    protected String fechaOperacion;
    
    /** Variable tipoCarga de tipo String. */
    protected String tipoCarga;
    
    /** Variable fechaCarga de tipo Date. */
    protected String fechaCarga;    
    
    /** Variable extension de tipo String. */
    protected String extension;
    
    /** Variable observacion de tipo String. */
    protected String observacion;

}
