/**
 * 
 */
package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tori
 *
 */
@Getter
@Setter
@RedisHash("MensajeFront")
public class MensajeFrontDTO implements Serializable{

    /**
     * dato serial
     */
    private static final long serialVersionUID = 2163896647904709727L;

    /**
     * Variable id de tipo int usado en la clase.
     * by: tori 
     */
    @Id
    private int id;
    
    /**
     * Variable color de tipo String usado en la clase.
     * by: tori 
     */
    private String color;
    
    /**
     * Variable mensaje de tipo String usado en la clase.
     * by: tori 
     */
    private String mensaje;
}
