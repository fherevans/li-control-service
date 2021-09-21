/**
 * 
 */
package mx.santander.liquidez.control.semaforo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.semaforo.service.ISemaforoService;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceGeneralRedis;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalancesRedis;
import mx.santander.liquidez.tipocambio.model.TipoCambioDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SemaforoBrokerController.java
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
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/semaforos")
public class SemaforoBrokerController {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SemaforoBrokerController.class);
    
    /**
     * Instancia para el servicio de balance.
     */
    @Autowired
    private ISemaforoService semaforoService;
    
    /**
     * Recibe solicitudes de subscripcion al web socket.
     *
     * @param idRol the id rol
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return la lista de los ultimos {@link SemaforoBalancesRedis}s en cache
     */
    @SubscribeMapping("/queue/semaforos/{idRol}/{fechaLiquidacion}")
    @SendTo("/queue/semaforos/{idRol}/{fechaLiquidacion}")
    public @Payload List<SemaforoBalancesRedis> subscribe(@DestinationVariable Long idRol, @DestinationVariable String fechaLiquidacion) {
        List<SemaforoBalancesRedis> semaforo = semaforoService.obtenerUltimos(idRol, fechaLiquidacion);
        LOGGER.info("semaforo en cache devueltos: {}", semaforo.size());
        return semaforo;
    }
    
    /**
     * Recibe los SemaforoBalancesRedis para enviarlos a los subscriptores correspondientes.
     * @param idRol el Id de rol como criterio de recepcion
     * @param semaforo la lista de {@link SemaforoBalancesRedis} a enviar
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return una lista de {@link SemaforoBalancesRedis}
     */
    @MessageMapping(value = "/recibe/semaforos/{idRol}/{fechaLiquidacion}")
    public void recibir(@DestinationVariable long idRol, @DestinationVariable String fechaLiquidacion,
            @Payload SemaforoBalancesRedis semaforo) {
        semaforoService.enviar(idRol, fechaLiquidacion, semaforo);
        LOGGER.info("semaforo enviadas para rol: {}", idRol);
    }
    
    
    /**
     * Metodo que recibe solicitudes de subscripcion al web socket de tipo de cambio.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return la lista de objetos de los ultimos {@link TipoCambioDTO} tipos de cambio.
     */
    @GetMapping(value = "/generales/{idRol}/{idUsuario}/{idDivisa}/{fechaLiquidacion}")
    public ResponseEntity<String> calcularSolicitud(@PathVariable("idRol") int idRol, @PathVariable("idUsuario") String idUsuario, @PathVariable("idDivisa")int idDivisa, @PathVariable("fechaLiquidacion") String fechaLiquidacion) {
        LOGGER.info("Se hizo una peticion GET para indicar la divisa por la cual se va a calcular los montos para los semaforos");
        ResponseEntity<String> response = null;
        String respuesta = semaforoService.calcular(idRol, idUsuario, idDivisa, fechaLiquidacion);
        response = ResponseEntity.status(HttpStatus.OK).body(respuesta);
        return response;
    }
    
    /**
     * Metodo que recibe solicitudes de subscripcion al web socket de tipo de cambio.
     *
     * @param idRol the id rol
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return la lista de objetos de los ultimos {@link TipoCambioDTO} tipos de cambio.
     */
    @SubscribeMapping(value = "/topic/semaforos/generales/{idRol}/{idUsuario}/{idDivisa}/{fechaLiquidacion}")
              @SendTo(value = "/topic/semaforos/generales/{idRol}/{idUsuario}/{idDivisa}/{fechaLiquidacion}")
    public @Payload SemaforoBalanceGeneralRedis subscribe(@DestinationVariable int idRol, @DestinationVariable String idUsuario, @DestinationVariable int idDivisa, @DestinationVariable String fechaLiquidacion) {
        SemaforoBalanceGeneralRedis semaforos = semaforoService.obtenerUltimos(idRol, idUsuario, idDivisa, fechaLiquidacion);
        LOGGER.info("SemaforoBalanceGeneralRedis en cache devueltos: {}", semaforos);
        return semaforos;
    }
    
    /**
     * Recibe los SemaforoBalancesRedis para enviarlos a los subscriptores correspondientes.
     *
     * @param idRol el Id de rol como criterio de recepcion
     * @param idUsuario the id usuario
     * @param idDivisa the id divisa
     * @param semaforo la lista de {@link SemaforoBalancesRedis} a enviar
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return una lista de {@link SemaforoBalancesRedis}
     */
    @MessageMapping(value = "/recibe/semaforos/generales/{idRol}/{idUsuario}/{idDivisa}/{fechaLiquidacion}")
    public void recibir(@DestinationVariable int idRol, @DestinationVariable String idUsuario, @DestinationVariable int idDivisa,
            @DestinationVariable String fechaLiquidacion, @Payload SemaforoBalanceGeneralRedis semaforo) {
        LOGGER.info("Enviar la informacion del semaforo general al socket");
        semaforoService.enviar(idRol, idUsuario, idDivisa, fechaLiquidacion, semaforo);
        LOGGER.info("SemaforoBalanceGeneralRedis enviadas para rol: {}", idRol);
    }
    
}
