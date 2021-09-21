package mx.santander.liquidez.control.reporte.model;

import java.io.Serializable;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> ResponseReporteDTO.java <br>
 * <b>Description:</b> Bean
 * 
 * @author FSW Praxis Christian Iván Miranda Paulin
 * @company Praxis
 * @created 5 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Praxis, Nombre del autor: Christian Iván Miranda
 *          Paulin Creacion de clase ResponseReporteDTO
 * 
 * @category DTO
 * 
 */
public class ResponseReporteDTO implements Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4930672213518695414L;
    /**
     * Variable dataArchivo de tipo String
     */
    private String dataArchivo;
    /**
     * Variable message de tipo message
     */
    private String message;
    /**
     * Regresa el valor del atributo dataArchivo
     * 
     * @return el atributo dataArchivo
     */
    public String getDataArchivo() {
        return dataArchivo;
    }
    /**
     * Establece el valor del atributo dataArchivo
     * 
     * @param dataArchivo el valor de dataArchivo a establecer
     */
    public void setDataArchivo(String dataArchivo) {
        this.dataArchivo = dataArchivo;
    }
    /**
     * Regresa el valor del atributo mensaje
     * 
     * @return el atributo dataArchivo
     */
    public String getMessage() {
        return message;
    }
    /**
     * Establece el valor del atributo message
     * 
     * @param message el valor de message a establecer
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
