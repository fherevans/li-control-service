/**
 * 
 */
package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.SeguimientoSpeiSpidDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ISeguimientoSpeiSpidService.java
* <br><b>Description:</b> Interface para exponer los servicios de seguimiento de SPEI y SPID.
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
public interface ISeguimientoSpeiSpidService {

    /**
     * Metodo para obtener los filtros para la consulta de seguimiento de SPID y SPEI
     * @return objeto con los filtros encontrados
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object obtenerFiltros() throws ServiceException;
    
    /**
     * Metodo para obtener el total del seguimiento de SPEI y SPID 
     * @param seguimiento datos de los filtros para la consulta
     * @param canal nombre del canal SPID o SPEI
     * @param operacion nombre de operacion CO (real) o PV (programado)
     * @return lista del objeto RespSpeiSpidDTO con los datos de respuesta
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaSeguimientoTotalesSpeiSpid(SeguimientoSpeiSpidDTO seguimiento, String canal, 
            String operacion) throws ServiceException;
    
    /**
     * Metodo para obtener el detalle del seguimiento de SPEI y SPID 
     * @param seguimiento datos de los filtros para la consulta
     * @param canal nombre del canal SPID o SPEI
     * @param operacion nombre de operacion CO (real) o PV (programado)
     * @return lista del objeto DetalleSpeiSpidDTO con los datos de respuesta
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaSeguimientoDetalleSpeiSpid(SeguimientoSpeiSpidDTO seguimiento, String canal, 
            String operacion) throws ServiceException;
}
