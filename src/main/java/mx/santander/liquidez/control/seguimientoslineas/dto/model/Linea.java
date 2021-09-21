/**
 * 
 */
package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-service
* <br><b>Class:</b> Linea.java
* <br><b>Description:</b> Clase Entity para mapear los datos de la tabla LIQ_MX_MAE_INT_KRTRA.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 22 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 22 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Entity
*
*/
@Getter
@Setter
public class Linea implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 3799474930682310391L;
    
    /**
     * Variable id de tipo Long
     */
    private Long id;
    
    /**
     * Variable txtNom de tipo String
     */
    private String txtNom;
    
    /**
     * Variable impLinNeg de tipo String
     */
    private String impLinNeg;
    
    /** Variable fechaVencimiento de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm", timezone = "CST")
    @JsonProperty("fechaVencimiento")
    private Date fechaVencimiento;
    
    /** Variable fechaTraspaso de tipo Date. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm", timezone = "CST")
    @JsonProperty("fechaCarga")
    private Date fechaCarga;
    
    /**
     * Variable flgComp de tipo String
     */
    private String flgComp;
    
    /**
     * Variable cveLin de tipo String
     */
    private String cveLin;
    
    /**
     * Variable txtOri de tipo String
     */
    private String txtOri;

}
