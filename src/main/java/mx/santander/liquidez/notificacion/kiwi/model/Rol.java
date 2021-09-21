package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Rol.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla
 * LIQ_MX_MAE_FRNT_ROL.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Incluir si la clase es un Modelo, Service, etc.
 * 
 */
@Entity
@Table(name = "LIQ_MX_MAE_FRNT_ROL")
@Getter
@Setter
public class Rol implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -6728328973546661899L;

    /**
     * Id de rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL_PK")
    private Long idRol;

    /**
     * nombre de rol.
     */
    @Column(name = "TXT_NOMBRE")
    private String nombre;

    /**
     * fecha de carga del rol.
     */
    @Column(name = "FCH_CARGA")
    private Date fechaCarga;

    /**
     * descripcion del rol.
     */
    @Column(name = "TXT_DESC")
    private String desc;

    /**
     * metodo para asignar fecha de carga del rol.
     * 
     * @param fechaCarga del rol.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga != null) {
            this.fechaCarga = new Date(fechaCarga.getTime());
        } else {
            this.fechaCarga = null;
        }
    }

    /**
     * metodo para obtener fecha de carga del rol.
     * 
     * @return fechaCarga del rol.
     */
    public Date getFechaCarga() {
        if (fechaCarga != null) {
            return new Date(fechaCarga.getTime());
        } else {
            return null;
        }
    }

}
