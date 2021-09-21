package mx.santander.liquidez.notificacion.toast.model;

/**
 * 
 */

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-notificacion-service
* <br><b>Class:</b> SemaforoBalanceDTO.java
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
*
* @category Incluir si la clase es un Modelo, Service, etc.
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SemaforoBalanceDTO implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -4394208397752632210L;

    /**
     * Variable idSistema de tipo String
     */
    private String idSistema;
    
    /**
     * Variable nombreSistema de tipo String
     */
    private String nombreSistema;
    
    /**
     * Variable idDivisa de tipo String
     */
    private int idDivisa;
    
    /**
     * Variable idRol de tipo String
     */
    private String idRol;
    
    /**
     * Variable idUsuario de tipo String
     */
    private String idUsuario;
    
    /**
     * Variable fechaLiquidacion de tipo int usado en la clase.
     * 0 - este dato representa el dia T
     * 1 - este dato representa el dia T + N
     * by: tori 
     */
    private int fechaLiquidacion;
    
    /**
     * Variable semaforo de tipo List<SemaforoDTO>
     */
    private List<SemaforoDTO> semaforo;
    
    /**
     * Variable tipo de tipo String
     */
    private String tipo;

}
