package mx.santander.liquidez.control.divisa.service;

import mx.santander.liquidez.control.parametria.dto.model.DivisasPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.Divisas;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> IDivisasService.java
* <br><b>Description:</b> Interface para acceder a los metodos de negocio de divisas
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 6 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 6 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IDivisasService {
    
    /**
     * Metodo para consultar todas las divisas operativas en liquidez intradia
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista de la entidad de Divisas operativas de liquidez intradia
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object consultaDivisas(String audit) throws ServiceException;

    /**
     * Metodo para consultar todas las divisas operativas en liquidez intradia
     * @return lista de la entidad de Divisas operativas de liquidez intradia
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object consultaDivisasOperativas(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar todas las divisas de liquidez por filtros
     * @param filtros objeto que contiene los filtros a utilizar en consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Divisas} con los datos de las divisas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<Divisas> consultaTodosFiltros(DivisasPaginadaRequest filtros, String audit) throws ServiceException;
    
    /**
     * Metodo para crear un nueva divisa de liquidez
     * @param divisa datos de la divisa a crear en liqudiez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la divisa de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object guardaDivisa(Divisas divisa, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar una divisa de liquidez
     * @param divisa datos de la divisa a actualizar en liqudiez
     * @param id identificador unico de la divisa
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la divisa de liquidez actualizada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizaDivisa(Divisas divisa, Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para eliminar una divisa de liquidez
     * @param id identificador unico de la divisa de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto de la divisa eliminada en liquidez
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminaDivisa(Long id, String audit) throws ServiceException;
}
