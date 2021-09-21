/**
 * 
 */
package mx.santander.liquidez.control.balance.socket.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Repository;

import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> BalanceSocketRepository.java
 * <br><b>Description:</b>
 * Implementa la interfaz para un repositorio de socket para balance.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 9 ene 2020
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 9 ene 2020 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Repository
 *
 */
@Repository
@RefreshScope
public class BalanceSocketRepository implements IBalanceSocketRepository {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BalanceSocketRepository.class);
    
    /**
     * Ruta de destino para enviar balances a los subscriptores del web socket.
     */
    @Value("${control.websocket.subscribe.destination.balance}")
    private String wsDestinationBalance;
    
    /**
     * Un template para mensajeria SIMP.
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Constructor por defecto.
     */
    public BalanceSocketRepository() {
        super();
    }

    /**
     * Envia informacion de balances a los subscriptores
     * de un web socket usando mensajeria SIMP.
     * @param fechaLiquidacion es la fecha de liquidacion de los balances
     * @param balances es la informacion de los balances a enviar
     * @throws DataAccessException si un error ocurre durante el proceso
     */
    @Override
    public void enviar(String fechaLiquidacion, List<BalanceDTO> balances)
            throws DataAccessException {
        try {
            /* Convert and send. */
            simpMessagingTemplate.convertAndSend(StringUtil
                    .concat(wsDestinationBalance, fechaLiquidacion), balances);
            
            LOGGER.info("Balances enviados via web socket");
            
        } catch (MessagingException e) {
            /* Envia error. */
            throw new DataAccessException(CodigoError.CLIENTE_SOCKET,
                    wsDestinationBalance, e);
        }
    }

}
