package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.GruposOperacion;
import mx.santander.liquidez.control.parametria.model.GruposOperacionesRequest;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> IGruposOperacionesService.java
* <br><b>Description:</b> Interface Service para exponer los metodos de negocio 
* de los grupos de operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IGruposOperacionesService {
    
    /**
     * Metodo para consultar todos los grupos de operaciones de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link GruposOperacion} con los datos de las operaciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaTodos(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar todos los grupos de operaciones de liquidez por filtros
     * @param request objeto que contiene los filtros a utilizar en consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link GruposOperacion} con los datos de las operaciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<GruposOperacion> consultaTodosFiltros(GruposOperacionesRequest request, String audit) throws ServiceException;
    
    /**
     * Metodo para crear un nuevo grupo de operaciones de liquidez
     * @param grupo datos del grupo a crear en liqudiez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad del grupo de liquidez creado
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object guardaGrupoOper(GruposOperacion grupo, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar un grupo de operaciones de liquidez
     * @param grupo datos del grupo a actualizar en liqudiez
     * @param id identificador unico del grupo de operacion de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad del grupo de liquidez actualizada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizarGrupoOper(GruposOperacion grupo, Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para eliminar un grupo de operaciones de liquidez
     * @param id identificador unico del grupo de operaciones de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad del grupo de liquidez eliminada de liquidez
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminaGripoOper(Long id, String audit) throws ServiceException;
    
}
