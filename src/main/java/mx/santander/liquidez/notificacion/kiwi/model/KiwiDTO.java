
package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


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
@Getter
@Setter
public class KiwiDTO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 3933366687396750154L;

    /**
     * Id de sistema.
     */
    @NotBlank
    @NotNull
    private String sistema;

    /**
     * Nombre de kiwi.
     */
    @NotBlank
    @NotNull
    private String nombreKiwi;

    /**
     * 
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaInicio;
    
    /**
     * 
     */
    private String idDivisa;
    
    /**
     * 
     */
    @NotBlank
    @NotNull
    private String descripcion;
    
    /**
     * fecha de carga.
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaCarga;

    /**
     * valor de semaforo.
     */
    @NotBlank
    @NotNull
    private String valSemaforo;
    
    /**
     * 
     */
    @NotNull
    private Long idRol;
    
    /**
     * 
     */
    @NotNull
    private Long idKiwi;
    
    
    /** Variable kiwiCtrlDTO de tipo KiwiCtrlDTO */
    @Embedded
    @Valid
    private KiwiCtrlDTO kiwiCtrlEmbedded = new KiwiCtrlDTO();    
}
