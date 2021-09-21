package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.Cuentas;
import mx.santander.liquidez.control.parametria.model.CuentasFiltrosDTO;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ICuentasService.java <br>
 * <b>Description:</b> Clase Interface Service para exponer los servicios de cuentas de liquidez
 * 
 * @author Manuel Gonzalez Quillo
 * @company Praxis
 * @created 21 nov. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Manuel Gonzalez Quillo
 * Se crea interface service para exponer servicios de cuentas
 * @category Interface Service
 * 
 */
public interface ICuentasService {

    /**
     * Metodo para crear una nueva cuenta en liquidez.
     * @param cuenta atributos {@link Cuentas} de la cuenta
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Cuentas objeto con la entidad creada de cuentas.
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object crearCuenta(Cuentas cuenta, String audit) throws ServiceException;

    /**
     * Metodo para obtener todas las cuentas paginado.
     * @param filtros fintros para la consulta de cuentas.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Cuentas lista de cuentas de la consulta paginada
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    CustomPageImpl<Cuentas> obtenerCuentas(CuentasFiltrosDTO filtros, String audit)throws ServiceException;

    /**
     * Metodo para eliminar una cuenta de liquidez
     * @param id identificador unico de la cuenta
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return la cuenta eliminada
     * @throws ServiceException excepcion de negocio de liquidez.
     */
    Object eliminarCuenta(Long id, String audit)throws ServiceException;

    /**
     * Metodo para actualizar una cuenta de liquidez
     * @param cuenta cuenta para actualizar datos
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Cuentas entidad de la cuenta actualizada.
     *  @throws ServiceException excepcion de negocio de liquidez.
     */
    Object actualizarCuenta(Cuentas cuenta, String audit)throws ServiceException;
    
    /**
     * Metodo para consultar las cuentas de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return Cuentas lista de objeto con datos de las cuentas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaCuentas(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar el tipo de cuentas de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return TipoCuenta lista de objeto con datos de tipos de cuentas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaTipoCuentas(String audit) throws ServiceException;

}
