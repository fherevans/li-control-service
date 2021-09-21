/**
 * 
 */
package mx.santander.liquidez.procesamiento.balance.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> RegistrosDTO.java
 * <br><b>Description:</b>
 * Clase de transporte para agrupar la informacion de balance.
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
public class RegistrosDTO implements Serializable {
    
    /**
     * La version de serial.
     */
    private static final long serialVersionUID = 5028050555078977768L;
    
    /**
     * Son los saldos.
     */
    protected SaldosDTO saldos;
    
    /**
     * Son los pagos.
     */
    protected PagosDTO pagos;
    
    /**
     * Son los cobros.
     */
    protected CobrosDTO cobros;
    
    /**
     * Constructor por defecto.
     */
    public RegistrosDTO() {
        super();
        /* Inicializa atributos. */
        this.saldos = new SaldosDTO();
        this.pagos =  new PagosDTO();
        this.cobros = new CobrosDTO();
    }
    
    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Registros [saldos=");
        builder.append(saldos);
        builder.append(", pagos=");
        builder.append(pagos);
        builder.append(", cobros=");
        builder.append(cobros);
        builder.append("]");
        return builder.toString();
    }
    
}
