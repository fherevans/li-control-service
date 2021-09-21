package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaOperDTO;
import mx.santander.liquidez.control.parametria.model.OperacionEquivalencia;
import mx.santander.liquidez.control.util.ServiceException;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> IOperacionEquivalenciaService.java <br>
 * <b>Description:</b> Service para crear, actualizar, eliminar y leer operacion
 * equivalencia.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Service
 * 
 */
public interface IOperacionEquivalenciaService {
    
    /**
     * Metodo para obtener las operaciones de equivalencia de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto OperacionEquivalencia con los datos de las opera
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaTodasOper(String audit)throws ServiceException;

    /**
     * Metodo para crear un operacion equivalencia.
     * @param operacionEquivalencia {@link OperacionEquivalencia}.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return operacion equivalencia creada.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object crearOperacionEquivalencia(OperacionEquivalencia operacionEquivalencia, String audit) throws ServiceException;

    /**
     * Metodo para obtener operaciones equivalencia paginado
     * @param filtros parametro validos para filtro de la consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List de operacionEquivalencia con paginacion
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<OperacionEquivalencia> obtenerOperacionesEquivalenciasPage(FiltroEquivalenciaOperDTO filtros, String audit) throws ServiceException;

    /**
     * Metodo para eliminar operacion equivalencia
     * @param id identificador de operacion equivalencia unico
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto con datos de la operacion equivalencia eliminada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminarOperacionEquivalencia(Long id, String audit) throws ServiceException;

    /**
     * Metodo para actualizar una operacion equivalencia
     * @param id identificador unico de la equivalencia de operacion
     * @param opEq operacion equivalencia request
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Operacion equivalencia actualizado
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizarOperacionEquivalencia(OperacionEquivalencia opEq, Long id, String audit) throws ServiceException;

}
