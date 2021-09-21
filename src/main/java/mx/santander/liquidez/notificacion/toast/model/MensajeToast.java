package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> ToastMessage.java
* <br><b>Description:</b>
* Clase de estructura de mensaje del toast de liquidez para Redis.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 5 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 5 ago. 2019 FSW Praxis, Jose Manuel Gonzalez Quillo: Creacion de clase
* 
* @category DTO
*
*/
@Getter
@Setter
public class MensajeToast implements Serializable {

    /**
     * La serial version.
     */
    private static final long serialVersionUID = -2331665679945731245L;
    
    /**
     * Es el titulo o cabecero de la toast.
     */
    protected String titulo;
    
    /**
     * Es el texto del mensaje toast.
     */
    protected String texto;
    
    /**
     * Contiene el estatus que guarda el toast.
     */
    protected String estatus;

    /**
     * Constructor por defecto.
     */
    public MensajeToast() {
        super();
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MensajeToast [titulo=");
        builder.append(titulo);
        builder.append(", texto=");
        builder.append(texto);
        builder.append("]");
        return builder.toString();
    }

}
