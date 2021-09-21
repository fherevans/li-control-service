/**
 * 
 */
package mx.santander.liquidez.control.balance.socket.repository;

import java.util.List;

import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IBalanceSocketRepository.java
 * <br><b>Description:</b>
 * Define la interfaz para un repositorio de socket para balance.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 9 ene 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 9 ene 2020 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Repository Interface
 *
 */
public interface IBalanceSocketRepository {

    /**
     * Envia informacion de balances a los subscriptores
     * de un web socket usando mensajeria SIMP.
     * @param fechaLiquidacion es la fecha de liquidacion de los balances
     * @param balances es la informacion de los balances a enviar
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    void enviar(String fechaLiquidacion, List<BalanceDTO> balances)
            throws DataAccessException;

}
