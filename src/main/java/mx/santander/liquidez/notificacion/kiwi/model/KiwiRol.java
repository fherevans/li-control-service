package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Pagina.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla
 * LIQ_MX_REL_KIWI_ROL.
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
 * @category Entity.
 * 
 */
@Entity
@Table(name = "LIQ_MX_REL_KIWI_ROL")
@Getter
@Setter
public class KiwiRol implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 231031909569049807L;

    /**
     * Variable de tipo kiwiRolPK para crear la relacion de la tabla
     */
    @EmbeddedId
    public KiwiRolPK id;

    /**
     * id de kiwi.
     */
    @ManyToOne
    @MapsId("ID_KIWI_FK")
    @JoinColumn(name = "ID_KIWI_FK")
    private Kiwi idKiwiFk;

    /**
     * Id de usuario para asignar rol.
     */
    @ManyToOne
    @MapsId("ID_ROL_FK")
    @JoinColumn(name = "ID_ROL_FK")
    private Rol idRolFk;

    /**
     * fecha de carga.
     */
    @Column(name = "FCH_CARGA")
    private Date fechaCarga;

}
