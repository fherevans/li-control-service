package mx.santander.liquidez.toast.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> NotificacionAtendida.java
* <br><b>Description:</b> Clase bean para almacenar el estatus de la 
* notificacion atendida de liquidez.
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
* @category Bean
*
*/
public class NotificacionAtendida implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 2179428088090003710L;
    
    /**
     * Variable idNoti de tipo String
     */
    private String idNoti;
    
    /**
     * Variable estatus de tipo String
     */
    private String estatus;

    /**
     * Regresa el valor del atributo idNoti
     * @return the idNoti
     */
    public String getIdNoti() {
        return idNoti;
    }

    /**
     * Establece el valor del atributo idNoti
     * @param idNoti the idNoti to set
     */
    public void setIdNoti(String idNoti) {
        this.idNoti = idNoti;
    }

    /**
     * Regresa el valor del atributo estatus
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Establece el valor del atributo estatus
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}
