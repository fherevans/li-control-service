package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.parametria.model.RequestSegIndeval;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalDetalleDTO;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalOperPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPronostico;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ISeguimientoIndevalService.java <br>
 * <b>Description:</b> API para seguimiento.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 04 Nov. 2020
 * @since JDK:1.8
 *
 * @category Service.
 *
 */
public interface ISeguimientoIndevalService {

    /**
     * Metodo para obtener el detalle de seguimiento de H2HIndeval.
     * 
     * @return regresa el objeto con los datos obtenidos en la consulta paginada
     * @param requestSegIndeval variable de tipo RequestSegIndeval para obtener el detalle
     * @throws ServiceException error en ejecucion en la consulta del seguimiento indeval
     */
    Object getDetailH2HIndeval(RequestSegIndeval requestSegIndeval) throws ServiceException;

    /**
     * Gets the detail H 2 H indeval pageable.
     *
     * Metodo que realiza el proceso de consultar las operaciones
     * de H2H Indeval de acuerdo a una serie de condiciones para mostrar 
     * en la pantalla online de Seguimiento Indeval
     * @param requestSegIndevalPageable variable de tipo RequestSegIndevalPageable que contiene la informacion con los que se realizara la consulta 
     * @return regresa el objecto con los datos obtenidos en la consulta paginada
     * @throws ServiceException error en ejecucion en la consulta paginada
     */
    Object getDetailH2HIndevalPageable(RequestSegIndevalPageable requestSegIndevalPageable) throws ServiceException;

    /**
     * Gets the detail oper H 2 H indeval pageable.
     * Metodo que realiza la consulta de las operaciones
     * de indeval para obtener el detalle de dichas operaciones
     * @param requestSegIndevalOperPageable variable de tipo RequestSegIndevalOperPageable que contiene la informacion con los que se realizara la consulta 
     * @return regresa el objecto con los datos obtenidos en la consulta paginada
     * @throws ServiceException the service exception
     */
    Object getDetailOperH2HIndevalPageable(RequestSegIndevalOperPageable requestSegIndevalOperPageable) throws ServiceException;

    /**
     * Método para obtener el detalle de las operaciones de H2H/Indeval.
     * para regresar toda la informacion al front, para la generacion del
     * excel con toda la info
     * @param requestSegIndevalDetalle variable DTO tipo requestSegIndevalDetalle
     * @return regresa una lista que regresa con toda la info del detalle de las operaciones de indeval
     * @throws ServiceException excepción tratar las excepciones que se creen en el servicio
     */
    Object obtenerDetalleH2HIndeval(RequestSegIndevalDetalleDTO requestSegIndevalDetalle) throws ServiceException;
    
    /**
     * Metodo para obtener los totales de seguimiento de H2HIndeval.
     * 
     * @return regresa el objeto con los datos obtenidos en la consulta
     * @param  requestSegIndevalOperPageable variable de tipo RequestSegIndevalOperPageable para obtener el detalle
     * @throws ServiceException error en ejecucion en la consulta del seguimiento indeval
     */
    Object getTotalDetailOperH2HIndeval(RequestSegIndevalOperPageable requestSegIndevalOperPageable) throws ServiceException;

    /**
     * Metodo Método para obtener el flujo estimado T+1 de seguimiento H2H/Indeval.
     * 
     * @return regresa el objeto con los datos obtenidos en la consulta
     * @param  requestPronostico variable de tipo RequestSegIndevalPronostico para obtener el detalle de flujo estimado
     * @throws ServiceException error en ejecucion en la consulta del seguimiento indeval
     */
    Object getEstimatedFlowH2HIndeval(RequestSegIndevalPronostico requestPronostico) throws ServiceException;

}
