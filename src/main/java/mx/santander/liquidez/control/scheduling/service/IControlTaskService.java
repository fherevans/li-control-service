/**
 * 
 */
package mx.santander.liquidez.control.scheduling.service;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> IControlTaskService.java
 * <br><b>Description:</b>
 * Define la interfaz para tareas programadas de control.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 4 nov 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 nov 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 *
 */
public interface IControlTaskService {
    
    /**
     * Envia informacion de control al tiempo definido mediante una delay.
     * Si un error ocurre durante el proceso, no se envia excepcion, solo
     * se informa en log.
     */
    void enviarInformacion();

}
