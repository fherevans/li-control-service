package mx.santander.liquidez.control.balance.service;

import java.util.List;

import mx.santander.liquidez.bitacora.balance.dto.model.BalanceBitacoraDTO;
import mx.santander.liquidez.bitacora.balance.dto.model.BitacoraSistemaDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> IBalanceBitacoraService.java
 * <br><b>Description:</b> Interface que expone los metodos para consultar los 
 * saldos de balance de bitacora.
 *
 * @author FSW Jose Manuel Gonzalez Quillo
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category InterfaceService.
 */
public interface IBalanceBitacoraService {
            
    /**
     * Metodo para consultar balance de bitacora por fecha.
     *
     * @param date fecha a buscar balance
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link BalanceBitacoraDTO} objeto con datos del balance de bitacora
     * @throws ServiceException the service exception
     */        
    List<BitacoraSistemaDTO> consultaByFecha(String date, String audit) throws ServiceException;

}
