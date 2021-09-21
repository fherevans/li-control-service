package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> Parametros.java <br>
 * <b>Description:</b> Clase Bean para transportar los datos de parametros de liquidez
 *
 * @author FSW Manuel Gonzalez Quillo
 * @company Praxis
 * @created 27 nov. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 03 sep. 2019 FSW Praxis, Nombre del autor: Manuel Gonzalez Quillo
 *  Creacion de clase
 *
 * @category Bean
 *
 */
@Setter
@Getter
public class Parametros implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -6737608840541059060L;

    /**
     * Variable id de tipo Long
     */
    private String id;
    
    /**
     * Variable txtClave de tipo Long
     */
    private String txtClave;
    
    /**
     * Variable txtValor de tipo Long
     */
    private String txtValor;

    /**
     * Variable fchUltMod de tipo Date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchUltMod")
    private Date fchUltMod;    

    /**
     * Variable fchCarga de tipo Date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("fchCarga")
    private Date fchCarga;    
}
