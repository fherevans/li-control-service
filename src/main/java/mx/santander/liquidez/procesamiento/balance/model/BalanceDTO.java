/**
 * 
 */
package mx.santander.liquidez.procesamiento.balance.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> BalanceDTO.java
 * <br><b>Description:</b>
 * Clase de transporte para Balance.
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
@RedisHash("Balance")
public class BalanceDTO implements Serializable {
    
    /**
     * La serial version.
     */
    private static final long serialVersionUID = -578831048824597195L;
    
    /**
     * El Id de balance.  
     */
    @Id
    protected long id;
    
    /**
     * Es el Id del sistema.
     */
    @Indexed
    protected int idSistema;
    
    /**
     * Nombre del sistema.
     */
    protected String sistema;
    
    /** 
     * Es el Id de divisa.
     */
    @Indexed
    protected int idDivisa;
    
    /** 
     * Representa la divisa de un balance.
     */
    protected String divisa;
    
    /**
     * Es la fecha de liquidacion de la operacion para balance: DD-MM-YYYY
     */
    @Indexed
    protected String fechaLiquidacion;
    
    /**
     * Es la fecha de registro.
     */
    protected Date tiempoRegistro;
    
    /**
     * Son los registros de los balances en cuanto a saldos.
     */
    protected RegistrosDTO registros;
    
    /**
     * Constructor por defecto.
     */
    public BalanceDTO() {
        super();
        /* Inicializa atributos. */
        this.registros = new RegistrosDTO();
    }

    /**
     * Genera un hash a partir del Id divisa y el Id sistema.
     * @return es el hash code generado
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fechaLiquidacion.hashCode();
        result = prime * result + idDivisa;
        result = prime * result + idSistema;
        return result;
    }
    
    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Balance [id=");
        builder.append(id);
        builder.append(", idSistema=");
        builder.append(idSistema);
        builder.append(", sistema=");
        builder.append(sistema);
        builder.append(", idDivisa=");
        builder.append(idDivisa);
        builder.append(", divisa=");
        builder.append(divisa);
        builder.append(", fechaLiquidacion=");
        builder.append(fechaLiquidacion);
        builder.append(", tiempoRegistro=");
        builder.append(tiempoRegistro);
        builder.append(", registros=");
        builder.append(registros);
        builder.append("]");
        return builder.toString();
    }
    
}