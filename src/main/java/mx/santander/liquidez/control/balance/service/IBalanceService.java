/**
 * 
 */
package mx.santander.liquidez.control.balance.service;

import java.util.List;

import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IBalanceService.java
 * <br><b>Description:</b>
 * Define la interfaz para un servicio de balance.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 27 ene 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 27 ene 2020 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 *
 */
public interface IBalanceService {
    
    /**
     * Obtiene los ultimos balances de cache de Redis.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @return una lista de objetos de tipo {@link BalanceDTO}
     * @throws ServiceException si un error ocurre durante el proceso
     */
    List<BalanceDTO> obtenerUltimos(String fechaLiquidacion)
            throws ServiceException;
    
    /**
     * Envia un lista de balances a los subscriptores de un web socket.
     * @param balanceDTOs la lista de {@link BalanceDTO}s a enviar
     */
    void enviar(List<BalanceDTO> balanceDTOs);

    /**
     * Envia el balance a los subscriptores de un web socket.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @param balance es la informacion del balance calculado
     * @throws DataAccessException si un error ocurre durante la consulta 
     */
    void enviar(BalanceDTO balance, String fechaLiquidacion) throws DataAccessException;

    /**
     * Obtiene las fechas en las que existe balance.
     * @return la lista de fechas en formato de string: DD-MM-YYYY
     * @throws ServiceException si un error ocurre durante el proceso
     */
    String[] consultarFechas() throws ServiceException;

    /**
     * Envia los balances en cache de Redis a los subscriptores de un web socket.
     * @throws ServiceException si un error ocurre durante el proceso
     */
    void enviarTodos() throws ServiceException;

}
