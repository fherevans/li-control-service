package mx.santander.liquidez.control.reporte.service;

import mx.santander.liquidez.control.reporte.model.RequestReporteDTO;
import mx.santander.liquidez.control.reporte.model.RequestReporteEspecialesDTO;
import mx.santander.liquidez.control.reporte.model.ResponseReporteDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * 
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> IReporteService.java <br>
 * <b>Description:</b> Bean
 * 
 *
 * @author FSW Praxis Christian Iván Miranda Paulin
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Praxis, Nombre del autor: Christian Iván Miranda
 *          Paulin Creacion de clase IReporteService
 * 
 * @since JDK1.8
 * 
 * @company Praxis
 * @created 5 ago. 2019
 * @category Service Interface
 */
public interface IReporteService {
    
    
    
    /**
     * Genera reporte. Metodo para generar archivo excel
     * 
     * @param requestBalanceDTO the request balance DTO
     * @return {@link ResponseReporteDTO} respuesta reporte
     * @throws ServiceException the service exception
     */
    ResponseReporteDTO generaReporte(RequestReporteDTO requestBalanceDTO) throws ServiceException;

    /**
     * Genera reporte. Método para generar archivo excel con fórmulas
     * 
     * @param req de tipo RequestReporteEspecialesDTO
     * @param id de tipo Long
     * @return ResponseReporteDTO respuesta reporte
     * @throws ServiceException the service exception
     */
    ResponseReporteDTO generaReportePronostico(RequestReporteEspecialesDTO req ,Long id) throws ServiceException;
    
}