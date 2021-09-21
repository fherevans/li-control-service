package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> FiltroLineasCarteraDTO.java <br>
 * <b>Description:</b> DTO para realizar filtro en busquedas de lineas de cartera e iris.
 *
 * @author Manuel Gonzalez Quillo
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Manuel Gonzalez Quillo
 * Creacion de la clase
 *
 * @category Model.
 *
 */
@Getter
@Setter
public class FiltroLineasCarteraDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 6614887265367075859L;
    
    /**
     * Variable tipoLinea de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String tipoLinea;

    /**
     * Variable pagina de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int pagina;
    
    /**
     * Variable size de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int size;

}
