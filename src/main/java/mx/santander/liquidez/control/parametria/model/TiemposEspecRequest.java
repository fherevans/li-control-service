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
* <br><b>Class:</b> TiemposEspecRequest.java
* <br><b>Description:</b> Clase Request para transportar los datos de la peticion
* de tiempos especificos
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
@Setter
@Getter
public class TiemposEspecRequest implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3532358662828733393L;
    
    /**
     * Variable operacion de tipo int
     */
    private int operacion;
    
    /**
     * Variable pagina de tipo int
     */
    private int pagina;
    
    /**
     * Variable size de tipo int
     */
    private int size;

}
