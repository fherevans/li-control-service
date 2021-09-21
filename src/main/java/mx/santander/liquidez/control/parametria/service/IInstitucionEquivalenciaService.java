package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaInstDTO;
import mx.santander.liquidez.control.parametria.model.InstitucionEquivalencia;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> IInstitucionEquivalenciaService.java <br>
 * <b>Description:</b> Service para crear, actualizar, eliminar y leer
 * institucion equivalencia.
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
public interface IInstitucionEquivalenciaService {
    
    /**
     * Metodo para obtener la lista de todas las instituciones equivalencias.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List de todas las instituciones equivalencias.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object obtenerInstitucionesEquiv(String audit) throws ServiceException;

    /**
     * Metodo para crear una nueva institucion equivalencia.
     * @param institucionEquivalencia {@link InstitucionEquivalencia}
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return institucionEquivalencia creado.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object crearInstitucionEquivalencia(InstitucionEquivalencia institucionEquivalencia, String audit) 
            throws ServiceException;

    /**
     * Metodo para actualizar una institucion equivalencia.
     * @param institucionEquivalencia institucion equivalencia
     * @param id identificador unico de la equivalencia de insti
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return InstitucionEquivalencia actualizada.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizarInstitucionEquivalencia(InstitucionEquivalencia institucionEquivalencia, Long id, String audit) 
            throws ServiceException;

    /**
     * Metodo para obtener todas las instituciones equivalencias y paginar.
     * @param filtro parametros como filtros.
     * @param pageable paginacion.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return List de todas las instituciones equivalencias.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<InstitucionEquivalencia> obtenerTodasInstitucionesEquivalenciaPage(FiltroEquivalenciaInstDTO filtro, String audit) 
            throws ServiceException;

    /**
     * Metodo para eliminar institucion equivalencia
     * @param id identificador unico de la institucion equivalencia
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto con datos de la institucion equivalencia.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminarInstitucionEquivalencia(Long id, String audit) throws ServiceException;

}
