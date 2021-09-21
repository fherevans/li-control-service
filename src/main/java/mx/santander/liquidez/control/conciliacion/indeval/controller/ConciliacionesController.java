package mx.santander.liquidez.control.conciliacion.indeval.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import lombok.extern.slf4j.Slf4j;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestProcesoConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.service.IConciliacionesService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SeguimientoIndevalController.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 04 Nov. 2020
 * @since JDK:1.8

 *
 * @category Controller.
 *
 */

@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/conciliaciones")
@Slf4j
public class ConciliacionesController {

    /**
     * Inyeccion de ISeguimientoIndevalService service.
     */
    @Autowired
    private IConciliacionesService iConciliacionesService;

    /**
     * Método para obtener las conciliaciones H2H/INDEVAL VS DALI.
     * 
     * @param request variable de tipo RequestConciliacionesDTO con la información que es requerida para la consulta
     * @return ResponseEntity<Object> con el detalle de las conciliaciones
     * @throws ServiceException the service exception
     */
    @PostMapping(value = "/htoh_dali")
    public ResponseEntity<Object> getConciliacionesH2HDaliPageable(@Valid @RequestBody RequestConciliacionesDTO request) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE LA CONCILIACIÓN
            response = UtilRestClient.crearResponseEntity(iConciliacionesService.getConciliacionesH2HDaliPageable(request),HttpStatus.OK);
        } catch (ServiceException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            log.error("ERROR AL CONSUMIR EL SERVICIO DE CONCILIACION H2H/INDEVAL VS DALI (PARAMETRÍA): {}", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para consultar las operaciones concilidas Opics vs Dali
     * @param request objeto request con los parametros de entrada de la consulta
     * @return {@link ResponseSeguiOpicsDali} objeto response con los datos de las operaciones conciliadas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @PostMapping("opics_dali")
    public ResponseEntity<Object> getDetalleOpicsDali(@Valid @RequestBody RequestConciliacionesDTO request) throws ServiceException {
        log.info("Ingresando a SeguimientoOpicsDaliController.consultaConciliadas() .........");
        ResponseEntity<Object> response = null;
        try {
            //consulta operaciones conciliadas
            response = UtilRestClient.crearResponseEntity(iConciliacionesService.conciliacionOpicsDali(request), HttpStatus.OK);
        } catch (ServiceException e) {
            //error al consultar operaciones conciliadas
            Error error = ErrorUtil.obtenerUsando(e);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
            log.error("ERROR AL CONSULTAR EL DETALLE DE LAS OPERACIONES DE Opics/Dali: {}", e);
        }
        //retorna lista de operaciones o bandera del proceso
        return response;
    }
    
    /**
     * Método para consultar las operaciones 
     * conciliadas para regresar la informacion
     * al front para que la procese en archivo excel
     * 
     * @param requestConciListaDTO objeto request con los parametros de entrada de la consulta
     * @return ResponseEntity<Object> objeto response con los datos de las operaciones conciliadas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @PostMapping("/listas")
    public ResponseEntity<Object> consultaConciliaciones(@Valid @RequestBody RequestConciListaDTO requestConciListaDTO) 
            throws ServiceException {
        log.info("Ingresando a ConciliacionesController.consultaConciliacion() .........");
        ResponseEntity<Object> response = null;
        try {
            /*Busca operaciones conciliadas*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.consultaConciliaciones(requestConciListaDTO));
        } catch (ServiceException e) {
            //error al consultar las operaciones conciliadas
            Error error = ErrorUtil.obtenerUsando(e);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
            log.error("Error al consultar el detalle de las operaciones de Opics/Dali: {}", e);
        }
        return response;
    }
    
    /**
     * Consulta conciliaciones.
     * Metodo que expone una endPoint para la consulta
     * inicial de las operaciones a conciliar manualmente
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return ResponseEntity<Object> objeto response con los datos de la consultas iniciales de conciliacion manual
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/consultas_manuales")
    public ResponseEntity<Object> consultaConciliaciones(@Valid @RequestBody RequestConsultaConciDTO requestConsultaConciDTO) 
            throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            /*Busca operaciones programas y reales*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.consultaConciliacionesManuales(requestConsultaConciDTO));

    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL CONSULTAR OPERACIONES CONCILIACION MANUAL {}", e);
    }
        return response;
    }
    
    
    /**
     * Consulta conciliaciones.
     * Metodo que expone una endPoint para la consulta
     * inicial de las operaciones a conciliar manualmente
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return ResponseEntity<Object> objeto response con los datos de la consultas iniciales de conciliacion manual
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/consultas_manuales/listas")
    public ResponseEntity<Object> conciliacionesManualesListas(@Valid @RequestBody RequestConsultaConciDTO requestConsultaConciDTO) 
            throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            /*Busca operaciones programas y reales*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.conciliacionesManualesListas(requestConsultaConciDTO));

    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL CONSULTAR OPERACIONES CONCILIACION MANUAL {}", e);
    }
        return response;
    }
    
    /**
     * Activa proceso.
     * Metodo que realiza la activacion del proceso de
     * conciliacion manual, de los sistemas siac y dali
     * @param requestProcesoConciDTO bean que contiene la informacion para activar el proceso de conciliacion
     * @return ResponseEntity<Object> objeto response con los datos de la consultas iniciales de conciliacion manual
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/procesos")
    public ResponseEntity<Object> activaProceso(@Valid @RequestBody RequestProcesoConciDTO requestProcesoConciDTO) 
            throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            /*Busca operaciones programas y reales*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.activaProceso(requestProcesoConciDTO));

    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL ACTIVAR PROCESO DE CONCILIACION MANUAL {}", e);
    }
        return response;
    }
    
    /**
     * Totales conciliaciones manuales.
     * Metodo que expone una endPoint para la consulta
     * de los totales de las conciliaciones manuales por sistema
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return ResponseEntity<Object> objeto response con los datos de la consulta de totales de conciliacion manual
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/consultas_manuales/totales")
    public ResponseEntity<Object> totalesConciliacionesManuales(@Valid @RequestBody RequestConsultaConciDTO requestConsultaConciDTO) 
            throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            
            /*Busca totales de las conci manual*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.obtenerTotalesGeneralesConciManual(requestConsultaConciDTO));

    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL CONSULTAR LOS TOTALES DE LA CONCILIAIONES MANUALES {}", e);
    }
        return response;
    }
    
    /**
     * Totales conciliaciones.
     * Metodo que expone el endPoint para la consulta
     * de los totales de las conciliaciones con paginacion
     * @param requestConciliacionesDTO bean que los filtros de la consulta de totales
     * @return ResponseEntity<Object> objeto response con los datos de la consulta de totales de conciliaciones
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/totales")
    public ResponseEntity<Object> totalesConciliacionesPaginacion(@Valid @RequestBody RequestConciliacionesDTO requestConciliacionesDTO) 
            throws ServiceException {
        log.info("Ingresando a ConciliacionesController.totalesConciliacionesPaginacion() .........");
        ResponseEntity<Object> response = null;
        try {
            /*Busca totales conciliaciones*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.totalesConciliacionesPaginacion(requestConciliacionesDTO));
    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL CONSULTAR LOS TOTALES CON PAGINACION DE LA CONCILIACIONES {}", e);
    }
        return response;
    }
    
    /**
     * Totales conciliaciones.
     * Metodo que expone el endPoint para la consulta
     * de los totales de las conciliaciones
     * @param requestConciliacionesDTO bean que los filtros de la consulta de totales
     * @return ResponseEntity<Object> objeto response con los datos de la consulta de totales de conciliaciones
     * @throws ServiceException exception que ocurre en la capa de negocio
     */
    @PostMapping("/totales/listas")
    public ResponseEntity<Object> totalesConciliaciones(@Valid @RequestBody RequestConciliacionesDTO requestConciliacionesDTO) 
            throws ServiceException {
        log.info("Ingresando a ConciliacionesController.totalesConciliaciones() .........");
        ResponseEntity<Object> response = null;
        try {
            /*Busca totales conciliaciones*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iConciliacionesService.totalesConciliaciones(requestConciliacionesDTO));
    } catch (ServiceException e) {
        /*ERROR*/
        Error error = ErrorUtil.obtenerUsando(e);
        response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        log.error("ERROR AL CONSULTAR LOS TOTALES DE LA CONCILIACIONES {}", e);
    }
        return response;
    }
}
