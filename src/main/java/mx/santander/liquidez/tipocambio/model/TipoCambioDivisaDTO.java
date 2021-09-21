package mx.santander.liquidez.tipocambio.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TipoCambioDivisaDTO.java
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
*/
@Embeddable
@Getter
@Setter
public class TipoCambioDivisaDTO implements Serializable {
    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -8579810723974356287L;
    
    /** Variable motivo de tipo String. */
    protected String motivo;        
    
    /** Variable tipoMovimiento de tipo String. */
    protected String tipoMovimiento;    
    
    /** Variable idEstatusPrev de tipo String. */
    protected String idEstatusPrev;    
    
    /** Variable descEstatusPrev de tipo String. */
    protected String descEstatusPrev;    
    
    /** Variable fechaActualizacion de tipo String. */
    protected String fechaActualizacion;    
    
    /** Variable descEstatus de tipo String. */
    protected String descEstatus;    
    
    /** Variable descDivisas de tipo String. */
    protected String descDivisas;    
    
    /** Variable descFuente de tipo String. */
    protected String descFuente;    
    
    /** Variable codUsr de tipo String. */
    protected String codUsr;    
            
    /**  Variable tipoCambioCtrl de tipo TipoCambioCtrlDTO. */
    @Embedded
    @Valid
    protected TipoCambioCtrlDTO tipoCambioCtrl = new TipoCambioCtrlDTO();

}
