package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> GruposOperacion.java
* <br><b>Description:</b> Clase entity para obtener los datos de las agrupaciones 
* de las operaciones de liquidez.
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
public class GruposOperacion implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 1234993706348906313L;

    /**
     * Variable id de tipo String
     */
    private Long id;

    /**
     * Variable descipcion de tipo String
     */
    private String descripcion;
    
    /**
     * Variable numBloque de tipo int
     */
    private int numBloque;

    /**
     * Variable idUser de tipo String
     */
    private String idUserMod;
    
    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchUltMod;

    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchCarga;
}
