package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> InstitucionesPaginadaRequest.java <br>
 * <b>Description:</b> Clase Request para transportar los datos de la petición de instituciones.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 06 Nov. 2020
 * @since JDK:1.8
 *
 * @category DTO
 *
 */
@Data
public class InstitucionesPaginadaRequest implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -4095309080465759075L;

    /**
     * Variable nombre de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String nombre;

    /**
     * Variable razonSocial de tipo String
     */
    @NotNull(message = "{message.validate.null}")
    private String razonSocial;

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
