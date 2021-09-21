package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.Institucion;
import mx.santander.liquidez.control.parametria.request.model.InstitucionRequest;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> IInstitucionRepository.java
* <br><b>Description:</b> Interface para acceder a los metodos de negocio de instituciones
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 19 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 19 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IInstitucionService {
    
    /**
     * Metodo para consultar todas las instituciones de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaInstituciones(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar todas las instituciones de liquidez por filtros
     * @param filtros objeto que contiene los filtros a utilizar en consulta paginada
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<Institucion> consultaInstitucionesPag(InstitucionRequest filtros, String audit) throws ServiceException;
    
    /**
     * Metodo para crear una nueva institucion de liquidez
     * @param institucion datos de la institucion a crear en liqudiez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la institucion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object guardarInstitucion(Institucion institucion, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar una institucion de liquidez
     * @param institucion datos de la institucion a actualizar en liqudie
     * @param id identificador unico de la institucion
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return entidad de la institucion de liquidez creada
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizaInstitucion(Institucion institucion, Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para eliminar una institucion de liquidez
     * @param id identificador unico de la institucion de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto de la institucion eliminada en liquidez
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminaInstitucion(Long id, String audit) throws ServiceException;
    
}
