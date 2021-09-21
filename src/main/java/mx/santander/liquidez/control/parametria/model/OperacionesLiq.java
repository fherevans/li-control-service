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
* <br><b>Class:</b> OperacionesLiq.java
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
@Getter
@Setter
public class OperacionesLiq implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -613393546903765694L;
    
    /**
     * Variable id de tipo Long
     */
    private Long id;
    
    /**
     * Variable grupo de tipo GruposOperacion
     */
    private GruposOperacion grupo;
    
    /**
     * Variable idGrupo de tipo Long
     */
    private Long idGrupo;
    
    /**
     * Variable canal de tipo Canal
     */
    private Canal canal;
    
    /**
     * Variable idCanal de tipo Long
     */
    private Long idCanal;
    
    /**
     * Variable cveOper de tipo String
     */
    private String cveOper;

    /**
     * Variable nombre de tipo String
     */
    private String nombre;
    
    /**
     * Variable desc de tipo String
     */
    private String desc;
    
    /**
     * Variable usuarioMod de tipo String
     */
    private String usuarioMod;
    
    /**
     * Variable fchUltMod de tipo Date
     */
    private OperacionesDate fechas;
    
}
