package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> FiltroEquivalenciaDivDTO.java <br>
 * <b>Description:</b> DTO para realizar filtro en busquedas.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Model.
 *
 */
@Data
public class FiltroEquivalenciaDivDTO implements Serializable{
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -6094887462659294240L;

    /**
     * Variable sistema de tipo int
     */
    @Range(min = 0, message = "{message.validate.blank}")
    private int sistema;
    
    /**
     * Variable clave de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String clave;

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
