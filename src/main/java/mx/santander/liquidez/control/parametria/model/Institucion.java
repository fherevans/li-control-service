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
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> Institucion.java
* <br><b>Description:</b> Clase Entity para obtener los datos de la tabla LIQ_MX_MAE_CAT_INST
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 19 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 19 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Getter
@Setter
public class Institucion implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 703807711838329088L;
    
    /**
     * Variable idInst de tipo Long
     */
    private Long idInst;
    
    /**
     * Variable cveInst de tipo String
     */
    private String cveInst;
    
    /**
     * Variable nombre de tipo String
     */
    private String nombre;
    
    /**
     * Variable idUserUltMod de tipo String
     */
    private String idUserUltMod;
    
    /**
     * fecha de ultima modificacion.
     */
    private Date fchUltMod;

    /**
     * fecha de carga.
     */
    private Date fechaCarga;

}
