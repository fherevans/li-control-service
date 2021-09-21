/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ContingenciaDTO.java
 * <br><b>Description:</b>
 * Clase de transporte para datos de contigencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 22 ene 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 22 ene 2020 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category DTO
 *
 */
@Setter
@Getter
public class ContingenciaDTO implements Serializable {

    /**
     * La version de serial.
     */
    private static final long serialVersionUID = 3077527285799063375L;
    
    /** 
     * Contiene el estatus de contingencia.
     */
    protected String estatus;
    
    /** 
     * Contiene la descripcion el estatus de contingencia.
     */
    protected String descripcion;
    
    /**
     * Es la fecha y hora de ultima modificacion.
     */
    protected String ultimaModificacion;
    
    /**
     * Constructor por defecto.
     */
    public ContingenciaDTO() {
        super();
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Contingencia [estatus=");
        builder.append(estatus);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append(", ultimaModificacion=");
        builder.append(ultimaModificacion);
        builder.append("]");
        return builder.toString();
    }
    
}
