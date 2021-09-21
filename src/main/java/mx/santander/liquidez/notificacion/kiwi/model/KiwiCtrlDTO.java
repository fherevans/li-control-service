package mx.santander.liquidez.notificacion.kiwi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-utilidad
* <br><b>Class:</b> KiwiCtrlDTO.java
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
* @see KiwiCtrlDTO
*/
@Embeddable
@Getter
@Setter
public class KiwiCtrlDTO implements Serializable {



    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 8063271395855858590L;

    /**
     * valor de rango
     */
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
    private String tipoOperacion;
    
    /**
     * bandera de tipo de notificacion
     * 
     * E - Email
     * T - Toast
     * A - Ambos
     */
    private String flagTipoNotificacion;
    
    /**
     * valor de rango
     */
    private int fechaLiquidacion;
    
    /**
     * El nombre del sistema que se mostrara en el catalogo de kiwis
     */
    private String nombreSistema;
}
