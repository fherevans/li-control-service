package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> LineaCarteraCteDTO.java
* <br><b>Description:</b> Clase embebida en la Linea Cartera
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
@Getter
@Setter
public class LineaCarteraCteDTO implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 7670649764538655345L;
    
    /** Variable descSucursal de tipo String. */
    private String digito;
    
    /** Variable descSucursal de tipo String. */
    private String cuentaCheques;
    
    /** Variable descSucursal de tipo String. */
    private String nombreTitular;
        
    /** Variable descSucursal de tipo String. */
    private String numCliente;    
    
    /** Variable descSucursal de tipo String. */
    private String cuentaOrigen;
    
    /** Variable descSucursal de tipo String. */
    private String plazo;
    
    /** Variable descSucursal de tipo String. */
    private String estatus;
    
    /** Variable descSucursal de tipo String. */
    private String codigoTipoAmortizacion;

}
