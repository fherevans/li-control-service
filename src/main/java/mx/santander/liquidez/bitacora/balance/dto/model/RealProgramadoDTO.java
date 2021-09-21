package mx.santander.liquidez.bitacora.balance.dto.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> RealProgramadoDTO.java
* <br><b>Description:</b> DTO para almacenar los datos Lineas Iris
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category DTO.
*
*/
@Getter
@Setter
public class RealProgramadoDTO implements Serializable {

    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -8803189033767380085L;

    /** Variable id de tipo Long */    
    protected Long id;
    
    /** Variable sistema de tipo String */    
    protected String sistema;
    
    /** Variable divisaOrigen de tipo String */    
    protected String divisaOrigen;
    
    /** Variable linea de tipo Double */    
    protected Double linea;
    
    /** Variable importeReal de tipo Double */    
    protected Double importeReal;
    
    /** Variable importeProgramado de tipo Double */    
    protected Double importeProgramado;
    
    /** Variable fechaCarga de tipo Date */    
    protected Date fechaCarga; 
    
}
