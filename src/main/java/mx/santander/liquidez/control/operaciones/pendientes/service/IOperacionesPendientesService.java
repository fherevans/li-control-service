package mx.santander.liquidez.control.operaciones.pendientes.service;

import java.util.List;

import mx.santander.liquidez.control.operaciones.pendientes.dto.model.OperacionesConciliadasDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IOperacionesPendientesService.java
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
public interface IOperacionesPendientesService {

    /**
     * Metodo para consultar Operaciones Pendientes.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List<{@link OperacionesConciliadasDTO}> lista Operaciones Pendientes
     * @throws ServiceException Excepcion de negocio de la capa de servicios
     */
    List<OperacionesConciliadasDTO> getListaOperacionesPendientes(String audit) throws ServiceException;
}
