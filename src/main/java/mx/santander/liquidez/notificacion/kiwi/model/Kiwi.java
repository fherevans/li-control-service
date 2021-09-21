
package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Pagina.java <br>
 * <b>Description:</b> Entidad para crear relacion con tabla
 * LIQ_MX_REL_CAT_KIWI.
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
@Table(name = "LIQ_MX_REL_CAT_KIWI")
@Data
@ToString
public class Kiwi implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6829786110205966939L;
    /**
     * Id de kiwi.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KIWI_PK")
    private Long idKiwi;
    /**
     * Id de sistema.
     */
    @Column(name = "ID_SIST")
    @NotBlank
    @NotNull
    private String sistema;

    /**
     * Nombre de kiwi.
     */
    @Column(name = "NOM_KIWI")
    @NotBlank
    @NotNull
    private String nombreKiwi;

    /**
     * 
     */
    @Column(name = "FCH_INI")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaInicio;
    
    
    /**
     * valor de rango
     */
    @Column(name = "FLG_DIA_ACT")
    private int fechaLiquidacion;
    
    /**
     * 
     */
    @Column(name = "CVE_DIV")
    private int idDivisa;
    
    /**
     * 
     */
    @Column(name = "TXT_DESC")
    @NotBlank
    @NotNull
    private String descripcion;
    
    /**
     * fecha de carga.
     */
    @Column(name = "FCH_CARGA")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaCarga;

    /**
     * valor de semaforo.
     */
    @Column(name = "VAL_SEMA")
    @NotBlank
    @NotNull
    private String valSemaforo;
    
    /** Variable kiwiCtrl de tipo KiwiCtrl */
    @Embedded
    @Valid
    private KiwiCtrl kiwiCtrlEmbedded;
    
}
