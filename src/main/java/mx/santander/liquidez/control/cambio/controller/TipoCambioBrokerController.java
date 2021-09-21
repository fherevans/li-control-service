package mx.santander.liquidez.control.cambio.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.cambio.service.ITipoCambioService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilParseGson;
import mx.santander.liquidez.tipocambio.model.TipoCambioDTO;
import mx.santander.liquidez.tipocambio.model.TipoCambioSocketDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> TipoCambioBrokerController.java
* <br><b>Description:</b> Clase WebSocket para recibir y enviar mensajes a todos 
* los subscriptores del tipo de cambio.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 8 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 8 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category WebSocket
*
*/
@RestController
@RequestMapping(value = "/cambios")
public class TipoCambioBrokerController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioBrokerController.class);
    
    /**
     * Variable iTipoCambioService de tipo ITipoCambioService
     */
    @Autowired
    private ITipoCambioService iTipoCambioService;
    
    /**
     * Metodo que recibe solicitudes de subscripcion al web socket de tipo de cambio.
     * @return la lista de objetos de los ultimos {@link TipoCambioDTO} tipos de cambio.
     */
    @SubscribeMapping(value = "/topic/cambios")
    public @Payload List<TipoCambioSocketDTO> subscribir() {
        LOGGER.info("subscribir -->  /topic/cambios");        
        List<TipoCambioSocketDTO> divisas = new ArrayList<TipoCambioSocketDTO>();
        try {
            TipoCambioSocketDTO [] cambios = iTipoCambioService.consultaTiposCambios();
            for (TipoCambioSocketDTO tipoCambioDTO : cambios) {
                divisas.add(tipoCambioDTO);
            }
            LOGGER.info("divisas: "+UtilParseGson.objectToJson(divisas));
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL OBTENER LOS TIPOS DE CAMBIO ........ \n", e);
        }
        return divisas;
    }
    
    /**
     * Metodo para enviarla a aquellos que estan subscritos al web socket de tipos de cambio.
     * @param cambio un objeto {@link TipoCambioDTO} que contiene el valor del tipo de cambio.
     */
    @MessageMapping("/recibe/cambios")
    public void recibe(@Payload TipoCambioSocketDTO cambio) {
        LOGGER.info("recibe --> TipoCambioSocketDTO: -->  /recibe/cambios");
        try {
            List<TipoCambioSocketDTO> divisas = new ArrayList<TipoCambioSocketDTO>();
            TipoCambioSocketDTO [] cambios = iTipoCambioService.consultaTiposCambios();
            for (TipoCambioSocketDTO tipoCambioDTO : cambios) {
                divisas.add(tipoCambioDTO);
            }
            iTipoCambioService.enviar(divisas);            
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL ENVIAR MENSAJE AL TOPICO DEL WEBSOCKET DE TIPO DE CAMBIO ....... \n", e);
        }        
    }

}
