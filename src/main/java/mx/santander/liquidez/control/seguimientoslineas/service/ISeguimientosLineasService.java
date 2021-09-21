package mx.santander.liquidez.control.seguimientoslineas.service;

import mx.santander.liquidez.control.seguimientoslineas.dto.model.FiltroLineasCarteraDTO;
import mx.santander.liquidez.control.util.ServiceException;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> ISeguimientoLineasService.java
 * <br><b>Description:</b> Inetrface service para exponer los metodos de negocio 
 * de Seguimientos de Linea
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 18 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category IterfaceService
 */
public interface ISeguimientosLineasService {

    /**
     * Metodo para consultar seguimientos de lineas.
     * @param filtros the tipo linea
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List<{@link ?}> lista con seguimientos de linea iris
     * @throws ServiceException the service exception
     */
    Object procesaLytLinea(FiltroLineasCarteraDTO filtros, String audit) throws ServiceException;    
    
}
