package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> Totales.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 17 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 17 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Modelo.
 *
 */
@Getter
@Setter
@ToString
public class Totales implements Serializable {

    /**
     * Uid serial version generado.
     */
    private static final long serialVersionUID = 8736174618861384442L;

    /**
     * Emisora.
     */
    private Emisora emisora;

    /**
     * Opics.
     */
    private Opics opics;

    /**
     * Dali.
     */
    private Dali dali;
    
    /**
     * Camaras valor de swift.
     */
    private Integer camaras;
    
    /**
     * Transito
     */
    private Integer transito;

}
