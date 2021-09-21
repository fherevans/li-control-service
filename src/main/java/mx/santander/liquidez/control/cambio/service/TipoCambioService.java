package mx.santander.liquidez.control.cambio.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilParseGson;
import mx.santander.liquidez.tipocambio.model.TipoCambioDTO;
import mx.santander.liquidez.tipocambio.model.TipoCambioSocketDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> TipoCambioService.java
* <br><b>Description:</b> Clase Service de implementacion de los metodos de negocio
* de tipo de cambio dentro de liqudiez intradia.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 9 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 9 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service
*/
@Service
public class TipoCambioService implements ITipoCambioService {
    
    /**
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioService.class);
    
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.cambio}")
    private String wsDestinationCambio;
    
    /**
     * Variable urlConsDivisas de tipo String
     */
    @Value("${control.endpoint.divisas.cambio}")
    private String urlConsDivisas;
    
    /**
     * Instancia de REST template.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Un template para mensajeria SIMP.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Metodo para consultar los tipos de cambio disponibles para liquidez
     * @return lista del objeto {@link TipoCambioSocketDTO} con los datos de los tipos de cambio
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public TipoCambioSocketDTO[] consultaTiposCambios() throws ServiceException {
        LOGGER.info("urlConsDivisas :: {}", urlConsDivisas);
        ResponseEntity<TipoCambioSocketDTO[]> response = restTemplate.getForEntity(urlConsDivisas,TipoCambioSocketDTO[].class);
        LOGGER.info("consultaTiposCambios: "+UtilParseGson.objectToJson(response));
        LOGGER.info("Obtencion de tipos de cambio con codigo: {}", response.getStatusCodeValue());
        return response.getBody();
    }
    
    /**
     * Metodo para enviar un objeto de tipo de cambio a los subscriptores del WebSocket de tipo de cambio.
     * @param cambio objeto {@link TipoCambioDTO} con los datos del tipo de cambio
     * @throws ServiceException expcepcion de negocio de liquidez
     */
    @Override
    public void enviar(List<TipoCambioSocketDTO> cambio) throws ServiceException{
        LOGGER.info("enviar: "+UtilParseGson.objectToJson(cambio));
        List<TipoCambioSocketDTO> tiposCambio = new ArrayList<TipoCambioSocketDTO>(cambio);
        simpMessagingTemplate.convertAndSend(wsDestinationCambio, tiposCambio);
    }

}
