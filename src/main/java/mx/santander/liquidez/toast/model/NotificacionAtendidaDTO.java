package mx.santander.liquidez.toast.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> NotificacionesAtendidasDTO.java
* <br><b>Description:</b> Clase DTO para transportar los datos de las 
* notificaciones atendidas.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 2 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 2 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO
*
*/
public class NotificacionAtendidaDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3416773911214709566L;
    
    /**
     * Variable notificacionesAten de tipo List<NotificacionAtendida>
     */
    private List<NotificacionAtendida> notificacionesAten;

    /**
     * Regresa el valor del atributo notificacionesAten
     * @return the notificacionesAten
     */
    public List<NotificacionAtendida> getNotificacionesAten() {
        return new ArrayList<NotificacionAtendida>(notificacionesAten);
    }

    /**
     * Establece el valor del atributo notificacionesAten
     * @param notificacionesAten the notificacionesAten to set
     */
    public void setNotificacionesAten(List<NotificacionAtendida> notificacionesAten) {
        List<NotificacionAtendida> notificacionesAtenCopy = new ArrayList<NotificacionAtendida>();
        notificacionesAtenCopy.addAll(notificacionesAten);
        this.notificacionesAten = notificacionesAtenCopy;
    }

    
}
