/**
 * 
 */
package mx.santander.liquidez.control.semaforo.service;

import java.util.List;

import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceGeneralRedis;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalancesRedis;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ISemaforoService.java
 * <br><b>Description:</b> Reemplazar con una descripcion acorde a la
 * funcionalidad de la clase.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 6 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Descripcion breve del cambio
 * @since JDK1.8
 * @company Praxis
 * @created 6 oct 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
public interface ISemaforoService {
    
    /**
     * Obtiene los ultimos SemaforoBalancesRedis en cache.
     *
     * @param idRol the id rol
     * @param flagDia - bandera del dia actual o dia actual mas N
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return una lista de {@link SemaforoBalancesRedis}s
     */
    List<SemaforoBalancesRedis> obtenerUltimos(Long idRol, String fechaLiquidacion);
    
    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     *
     * @param idRol the id rol
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @param semaforo - objeto semaforo para envio al front
     */
    void enviar(Long idRol, String fechaLiquidacion, SemaforoBalancesRedis semaforo);
    
    /**
     * Calcular.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return the string
     */
    String calcular(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion);
    
    
    /**
     * Obtiene los ultimos SemaforoBalancesRedis en cache.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return una lista de {@link SemaforoBalancesRedis}s
     */
    SemaforoBalanceGeneralRedis obtenerUltimos(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion);
    
    /**
     * Envia un lista de SemaforoBalancesRedis a los subscriptores de un web socket.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @param semaforo - objeto semaforo para envio al front
     */
    void enviar(int idRol, String idUsuario, int idDivisa, String fechaLiquidacion, SemaforoBalanceGeneralRedis semaforo);

}
