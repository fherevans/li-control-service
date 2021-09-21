package mx.santander.liquidez.control.conciliacion.indeval.service;

import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestProcesoConciDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-conciliacion-indeval-service <br>
 * <b>Class:</b> IConciliacionesService.java <br>
 * <b>Description:</b> interfaz para obtener las conciliaciones de seguimiento de indeval.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 15 Feb. 2021
 * @since JDK1.8
 *
 * @category Service
 *
 */

public interface IConciliacionesService {

    /**
     * Método de exposición  consultar las operaciones conciliadas de H2H/Indeval vs Dali
     * 
     * @param request variable de tipo getConciliacionesH2HDaliPageable
     * @return Object (CustomPageImpl<ConciliacionesDTO>) objeto pageable con las operaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object getConciliacionesH2HDaliPageable(RequestConciliacionesDTO request) throws ServiceException;
    
    /**
     * Metodo de exposición para consultar las operaciones conciliadas Opics vs Dali
     * @param request objeto con filtros de la consulta de operaciones
     * @return Object (CustomPageImpl<ConciliacionesDTO>) objeto pageable con las operaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object conciliacionOpicsDali(RequestConciliacionesDTO request) throws ServiceException;
    
    /**
     * Consulta conciliaciones.
     * Metodo que se encargara de realiza
     * el proceso de obtener la informacion
     * de las conciliaciones
     * @param requestConciListaDTO bean que contiene la informacion para realizar la consulta
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object consultaConciliaciones(RequestConciListaDTO requestConciListaDTO) throws ServiceException;

    /**
     * Consulta conciliaciones manuales.
     * Metodo que realiza la consulta inicial de las conciliaciones
     * manuales, para SIAC, DALI tanto programadas como reales
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object consultaConciliacionesManuales(RequestConsultaConciDTO requestConsultaConciDTO) throws ServiceException;
    
    /**
     * Conciliaciones manuales listas.
     * Metodo que realiza la consulta inicial de las conciliaciones
     * manuales, para SIAC, DALI tanto programadas como reales para
     * la generacion del excel
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object conciliacionesManualesListas(RequestConsultaConciDTO requestConsultaConciDTO) throws ServiceException;

    /**
     * Activa proceso.
     * Metodo que realiza activacion de proceso
     * de conciliacion manual de las operaciones
     * por sistema
     * @param requestProcesoConciDTO bean que contiene la informacion de la activacion del proceso
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object activaProceso(RequestProcesoConciDTO requestProcesoConciDTO) throws ServiceException;

    /**
     * Obtener totales generales conci manual.
     * Metodo que realiza la consulta
     * de los totales
     * para las conciliaciones manuales
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa el total del programado o real del sistema
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object obtenerTotalesGeneralesConciManual(RequestConsultaConciDTO requestConsultaConciDTO) throws ServiceException;

    /**
     * Totales conciliaciones paginacion.
     * Metodo que realiza la consulta
     * de los totales de las conciliaciones con paginacion
     * @param requestConciliacionesDTO bean que contiene la informacion de la consulta de totales
     * @return regresa un bean con la informacion de totales de las conciliaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object totalesConciliacionesPaginacion(RequestConciliacionesDTO requestConciliacionesDTO) throws ServiceException;

    /**
     * Totales conciliaciones.
     * Metodo que realiza la consulta
     * de los totales de las conciliaciones
     * @param requestConciliacionesDTO bean que contiene la informacion de la consulta de totales
     * @return regresa un bean con la informacion de totales de las conciliaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    Object totalesConciliaciones(RequestConciliacionesDTO requestConciliacionesDTO) throws ServiceException;
}
