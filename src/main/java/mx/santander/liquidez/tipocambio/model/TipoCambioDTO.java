package mx.santander.liquidez.tipocambio.model;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TipoCambioDTO.java
* <br><b>Description:</b> DTO para almacenar los datos del Tipo de Cambio
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
public class TipoCambioDTO implements Serializable {
    
    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = 9003127686579222527L;
    
    /** Variable numero de tipo Long. */
    protected int numero;
        
    /** Variable accionRegistro de tipo String. */
    protected String accionRegistro;
    
    /** Variable idSeqMov de tipo String. */
    protected String idSeqMov;
    
    /** Variable idTipoCambioPk de tipo String. */
    protected String idTipoCambioPk;
    
    /** Variable ideTipoCambio de tipo String. */
    protected String ideTipoCambio;
            
    /** Variable nombreTipoCambio de tipo String. */
    protected String nombreTipoCambio;    
    
    /** Variable fechaPublicacion de tipo String. */
    protected String fechaPublicacion;    
    
    /** Variable fechaExpiracion de tipo String. */
    protected String fechaExpiracion;
    
    /** Variable precio de tipo String */
    protected String precio;    
    
        
    /**  Variable tipoCambioDivisa de tipo TipoCambioDivisaDTO. */
    @Embedded
    @Valid
    protected TipoCambioDivisaDTO tipoCambioDivisa = new TipoCambioDivisaDTO();
    
}
