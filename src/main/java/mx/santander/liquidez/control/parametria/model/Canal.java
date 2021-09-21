package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> Canal.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Getter
@Setter
public class Canal implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = -7923466623189788388L;

    /**
     * Id de canal.
     */
    private Long idCanal;

    /**
     * Nombre de canal.
     */
    private String nombre;

    /**
     * Fecha de carga.
     */
    private Date fechaCarga;

}
