package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-utilidad
* <br><b>Class:</b> KiwiCtrl.java
* <br><b>Description:</b> Clase embebida en la entidad TipoCambio.
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Marcos Magana Hernandez
* Creacion de clase
*
* @category Entity.
*
* @see TipoCambioCtrl
*/
@Embeddable
@Getter
@Setter
@ToString
public class KiwiCtrl implements Serializable {
    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -5284129593832272777L;
    
    /**
     * valor de rango
     */
    @Column(name = "TXT_REGLA")
    private String regla;
    
    /**
     * valor de tipo de operacion
     * BALANCE* - este sirve para las notificaciones dentro de Balance y Buffer
     * 
     * Estos aun estan pendientes para agregar en el catalogo de kiwis
     * SIAC_CLS - este es para el kiwi de alertas de las necesidades que originó CLS
     * SIAC_DRM_SOBREGIRO  - Sobregiro efectivo de SIAC alcanzo el monto de DRM
     * PAGO_DESPUES - Un pago mayor a 500 millones despues de las 5pm
     * HORA_CORTE - Alertas con la hora de Liquidación(ingresos)
     */
    @Column(name = "TXT_TIPO")
    private String tipoOperacion;
    
    /**
     * bandera de tipo de notificacion
     * 
     * E - Email
     * T - Toast
     * A - Ambos
     */
    @Column(name = "FLG_TIP_NOTIF")
    private String flagTipoNotificacion;
}
