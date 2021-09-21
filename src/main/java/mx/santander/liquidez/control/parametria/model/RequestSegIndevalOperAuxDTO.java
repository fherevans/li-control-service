package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> RequestSegIndevalOperAuxDTO.java
* <br><b>Description:</b> DTO.
*
* @author Victor Basurto Alonso
* @company Praxis
* @created 18 Nov. 2020
* @since JDK:1.8
*
* @category DTO.
*
*/
@Data 
@ToString
@EqualsAndHashCode
public class RequestSegIndevalOperAuxDTO implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 1L;
    /**
     * Variable operacion de tipo String
     */
    private String operacion;
    /**
     * Variable mercado de tipo String
     */
    private String mercado;
    /**
     * Variable tipoValor de tipo String
     */
    private String tipoValor;
    /**
     * Variable fecha de tipo String
     */
    private String fecha;
    /**
     * Variable estatus de tipo String
     */
    private String estatus;
    /**
     * Variable emisora de tipo String
     */
    private String emisora;
    /**
     * Variable tipoOperacion de tipo String
     */
    private String tipoOperacion;
    /**
     * Variable serie de tipo String
     */
    private String serie;
    /**
     * Variable order de tipo String
     */
    private String order;
    /**
     * Variable by de tipo String
     */
    private String by;
}

