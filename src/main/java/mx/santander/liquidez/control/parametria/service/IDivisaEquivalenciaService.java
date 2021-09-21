package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.DivisaEquivalencia;
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaDivDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> IDivisaEquivalenciaService.java <br>
 * <b>Description:</b> Service para crear, actualizar, eliminar y leer Divisas
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
public interface IDivisaEquivalenciaService {

    /**
     * Metodo para crear una nueva equivalencia divisa en liquidez.
     * @param divisaEquivalencia atributos {@link DivisaEquivalencia} de la divisa
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia objeto con la entidad creada de divisa.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object crearDivisaEquivalencia(DivisaEquivalencia divisaEquivalencia, String audit) throws ServiceException;

    /**
     * Metodo para obtener todas las equivalencias de divisas paginado.
     * @param filtros fintros para la consulta de equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia lista de divisas de la consulta paginada
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    CustomPageImpl<DivisaEquivalencia> obtenerTodasDivisasEquivalencias(FiltroEquivalenciaDivDTO filtros, String audit)throws ServiceException;

    /**
     * Metodo para eliminar divisa equivalencia.
     * @param id identificador unico de divisa equivalencia.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return equivalencia de divisa eliminada
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    Object eliminarDivisaEquivalencia(Long id, String audit)throws ServiceException;

    /**
     * Metodo para actualizar divisa equivalencia
     * @param divEqu divisa equivalencia para actualizar.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return DivisaEquivalencia entidad de la divisa actualizada.
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    Object actualizarDivisaEquivalencia(DivisaEquivalencia divEqu, String audit)throws ServiceException;
    
    /**
     * Metodo para consultar las equivalencias de divisas de liquidez
     * @return DivisaEquivalencia lista de objeto con datos de las equivalencias de divisas
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaDivisas(String audit) throws ServiceException;

}
