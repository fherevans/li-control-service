package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> Toast.java
* <br><b>Description:</b> 
* Clase RedisHash para guardar objeto en memoria de una toast.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 2 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 2 ago. 2019 FSW Praxis, Jose Manuel Gonzalez Quillo: Creacion de clase
*
* @category DTO
*/
@Getter
@Setter
@ToString
@RedisHash(value = "Toast")
public class ToastRedis implements Serializable {
    
    /**
     * La serial version.
     */
    private static final long serialVersionUID = -5747213812408192866L;
    
    /**
     * Id del toast.
     */
    @Id
    protected long id;
    
    /**
     * Identifica el Id de role para este toast.
     */
    @Indexed
    protected long idRol;

    /**
     * Es la fecha de carga o tiempo registro.
     */
    private Date tiempoRegistro;
    
    /**
     * Contiene el tipo de notificacion toast.
     */
    protected TipoToast tipo;
        
    /**
     * Contiene el detalle de la notificacion  toast.
     */
    private MensajeToast mensaje;

    /**
     * Constructor por defecto.
     */
    public ToastRedis() {
        super();
    }

}
