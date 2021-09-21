/**
 * 
 */
package mx.santander.liquidez.control.semaforo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.santander.liquidez.notificacion.toast.model.SemaforoBalancesRedis;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-notificacion-service
 * <br><b>Class:</b> ISemaforoRedisRepository.java
 * <br><b>Description:</b> Reemplazar con una descripcion acorde a la
 * funcionalidad de la clase.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 4 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Descripcion breve del cambio
 * @since JDK1.8
 * @company Praxis
 * @created 4 oct 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
public interface ISemaforoRedisRepository extends CrudRepository<SemaforoBalancesRedis, Long> {

    /**
     * Obtiene todas las instancias de Semaforos que estan en cache.
     *
     * @param idRol el identificador de rol
     * @param idSistema the id sistema
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - fecha liquidacion 
     * @return una lista de {@link SemaforoBalancesRedis}
     */
    SemaforoBalancesRedis findByIdRolAndIdSistemaAndIdDivisaAndFechaLiquidacion(
            @Param("idRol") Long idRol, @Param("idSistema") Long idSistema,
            @Param("idDivisa") Long idDivisa,
            @Param("fechaLiquidacion") String fechaLiquidacion);
    
    /**
     * Obtiene todas las instancias de Semaforos que estan en cache.
     * @param idRol el identificador de rol
     * @param fechaLiquidacion - fecha liquidacion 
     * @return una lista de {@link SemaforoBalancesRedis}
     */
    List<SemaforoBalancesRedis> findByIdRolAndFechaLiquidacion(@Param("idRol") Long idRol,
            @Param("fechaLiquidacion") String fechaLiquidacion);

}
