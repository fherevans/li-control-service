/**
 * 
 */
package mx.santander.liquidez.notificacion.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-notificacion-service
* <br><b>Class:</b> BitacoraKiwi.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 1 oct 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 1 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Getter
@Setter
@ToString
public class BitacoraKiwiDTO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -2843038723239793169L;

    /**
     * titulo del kiwi alertado
     */
    private String titulo;
    
    /**
     * idSistema asociado al kiwi
     */
    private int idSistema;
    
    /**
     * idRol asignado al Kiwi
     */
    private int idRol;
    
    /**
     * 
     */
    private String descripcionRol;
    
    /**
     * Tipo de Kiwi Alertado
     */
    private String tipoKiwi;
    
    /**
     * Mensaje del kiwi alertado
     */
    private String contenidoMensaje;
    
    /**
     * Descripcion del kiwi generado
     */
    private String descripcionKiwi;
    
    /**
     * Fecha de creacion del kiwi
     */
    private String fechaCreacion;
    
}
