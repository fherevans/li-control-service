package mx.santander.liquidez.control.parametria.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.santander.liquidez.control.parametria.model.RequestSegIndeval;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalDetalleDTO;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalOperPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPronostico;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SeguimientoIndevalService.java <br>
 * <b>Description:</b> cliente con parametria.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 04 Nov. 2020
 * @since JDK:1.8
 *
 * @category Service.
 *
 */
@Slf4j
@Service
public class SeguimientoIndevalService implements ISeguimientoIndevalService {

    /**
     * Uri para seguimiento.
     */
    @Value("${control.endpoint.segIndeval}")
    private String uriSeguimientoIndeval;
    
    /**
     * Método para obtener el detalle de seguimiento de H2HIndeval.
     * 
     * @return regresa el objecto con los datos obtenidos en la consulta paginada
     * @throws ServiceException error en ejecucion en la consulta del seguimiento indeval
     */
    @Override
    public Object getDetailH2HIndeval(RequestSegIndeval requestSegIndeval) throws ServiceException {
        return UtilRestClient.executeServiceRest(requestSegIndeval, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval, HttpMethod.POST);
    }
    
    /**
     * Gets the detail H 2 H indeval pageable.
     *
     * Método que realiza el proceso de consultar las operaciones
     * de H2H Indeval de acuerdo a una serie de condiciones para mostrar 
     * en la pantalla online de Seguimiento Indeval
     * @param requestSegIndevalPageable bean que contiene la informacion con los que se realizara la consulta 
     * @return regresa el objecto con los datos obtenidos en la consulta paginada
     * @throws ServiceException error en ejecucion en la consulta paginada
     */
    @Override
    public Object getDetailH2HIndevalPageable(RequestSegIndevalPageable requestSegIndevalPageable)
            throws ServiceException {
        return UtilRestClient.executeServiceRest(requestSegIndevalPageable, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval + "/contrapartes", HttpMethod.POST);
    }
    
    /**
     * Gets the detail oper H 2 H indeval pageable.
     * Método que realiza la consulta de las operaciones
     * de indeval para obtener el detalle de dichas operaciones
     * @param requestSegIndevalPageable bean que contiene la informacion con los que se realizara la consulta 
     * @return regresa el objecto con los datos obtenidos en la consulta paginada
     * @throws ServiceException the service exception
     */
    @Override
    public Object getDetailOperH2HIndevalPageable(RequestSegIndevalOperPageable requestSegIndevalOperPageable)
            throws ServiceException {
        return UtilRestClient.executeServiceRest(requestSegIndevalOperPageable, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval + "/detalles", HttpMethod.POST);
    }

    /**
     * Gets the detail totales oper H 2 H indeval.
     * Método que realiza la consulta de las operaciones
     * de indeval para obtener el detalle de totales
     * @param  requestSegIndevalOperPageable variable de tipo RequestSegIndevalOperPageable que contiene los foltros de búsqueda
     * @return regresa el objecto con los datos obtenidos en la consulta
     * @throws ServiceException the service exception
     */
    @Override
    public Object getTotalDetailOperH2HIndeval(RequestSegIndevalOperPageable requestSegIndevalOperPageable) throws ServiceException {
        return UtilRestClient.executeServiceRest(requestSegIndevalOperPageable, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval + "/detalles_totales", HttpMethod.POST);
    }
    
    /**
     * Gets the flujo estimado T+1 de seguimiento H2H/Indeval.
     * Método que realiza la consulta de las operaciones
     * de indeval para obtener el detalle de totales
     * @param  requestPronostico variable de tipo RequestSegIndevalPronostico que contiene los foltros de búsqueda
     * @return regresa el objecto con los datos obtenidos en la consulta
     * @throws ServiceException the service exception
     */
    @Override
    public Object getEstimatedFlowH2HIndeval(RequestSegIndevalPronostico requestPronostico) throws ServiceException {
        return UtilRestClient.executeServiceRest(requestPronostico, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval + "/flujos_estimados", HttpMethod.POST);
    }

    /**
     * Método para obtener el detalle de las operaciones de H2H/Indeval.
     * para regresar toda la informacion al front, para la generacion del
     * excel con toda la info
     * @param requestSegIndevalDetalle variable DTO tipo requestSegIndevalDetalle
     * @return regresa una lista que regresa con toda la info del detalle de las operaciones de indeval
     * @throws ServiceException excepción tratar las excepciones que se creen en el servicio
     */
    @Override
    public Object obtenerDetalleH2HIndeval(RequestSegIndevalDetalleDTO requestSegIndevalDetalle)
            throws ServiceException {
        log.info("Inicia llamado de servicio de obtener la listas de detalle");
        return UtilRestClient.executeServiceRest(requestSegIndevalDetalle, StringUtil.obtenerEncabezados(null), uriSeguimientoIndeval + "/detalles_listas", HttpMethod.POST);
    }
    
}
