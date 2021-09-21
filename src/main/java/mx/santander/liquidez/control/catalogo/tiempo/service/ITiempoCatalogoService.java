/**
 * 
 */
package mx.santander.liquidez.control.catalogo.tiempo.service;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.RequestTiemposEspecDTO;
import mx.santander.liquidez.control.parametria.model.TiempoEspecifico;
import mx.santander.liquidez.control.parametria.model.TiemposEspecRequest;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ITiempoCatalogoService.java
 * <br><b>Description:</b>
 * Es una interfaz de servicio para el catologo de tiempos. 
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 5 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 *
 */
public interface ITiempoCatalogoService {
    
    /**
     * Obtiene el catalogo completo de tiempos especificos de liquidez
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return una lista de {@link TiempoEspecifico} con los datos de tiempos espec
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object obtenerTodos(String audit) throws ServiceException;
    
    /**
     * Obtiene el catalogo completo de tiempos
     * @param request datos de la consulta de tiempos
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un arreglo de {@link TiempoEspecifico}
     * @throws ServiceException excepcion de negocio de liquidez
     */
    CustomPageImpl<TiempoEspecifico> obtenerTodos(TiemposEspecRequest request, String audit) throws ServiceException;
    
    /**
     * Obtiene un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un objeto {@link TiempoEspecifico} si existe
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object obtenerPorId(String id, String audit) throws ServiceException;
    
    /**
     * Crea o salva el tiempo pasado como argumento de llamada.
     * @param tiempo el tiempo a salvar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return un objeto {@link TiempoEspecifico} con su ID generado
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object crear(RequestTiemposEspecDTO tiempo, String audit) throws ServiceException;
    
    /**
     * Actualiza un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param tiempo el tiempo a actualizar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return la referencia al objeto {@link TiempoEspecifico} actualizado
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizar(String id, RequestTiemposEspecDTO tiempo, String audit) throws ServiceException;
    
    /**
     * Elimina el tiempo especificado de liquidez
     * @param id identificador unico de tiempo especifico
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return objeto con datos del tiempo especifico eliminado
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object eliminar(String id, String audit) throws ServiceException;

}
