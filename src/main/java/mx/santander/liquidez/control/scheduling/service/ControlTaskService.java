/**
 * 
 */
package mx.santander.liquidez.control.scheduling.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.santander.liquidez.control.balance.service.IBalanceService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ControlTaskService.java
 * <br><b>Description:</b>
 * Implementacion del servicio de tareas de control.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 4 nov 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 nov 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service
 *
 */
@Service
public class ControlTaskService implements IControlTaskService {
    
    /**
     * Es la instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ControlTaskService.class);
    
    /**
     * Instancia de servicio para balance.
     */
    @Autowired
    private IBalanceService balanceService;

    /**
     * Constructor por defecto.
     */
    public ControlTaskService() {
        super();
    }

    /**
     * Envia informacion de control al tiempo definido mediante una delay.
     * Si un error ocurre durante el proceso, no se envia excepcion, solo
     * se informa en log.
     */
    @Override
    @Scheduled(fixedDelay = 500)
    public void enviarInformacion() {
        try {
            /* Envia. */
            Date fechaHora = new Date();
            balanceService.enviarTodos();
            
            LOGGER.info(StringUtil.concat("Balances enviados: ", fechaHora));
            
        } catch (ServiceException e) {
            /* Solo informa. */
            LOGGER.warn("No se pudo enviar informacion de balances", e);
        }
    }

}
