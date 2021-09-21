/**
 * 
 */
package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SemaforoDTO.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 16 oct 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 16 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
* @category Incluir si la clase es un Modelo, Service, etc.
*/
@Getter
@Setter
public class SemaforoDTO implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 5372659877728068255L;
    
    /**
     * Variable idKiwi de tipo Long
     */
    private Long idKiwi; 

    /**
     * Variable monto de tipo double
     */
    private double monto;
    
    /**
     * Variable tipo de tipo String
     */
    private String tipo;
    
    /**
     * Variable color de tipo String
     */
    private String color;
    
}
