package mx.santander.liquidez.control.cambio.service;

import java.util.List;

import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.tipocambio.model.TipoCambioDTO;
import mx.santander.liquidez.tipocambio.model.TipoCambioSocketDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ITipoCambioService.java
* <br><b>Description:</b> Intergace Service para exponer los metodos de negocio 
* del tipo de cambio de liquidez.
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
* @category Interface Service
*
*/
public interface ITipoCambioService {
    
    /**
     * Metodo para enviar un objeto de tipo de cambio a los subscriptores del WebSocket de tipo de cambio.
     * @param cambio objeto {@link TipoCambioDTO} con los datos del tipo de cambio
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    void enviar(List<TipoCambioSocketDTO> cambio) throws ServiceException;

    /**
     * Metodo para consultar los tipos de cambio disponibles para liquidez
     * @return lista del objeto {@link TipoCambioDTO} con los datos de los tipos de cambio
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    TipoCambioSocketDTO[] consultaTiposCambios() throws ServiceException;
    
}
