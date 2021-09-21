package mx.santander.liquidez.toast.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import mx.santander.liquidez.notificacion.kiwi.model.Rol;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> IdToast.java
* <br><b>Description:</b> Clase ID embebida de la entidad Toast.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Entity
*
*/
@Embeddable
public class IdToast implements Serializable{
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3138065633503840637L;

    /**
     * Variable id de tipo String
     */

    @Column(name = "ID_TOAST_PK", updatable = false, insertable = true)
    private String id;
    
    /**
     * Variable rol de tipo Rol
     */
    @JoinColumn(name="ID_ROL_FK", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Rol role;
    
    /**
     * Variable tipoNoti de tipo String
     */
    @Column(name = "TXT_TIP_NOTIF")
    private String tipoNoti;
    
    /**
    * Regresa el valor del atributo id
    * @return el atributo id
    */
    public String getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id
     * @param id el valor id a establecer
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Regresa el valor del atributo rol
     * @return the rol
     */
    public Rol getRole() {
        return role;
    }

    /**
     * Establece el valor del atributo rol
     * @param rol the rol to set
     */
    public void setRole(Rol rol) {
        this.role = rol;
    }

    /**
     * Regresa el valor del atributo tipoNoti
     * @return the tipoNoti
     */
    public String getTipoNoti() {
        return tipoNoti;
    }

    /**
     * Establece el valor del atributo tipoNoti
     * @param tipoNoti the tipoNoti to set
     */
    public void setTipoNoti(String tipoNoti) {
        this.tipoNoti = tipoNoti;
    }

}
