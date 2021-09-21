package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Data;
/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> QueryParamDTO.java <br>
 * <b>Description:</b> Clase DTO que se encarga
 * de transportar los valores obtenidos de los
 * saldos historicos de valores
 * para los sistemas SIAC, SPEI, DALI
 * @version Control de cambios:
 * @version 1.0, 26 nov. 2020 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  26 nov. 2020
 * @category DTO
 */
@Data
public class SaldoDTO implements Serializable {

    /**
     * Serial version
     */
    private static final long serialVersionUID = 7453373794716024698L;

    /**
     * Variable nombre de tipo String
     */
    private String nombre;
    
    /**
     * Variable saldo de tipo double
     */
    private double saldo;
}
