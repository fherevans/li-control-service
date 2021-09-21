package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Permiso.java <br>
 * <b>Description:</b> Entidad para crear relacion con la tabla
 * LIQ_MX_MAE_USR_PREF.
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
@Getter
@Setter
public class Preferencia implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 8717445004710469990L;

    /**
     * In preferencia.
     */
    private Long idPreferencia;

    /**
     * Id de usuario a asignar preferencia.
     */
    private String idUser;

    /**
     * Id de pagina para asignar preferencia.
     */
    private Long idPage;

    /**
     * Nombre de la preferencia.
     */
    private String tipoPreferencia;

    /**
     * bandera para la propiedad true o false.
     */
    private String flgValor;

    /**
     * Flg columna.
     */
    private String flgCol;

    /**
     * fecha de carga de la preferencia.
     */
    private Date fechaCarga;

    /**
     * metodo para asignar la fecha de carga del permiso.
     * 
     * @param fechaCarga del permiso.
     */
    public void setFechaCarga(Date fechaCarga) {
        if (fechaCarga == null) {
            this.fechaCarga = null;
        } else {
            this.fechaCarga = new Date(fechaCarga.getTime());
        }

    }

    /**
     * metodo para obtener la fecha de carga del permiso.
     * 
     * @return fechaCarga del permiso.
     */
    public Date getFechaCarga() {
        if (fechaCarga == null) {
            return null;
        } else {
            return new Date(fechaCarga.getTime());
        }
    }

}
