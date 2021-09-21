/**
 * 
 */
package mx.santander.liquidez.procesamiento.balance.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> SaldosDTO.java
 * <br><b>Description:</b>
 * Clase de transporte para los distintos saldos que se tienen en balance.
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
@Getter
@Setter
public class SaldosDTO implements Serializable {
    
    /**
     * La version de serial.
     */
    private static final long serialVersionUID = -4954373060725209784L;
    
    /**
     * Es el saldo de balance real.
     */
    protected double saldoReal;
    
    /**
     * Es el saldo inicial con que abren las operaciones.
     */
    protected double saldoInicial;
    
    /**
     * Es un saldo programado.
     */
    protected double saldoProgramado;
    
    /**
     * Es el saldo de la linea.
     */
    protected double saldoLinea;

    /**
     * Constructor por defecto.
     */
    public SaldosDTO() {
        super();
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Saldos [saldoReal=");
        builder.append(saldoReal);
        builder.append(", saldoInicial=");
        builder.append(saldoInicial);
        builder.append(", saldoProgramado=");
        builder.append(saldoProgramado);
        builder.append(", saldoLinea=");
        builder.append(saldoLinea);
        builder.append("]");
        return builder.toString();
    }

}