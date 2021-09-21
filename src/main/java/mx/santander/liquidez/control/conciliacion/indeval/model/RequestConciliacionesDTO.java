package mx.santander.liquidez.control.conciliacion.indeval.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> RequestConciliacionesDTO.java
* <br><b>Description:</b> Clase Request con parametros de entrada para la consulta de operaciones conciliadas
* de Opics vd Dali
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 26 ene. 2021
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 26 ene. 2021 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/

@Data
@ToString
@EqualsAndHashCode
public class RequestConciliacionesDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 4795207859587855898L;

    /**
     * Variable fechaValor de tipo String
     */
    private String fechaValor;

    /**
     * Variable idInstitucuion de tipo Integer
     */
    private Integer idInstitucion;

    /**
     * Variable folioInstitucion de tipo Integer
     */
    private Integer folioInstitucion;

    /**
     * Variable idInstContra de tipo Integer
     */
    private Integer idInstContra;

    /**
     * Variable folioInstContra de tipo Integer
     */
    private Integer folioInstContra;

    /**
     * Variable inconsistencias de tipo String
     */
    private String inconsistencias;
    
    /**
     * Variable mercado de tipo String
     */
    private String mercado;
    
    /**
     * Variable conciliacion de tipo String
     */
    private String conciliacion;
    
    /**
     * Variable page de tipo Integer
     */
    private Integer page;

    /**
     * Variable size de tipo Integer
     */
    private Integer size;

}
