/**
 * 
 */
package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.RespSiacDTO;
import mx.santander.liquidez.control.parametria.model.SeguimientoSiacDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ISeguimientoSiacService.java
* <br><b>Description:</b> Interface para exponer los servicios de seguimiento de SIAC.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service.
*
*/
public interface ISeguimientoSiacService {
    
    /**
     * Metodo para obtener el detalle del seguimiento de SIAC 
     * @param seguimiento datos de los filtros para la consulta
     * @return lista del objeto {@link RespSiacDTO} con los datos de respuesta
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaSeguimientoDetalleSiac(SeguimientoSiacDTO seguimiento) throws ServiceException;
}
