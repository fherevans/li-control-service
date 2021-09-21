package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> IParametrosService.java
* <br><b>Description:</b> Interface Service para exponer los metodos de negocio 
* de parametros de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IParametrosService {
    
    /**
     * Metodo para consultar el valor de un parametro de liquidez
     * @param id identificador del parametro a consultar
     * @param audit valor que se necesita para el guardado de pistas auditoras
     * @return valor del parametro
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaParametro(String id, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar el valor de un paramtro de liquidez
     * @param id identificador del parametro a actualizar
     * @param txtValor nuevo valor para asignar al parametro
     * @param audit valor que se necesita para el guardado de pistas auditoras
     * @return objeto con datos del parametro
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizaParametro(String id, String txtValor, String audit) throws ServiceException;
    
    // Agregar java doc
    Object getAllStatusIndeval() throws ServiceException;

    /**
     * Consulta parametro especifico.
     * Metodo que realiza la busqueda de parametros
     * especificos de acuerdo a su id
     * @param id identificador del parametro a actualizar
     * @param audit valor que se necesita para el guardado de pistas auditoras
     * @return objeto con datos del parametro
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaParametroEspecifico(String id, String audit) throws ServiceException;
}
