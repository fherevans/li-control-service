/**
 * 
 */
package mx.santander.liquidez.toast.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> Toast.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 1 ago 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 1 ago 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Entity.
*
*/
@Entity
@Table(name = "LIQ_MX_REL_FRNT_TOAST")
public class Toast implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -3629720909876637993L;
    
    /**
     * Variable idToast de tipo IdToast
     */
    @EmbeddedId
    private IdToast idToast;
    
    /**
     * Variable txt_titulos de tipo String
     */
    @Column(name = "TXT_TITULO")
    private String titulo;

    /**
     * Variable txt_msg de tipo String
     */
    @Column(name = "TXT_MSG")
    private String mensage;
    
    
    /**
     * Variable flg_estatus de tipo char
     */
    @Column(name = "FLG_STATU")
    private String estatus;
    
    /**
     * Variable fchCarga de tipo Date
     */
    @Column(name = "FCH_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fchCarga;

    /**
    * Regresa el valor del atributo titulo
    * @return el atributo titulo
    */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el valor del atributo titulo
     * @param titulo el valor titulo a establecer
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
    * Regresa el valor del atributo mensage
    * @return el atributo mensage
    */
    public String getMensage() {
        return mensage;
    }

    /**
     * Establece el valor del atributo mensage
     * @param mensage el valor mensage a establecer
     */
    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    /**
    * Regresa el valor del atributo estatus
    * @return el atributo estatus
    */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Establece el valor del atributo estatus
     * @param estatus el valor estatus a establecer
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
    * Regresa el valor del atributo fchCarga
    * @return el atributo fchCarga
    */
    public Date getFchCarga() {
        return (Date) fchCarga.clone();
    }

    /**
     * Establece el valor del atributo fchCarga
     * @param fchCarga el valor fchCarga a establecer
     */
    public void setFchCarga(Date fchCarga) {
        this.fchCarga = (Date) fchCarga.clone();
    }

    /**
     * Regresa el valor del atributo idToast
     * @return the idToast
     */
    public IdToast getIdToast() {
        return idToast;
    }

    /**
     * Establece el valor del atributo idToast
     * @param idToast the idToast to set
     */
    public void setIdToast(IdToast idToast) {
        this.idToast = idToast;
    }
    
}
