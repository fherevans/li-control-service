package mx.santander.liquidez.control.traductor.service;

import java.util.List;

import mx.santander.liquidez.control.traductor.dto.model.ComboBean;
import mx.santander.liquidez.control.traductor.dto.model.TraductorBean;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.tipocambio.model.TipoCambioSocketDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> ITraductorService.java
 * <br><b>Description:</b> Inetrface service para exponer los metodos de negocio 
 * de traductor
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 18 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category IterfaceService
 */
public interface ITraductorService {

    /**
     * Metodo para consultar los catalogos de tablas disponibles.
     * @return List<{@link ComboBean}> lista con los catalogos de tablas
     * @throws ServiceException the service exception
     */
    List<ComboBean> comboCatTablas() throws ServiceException;
    
    
    /**
     * Metodo para procesar la carga de Archivo Vector de Precios.
     * @param bean the bean
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link List<?>} lista del objeto con los datos de vector de precios
     * @throws ServiceException the service exception
     */
    List<?> procesarTraductor(TraductorBean bean, String audit) throws ServiceException;
    
    
    /**
     *  Metodo para Enviar divisa al WebSocket.
     * @param cambio the cambio
     * @throws ServiceException the service exception
     */
    void enviarDivisa(List<TipoCambioSocketDTO> cambio) throws ServiceException;
    
    
    
}
