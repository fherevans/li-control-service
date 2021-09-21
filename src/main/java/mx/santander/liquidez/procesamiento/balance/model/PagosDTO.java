/**
 * 
 */
package mx.santander.liquidez.procesamiento.balance.model;

import java.io.Serializable;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> PagosDTO.java
 * <br><b>Description:</b>
 * Clase de transporte con un conjunto de campos con informacion de pagos de balance.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 26, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 26, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category DTO
 *
 */
public class PagosDTO implements Serializable {
    
    /**
     * La serial version.
     */
    private static final long serialVersionUID = -3411679472393139062L;
    
    /** 
     * Son los pagos reales.
     */
    protected double pagosReal;
    
    /**
     * Son los pagos programados.
     */
    protected double pagosProgramados;

    /**
     * Constructor por defecto.
     */
    public PagosDTO() {
        super();
    }

    /** 
     * Regresa el valor del atributo pagosReal
     * @return el atributo pagosReal
     */
    public double getPagosReal() {
        return pagosReal;
    }

    /**
     * Establece el valor del atributo pagosReal
     * @param pagosReal el valor de pagosReal a establecer
     */
    public void setPagosReal(double pagosReal) {
        this.pagosReal = pagosReal;
    }

    /** 
     * Regresa el valor del atributo pagosProgramados
     * @return el atributo pagosProgramados
     */
    public double getPagosProgramados() {
        return pagosProgramados;
    }

    /**
     * Establece el valor del atributo pagosProgramados
     * @param pagosProgramados el valor de pagosProgramados a establecer
     */
    public void setPagosProgramados(double pagosProgramados) {
        this.pagosProgramados = pagosProgramados;
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pagos [pagosReal=");
        builder.append(pagosReal);
        builder.append(", pagosProgramados=");
        builder.append(pagosProgramados);
        builder.append("]");
        return builder.toString();
    }
    
}
