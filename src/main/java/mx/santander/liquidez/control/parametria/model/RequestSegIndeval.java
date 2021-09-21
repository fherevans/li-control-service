package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RequestSegIndeval.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Oscar ibarra
 * @version Control de cambios:
 * @version 1.0 25 Nov. 2020 FSW Praxis, 
 *                          Nombre del autor: Oscar Ibarra
 *                          Paulin Creacion de clase RequestSegIndeval
 * 
 * @since JDK1.8
 * 
 * @company Praxis
 * @created 25 Nov. 2020
 * @category DTO
 */
@Data
@ToString
@EqualsAndHashCode
public class RequestSegIndeval implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Variable idInst de tipo entero
     * Getter
     * Setter
     */
    private int idInst;
    
    /**
     * Variable numFolInst de tipo entero
     * Getter
     * Setter
     */
    private int numFolInst;
    
    /**
     * Variable institucion de tipo String
     * Getter
     * Setter
     */
    private String institucion;
    
    /**
     * Variable contraparte de tipo String
     * Getter
     * Setter
     */
    private String contraparte;
    
    /**
     * Variable fecha de tipo String
     * Getter
     * Setter
     */
    private String fecha;
    
    /**
     * Variable mercado de tipo String
     */
    private String mercado;
    
    /**
     * Variable orderBy de tipo OrderByDTO
     */
    private OrderByDTO orderBy;
}
