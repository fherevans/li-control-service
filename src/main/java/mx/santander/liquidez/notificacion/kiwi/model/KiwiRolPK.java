package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> Pagina.java <br>
 * <b>Description:</b> Llave primaria para kiwiRol.
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
 * @category Model.
 * 
 */
@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class KiwiRolPK implements Serializable {

    /**
     * uid generado.
     */
    private static final long serialVersionUID = 8207343222194334707L;

    /**
     * Id de kiwi.
     */
    @Column(name = "ID_KIWI_FK")
    private Long idKiwiFk;

    /**
     * Id de Rol.
     */
    @Column(name = "ID_ROL_FK")
    private Long idRolFk;
    
}
