package mx.santander.liquidez.control.reporte.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> DetalleFlujoEstimadoDTO.java <br>
 * <b>Description:</b> Bean.
 *
 * @author FSW Praxis Victor Basurto Alonso
 * @company Praxis
 * @created 08 Mar. 2021
 * @since JDK:1.8
 *
 * @version Control de cambios:
 * @version 1.0 08 Mar. 2021 FSW Lacertus VBA: Creacion de la clase
 *
 * @category DTO
 *
 */

public class DetalleFlujoEstimadoDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Variable nombreArea de tipo String
     */
    private String nombreArea;

    /**
     * Variable descArea de tipo String
     */
    private String descArea;

    /**
     * Variable tipoOper de tipo String
     */
    private String tipoOper;

    /**
     * Variable contraparte de tipo String
     */
    private String contraparte;

    /**
     * Variable cargo de tipo BigDecimal
     */
    private BigDecimal cargo;

    /**
     * Variable abono de tipo BigDecimal
     */
    private BigDecimal abono;

    /**
     * Variable mercado de tipo String
     */
    private String mercado;

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescArea() {
        return descArea;
    }

    public void setDescArea(String descArea) {
        this.descArea = descArea;
    }

    public String getTipoOper() {
        return tipoOper;
    }

    public void setTipoOper(String tipoOper) {
        this.tipoOper = tipoOper;
    }

    public String getContraparte() {
        return contraparte;
    }

    public void setContraparte(String contraparte) {
        this.contraparte = contraparte;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

}
