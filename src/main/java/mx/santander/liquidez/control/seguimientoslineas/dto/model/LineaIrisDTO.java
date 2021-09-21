package mx.santander.liquidez.control.seguimientoslineas.dto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embedded;
import javax.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> LineaIrisDTO.java
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
public class LineaIrisDTO implements Serializable {

    /** Variable idLineaFk de tipo Long */
    private static final long serialVersionUID = 1125506846987074879L;

    /** Variable idLineaFk de tipo Long. */
    protected Long idLineaFk;

    /** Variable fechaHora de tipo Date. */
    protected Date fechaHora;

    /** Variable contraParte de tipo String. */
    protected String contraParte;

    /** Variable lineaIntradiaDisponible de tipo String. */
    protected BigDecimal lineaIntradiaDisponible;

    /** Variable overNight de tipo Double. */
    protected BigDecimal overNight;

    /** Variable lineaUtilizada de tipo Double. */
    protected BigDecimal lineaUtilizada;

    /** Variable disponible de tipo Double. */
    protected BigDecimal disponible;

    /** Variable fechaActualizacion de tipo Date. */
    protected Date fechaActualizacion;

    /** Variable divisa de tipo String. */
    protected String divisa;

    /**  Variable seguimientoLineaPort de tipo SeguimientoLineaPortDTO. */
    @Embedded
    @Valid
    protected LineaIrisPortDTO lineaIrisPort = new LineaIrisPortDTO();



}
