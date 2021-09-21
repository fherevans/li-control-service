/**
 * 
 */
package mx.santander.liquidez.control.kiwi.service;

import mx.santander.liquidez.notificacion.model.BitacoraKiwiRequestDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> IBitacoraKiwiService.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 1 oct 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 1 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Service.
*/
public interface IBitacoraKiwiService {
    
    /**
     * Consultar la lista de Kiwis Generados durante el dia Actual.
     * @param request objeto con - el rol y fecha de la consulta del historial
     * @return - Retorna la lista de Kiwis Generados en el Dia de la consulta
     */
    Object obtenerBitacoraKiwiByDay(BitacoraKiwiRequestDTO request);
    
}
