package mx.santander.liquidez.control.reporte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> RequestReporteDTO.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Praxis Christian Iván Miranda Paulin
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Praxis, Nombre del autor: Christian Iván Miranda
 *          Paulin Creacion de clase RequestReporteDTO
 * 
 * @since JDK1.8
 * 
 * @company Praxis
 * @created 5 ago. 2019
 * @category DTO
 */
public class RequestReporteDTO implements Serializable {
    /** Define la Constante serialVersionUID. */
    private static final long serialVersionUID = -3300102366460442074L;
    /**
     * Variable value de tipo String
     */
    private String value;
    /**
     * Variable columnas de tipo List<String[]>
     */
    @NotNull(message = "{reporte.message.validate.null}")
    private List<String[]> columnas;

    /**
     * Variable columnas de tipo List<String[]>
     */
    @NotNull(message = "{reporte.message.validate.null}")
    private List<String[]> filas;

    /**
     * Variable identificador de tipo Integer
     */
    @NotNull(message = "{reporte.message.validate.null}")
    private Integer identificador;

    /**
     * Variable imagen de tipo String
     */
    private byte[] imagen;

    /**
     * Regresa el valor del atributo columnas
     * 
     * @return el atributo columnas
     */
    public List<String[]> getColumnas() {
        return new ArrayList<String[]>(columnas);
    }

    /**
     * Establece el valor del atributo columnas
     * 
     * @param columnas el valor de columnas a establecer
     */
    public void setColumnas(List<String[]> columnas) {
        List<String[]> col = new ArrayList<String[]>();
        col.addAll(columnas);
        this.columnas = col;
    }

    /**
     * Regresa el valor del atributo filas
     * 
     * @return el atributo filas
     */
    public List<String[]> getFilas() {
        return new ArrayList<String[]>(filas);
    }

    /**
     * Establece el valor del atributo filas
     * 
     * @param filas el valor de filas a establecer
     */
    public void setFilas(List<String[]> filas) {
        List<String[]> fil = new ArrayList<String[]>();
        fil.addAll(filas);
        this.filas = fil;
    }

    /**
     * Regresa el valor del atributo identificador
     * 
     * @return el atributo identificador
     */
    public Integer getIdentificador() {
        return identificador;
    }

    /**
     * Establece el valor del atributo identificador
     * 
     * @param identificador el valor de identificador a establecer
     */
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    /**
     * Regresa el valor del atributo imagen
     * 
     * @return el atributo imagen
     */
    public byte[] getImagen() {
        if (imagen != null) {
            return imagen.clone();
        } else {
            return new byte[0];
        }

    }

    /**
     * Establece el valor del atributo imagen
     * 
     * @param imagen el valor de imagen a establecer
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen.clone();
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}