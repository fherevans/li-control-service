package mx.santander.liquidez.control.conciliacion.indeval.model;

import java.io.Serializable;
import lombok.Data;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> RequestConciListaDTO.java
* <br><b>Description:</b> Clase Request con parametros de entrada para la consulta de operaciones conciliadas
* para obtener la lista de la informacion
*
* @author Christian Ivan Miranda Paulin
* @company Praxis
* @created 18 feb. 2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 18 feb. 2021 IVPA
* Creacion de clase
*
* @category DTO
*
*/
@Data
public class RequestConciListaDTO implements Serializable {
    
    /**
     * Version serial
     */
    private static final long serialVersionUID = 745893131799725842L;

    /**
     * Variable conciliacion de tipo String
     */
    private String conciliacion;
    
    /**
     * Variable inconsistencias de tipo String
     */
    private String inconsistencias;

    /**
     * Variable folioInstitucion de tipo Integer
     */
    private Integer folioInstitucion;

    
    /**
     * Variable idInstitucuion de tipo Integer
     */
    private Integer idInstitucion;

    /**
     * Variable fechaValor de tipo String
     */
    private String fechaValor;

    /**
     * Variable folioInstContra de tipo Integer
     */
    private Integer folioInstContra;
    
    /**
     * Variable idInstContra de tipo Integer
     */
    private Integer idInstContra;
    
    /**
     * Variable mercado de tipo String
     */
    private String mercado;

}
