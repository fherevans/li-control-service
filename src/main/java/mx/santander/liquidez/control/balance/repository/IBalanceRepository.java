/**
 * 
 */
package mx.santander.liquidez.control.balance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IBalanceRepository.java
 * <br><b>Description:</b>
 * Define el comportamiento de una interfaz de repositorio para balance
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 1.0 July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Repository Interface
 * 
 * @see CrudRepository
 *
 */
public interface IBalanceRepository extends CrudRepository<BalanceDTO, Long> {
        
    /**
     * Obtiene todos los balances existentes en cache de Redis.
     * @return un lista de balances de tipo {@link BalanceDTO}
     */
    List<BalanceDTO> findAll();
    
    /**
     * Obtiene todos los balances existentes en cache de Redis por
     * fecha de liquidacion.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @return un lista de balances de tipo {@link BalanceDTO}
     */
    List<BalanceDTO> findAllByFechaLiquidacion(@Param("fechaLiquidacion")
            String fechaLiquidacion);
    
    /**
     * Obtiene todos los balances existentes en cache de Redis con 
     * order by ascendente.
     * @return un lista de balances de tipo {@link BalanceDTO}
     */
    List<BalanceDTO> findAllByOrderByFechaLiquidacionAsc();

}
