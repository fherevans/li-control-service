package mx.santander.liquidez.toast.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> NotificacionesDTO.java
* <br><b>Description:</b> Clase DTO para transportar la informacion de las 
* notificaciones de liquidez.
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
public class NotificacionesDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7053050139102416225L;
    
    /**
     * Variable notificaciones de tipo List<Toast>
     */
    private List<Toast> notificaciones;

    /**
     * Regresa el valor del atributo notificaciones
     * @return the notificaciones
     */
    public List<Toast> getNotificaciones() {
        return new ArrayList<Toast>(notificaciones);
    }

    /**
     * Establece el valor del atributo notificaciones
     * @param notificaciones the notificaciones to set
     */
    public void setNotificaciones(List<Toast> notificaciones) {
        List<Toast> notificacionesCopy = new ArrayList<Toast>();
        notificacionesCopy.addAll(notificaciones);
        this.notificaciones = notificacionesCopy;
    }

}
