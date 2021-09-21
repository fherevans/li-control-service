package mx.santander.liquidez.control.reporte.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> RequestReporteEspecialesDTO.java <br>
 * <b>Description:</b> Bean.
 *
 * @author FSW Praxis Victor Basurto Alonso
 * @company Praxis
 * @created 08 Mar. 2021
 * @since JDK:1.8
 *
 * @version Control de cambios:
 * @version 1.0 08 Mar. 2021 FSW Lacertus VBA: Creacion de la clase
 *
 * @category DTO
 *
 */

public class RequestReporteEspecialesDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -181378705744583787L;

    /**
     * Variable fecha de tipo String
     */
    private String fecha;

    /**
     * Variable reporteEspecial de tipo Map<String, List<Serializable>>
     */
    private Map<String, List<Serializable>> reporteEspecial;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Map<String, List<Serializable>> getReporteEspecial() {
        return reporteEspecial;
    }

    public void setReporteEspecial(Map<String, List<Serializable>> reporteEspecial) {
        this.reporteEspecial = reporteEspecial;
    }

}
