/**
 * 
 */
package mx.santander.liquidez.control.balance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.balance.service.IBalanceService;
import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;

/**
 *  * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> BalanceBrokerController.java
 * <br><b>Description:</b>
 * Controlador para el agente de mensajeria de balances. 
 * Recibe solicitudes hacia el web socket.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/balances")
public class BalanceBrokerController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BalanceBrokerController.class);
    
    /**
     * Instancia para el servicio de balance.
     */
    @Autowired
    private IBalanceService balanceService;
    
    /**
     * Recibe solicitudes de subscripcion al web socket.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @return la lista de los ultimos {@link BalanceDTO}s en cache
     * @throws ServiceException si un error ocurre durante el proceso
     */
    @SubscribeMapping("/queue/balances/{fechaLiquidacion}")
    public @Payload List<BalanceDTO> subscribe(
            @DestinationVariable String fechaLiquidacion) 
                    throws ServiceException {
        /* Procesa */
        List<BalanceDTO> balances = balanceService
                .obtenerUltimos(fechaLiquidacion);
        LOGGER.info("Balances devueltos: total={}", balances.size());
        return balances;
    }
    
    /**
     * Recibe informacion del balance calculado para enviarlo a aquellos
     * que estan subscritos al web socket.
     * @param fechaLiquidacion es la fecha de liquidacion del balance
     * @param balance es la informacion del balance calculado
     */
    @MessageMapping("/recibe/balances/{fechaLiquidacion}")
    public void recibe(@DestinationVariable String fechaLiquidacion, 
            @Payload BalanceDTO balance) {
        try {
            balanceService.enviar(balance, fechaLiquidacion);
            LOGGER.info("Balance recibido y enviado");
        } catch (DataAccessException e) {
            LOGGER.error("ERROR, NO SE PUDO ENVIAR EL BALANCE POR SOCKET \n", e);
        }
    }
    
    /**
     * Consulta las fechas en que se tienen balances calculados.
     * @return un objeto de tipo {@link ResponseEntity}
     */
    @GetMapping(value = "/fechas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> consultarFechas() {
        try {
            /* Procesa */
            String[] fechas = balanceService.consultarFechas();
            LOGGER.info("Se obtuvieron fechas de buffer T+n");
            return ResponseEntity.ok(fechas);
        } catch (ServiceException e) {
            /* Error */
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error("ERROR, NO SE PUDO ENVIAR EL BALANCE POR SOCKET \n", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }

}
