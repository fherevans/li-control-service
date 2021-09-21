package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.OperacionesLiq;
import mx.santander.liquidez.control.parametria.model.OperacionesRequest;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> IOperacionesService.java
* <br><b>Description:</b> Interface Service para exponer los metodos de negocio 
* de las operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IOperacionesService {
    
    /**
     * Metodo para consultar todas las de operaciones de liquidez por filtros
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link OperacionesLiq} con los datos de las operaciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaOperaciones(String audit) throws ServiceException;

    /**
     * Metodo para consultar todas las de operaciones de liquidez por filtros
     * @param request objeto que contiene los filtros a utilizar en consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link OperacionesLiq} con los datos de las operaciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<OperacionesLiq> consultaOperacionesPag(OperacionesRequest request, String audit) throws ServiceException;

    /**
     * Metodo para crear una nueva operacion de liquidez
     * @param operacion datos de la operacion a crear en liqudiez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la operacion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object guardaOperacion(OperacionesLiq operacion, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar una operacion de liquidez
     * @param operacion datos de la operacion a crear en liqudiez
     * @param id identificador unico de operacion en liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la operacion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizaOperacion(OperacionesLiq operacion, Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para eliminar una operacion de liquidez
     * @param id identificador unico de la operacion de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la operacion de liquidez eliminada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminaOperacion(Long id, String audit) throws ServiceException;

    //Agregar java doc
    Object getAllTypesOperations() throws ServiceException;
}
