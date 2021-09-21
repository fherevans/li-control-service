/**
 * 
 */
package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-notificacion-service
* <br><b>Class:</b> SemaforoBalancesRedis.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 4 oct 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 4 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("SemaforoBalance")
public class SemaforoBalancesRedis implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1288608294342200206L;

    /**
     * Id del semaforo en Redis este es un incremental y unico.
     */
    @Id
    protected Long id;
    
    /**
     * idRol es el idRol asignado al color
     */
    @Indexed
    protected Long idRol;
    
    /**
     * Id sistema al que aplica este semaforo
     */
    @Indexed
    protected Long idSistema;

    /**
     * idDivisa agregada al semaforo
     */
    @Indexed
    protected Long idDivisa;
    
    /**
     * Es la fecha de liquidacion de la operacion para balance: DD-MM-YYYY
     */
    @Indexed
    protected String fechaLiquidacion;

    /**
     * nombre del sistema asignado al semaforo
     */
    protected String nombreSistema;
    
    /**
     * cveDivisa y semaforo generado
     */
    protected String cveDivisa;
    
    /**
     * Color del semaforo agregado
     */
    protected String colorsemaforo;
    
}