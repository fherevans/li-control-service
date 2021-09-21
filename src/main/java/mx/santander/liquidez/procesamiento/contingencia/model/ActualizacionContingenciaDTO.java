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
 * <br><b>Class:</b> ActualizacionContingenciaDTO.java
 * <br><b>Description:</b>
 * Clase de transporte para solicitud de actualizacion de contingencia.
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
public class ActualizacionContingenciaDTO implements Serializable {

    /**
     * La version de serial.
     */
    private static final long serialVersionUID = 3658263928373311431L;

    /**
     * Es el usuario que realiza la solicitud.
     */
    protected String idUsuario;
    
    /**
     * Es la direccion IP remota de la solicitud.
     */
    protected String ipRemota;
    
    /**
     * Es el estatus a actualizar.
     */
    protected String estatus;

    /**
     * Constructor por defecto.
     */
    public ActualizacionContingenciaDTO() {
        super();
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ActualizacionContingencia [idUsuario=");
        builder.append(idUsuario);
        builder.append(", ipRemota=");
        builder.append(ipRemota);
        builder.append(", estatus=");
        builder.append(estatus);
        builder.append("]");
        return builder.toString();
    }

}
