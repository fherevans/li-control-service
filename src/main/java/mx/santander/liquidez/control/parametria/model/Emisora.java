package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> Emisora.java <br>
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
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Getter
@Setter
@ToString
public class Emisora implements Serializable {

    /**
     * Serial version uid generado.
     */
    private static final long serialVersionUID = 8804842915910866954L;

    private String tipoValor;

    private String nombreEmisora;

    private String serie;

    private String isin;
}