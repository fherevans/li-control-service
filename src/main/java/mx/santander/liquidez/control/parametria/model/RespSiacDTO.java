/**
 * 
 */
package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> RespSiacDTO.java
* <br><b>Description:</b> Clase DTO con la respuesta de la consulta de seguimiento
* de SIAC
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
public class RespSiacDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 883317752414328972L;
    
    /**
     * Variable gruposSaldos de tipo List<SaldosSiacDTO>
     */
    private List<SaldosSiacDTO> gruposSaldosReales;
    
    /**
     * Variable gruposSaldosProgra de tipo List<SaldosSiacDTO>
     */
    private List<SaldosSiacDTO> gruposSaldosProgra;
    
    /**
     * Variable siacSaldoReal de tipo String
     */
    private String siacSaldoReal;

    /**
     * Variable limiteSobre de tipo String
     */
    private String limiteSobre;
    
    /**
     * Variable operPendientes de tipo String
     */
    private String operPendientes;
    
    /**
     * Variable capacidadOper de tipo String
     */
    private String capacidadOper;
}
