package mx.santander.liquidez.control.parametria.controller;

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
import mx.santander.liquidez.control.parametria.model.RequestSegIndeval;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalDetalleDTO;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalOperPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPageable;
import mx.santander.liquidez.control.parametria.model.RequestSegIndevalPronostico;
import mx.santander.liquidez.control.parametria.service.ISeguimientoIndevalService;
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
@RequestMapping("/seguimientos_indeval")
@Slf4j
public class SeguimientoIndevalController {

    /**
     * Inyeccion de ISeguimientoIndevalService service.
     */
    @Autowired
    private ISeguimientoIndevalService iSeguimientoIndevalService;

    /**
     * Método para obtener el detalle de seguimiento de indeval
     * @param requestSegIndeval variable de tipo RequestSegIndeval obtener el detalle
     * @return ResponseEntity<Object> con los datos del detalle
     * @throws ServiceException the service exception
     */
    @PostMapping
    public ResponseEntity<Object> getDetailH2HIndeval(@Valid @RequestBody RequestSegIndeval requestSegIndeval) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE DETALLE INDEVAL
            response = UtilRestClient.crearResponseEntity(iSeguimientoIndevalService.getDetailH2HIndeval(requestSegIndeval), HttpStatus.OK);
        } catch (ServiceException | HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para obtener el detalle de seguimiento de indeval por contraparte
     * @param requestSegIndevalPageable variable de tipo RequestSegIndevalPageable para obtener el detalle por contraparte
     * @return ResponseEntity<Object> con los datos del detalle
     * @throws ServiceException the service exception
     */
    @PostMapping(value="/contrapartes")
    public ResponseEntity<Object> getDetailH2HIndevalPageable(@Valid @RequestBody RequestSegIndevalPageable requestSegIndevalPageable) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE DETALLE PAGINADO
            response = UtilRestClient.crearResponseEntity(iSeguimientoIndevalService.getDetailH2HIndevalPageable(requestSegIndevalPageable), HttpStatus.OK);
        } catch (ServiceException | HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para obtener el detalle de seguimiento de indeval paginado
     * @param requestSegIndevalOperPageable variable de tipo RequestSegIndevalOperPageable para obtener el detalle paginado
     * @return ResponseEntity<Object> con los datos del detalle
     * @throws ServiceException the service exception
     */
    @PostMapping(value="/detalles")
    public ResponseEntity<Object> getDetailOperH2HIndevalPageable(@Valid @RequestBody RequestSegIndevalOperPageable requestSegIndevalOperPageable) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE DETALLE DE OPRACIONES
            response = UtilRestClient.crearResponseEntity(iSeguimientoIndevalService.getDetailOperH2HIndevalPageable(requestSegIndevalOperPageable), HttpStatus.OK);
        } catch (ServiceException | HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * servicio que se encargara de obtener el detalle de las operaciones de H2H/Indeval
     * para regresar toda la informacion al front para la generacion
     * de un excel.
     * 
     * @param requestSegIndevalDetalleDTO clase con información que es requerida para que la información se muestre por páginas
     * @return ResponseEntity<Object> con el detalle de las operaciones de H2H/Indeval.
     * @throws ServiceException  Una clase wrapper enfocada a manejar excepciones que se originen en la capa de servicio
     */
    @PostMapping(value = "/detalles_listas")
    public ResponseEntity<Object> detalleIndevalListas(@Valid @RequestBody RequestSegIndevalDetalleDTO requestSegIndevalDetalleDTO) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            /*Ejecutar servicio*/
            response = ResponseEntity.status(HttpStatus.OK).body(
                    iSeguimientoIndevalService.obtenerDetalleH2HIndeval(requestSegIndevalDetalleDTO));
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
            log.error("Error al consultar las listas del detalle de las operaciones de H2H/Indeval : {}", e);
        }
        return response;
    }
    
    /**
     * Método para obtener los totales del detalle de indeval
     * @param requestSegIndevalOperPageable variable de tipo RequestSegIndevalOperPageable para obtener el total de las operaciones
     * @return ResponseEntity<Object> con los datos de los totales
     * @throws ServiceException the service exception
     */
    @PostMapping(value = "/detalles_totales")
    public ResponseEntity<Object> getTotalDetailOperH2HIndeval(@Valid @RequestBody RequestSegIndevalOperPageable requestSegIndevalOperPageable) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE TOTALES
            response = UtilRestClient.crearResponseEntity(iSeguimientoIndevalService.getTotalDetailOperH2HIndeval(requestSegIndevalOperPageable), HttpStatus.OK);
        } catch (ServiceException | HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para obtener el flujo estimado T+1 de seguimiento H2H/Indeval
     * @param requestPronostico variable de tipo RequestSegIndevalPronostico con la información que es requerida para la consulta
     * @return ResponseEntity<Object> con el detalle del flujo estimado de las operaciones de H2H/Indeval
     * @throws ServiceException the service exception
     */
    @PostMapping(value = "/flujos_estimados")
    public ResponseEntity<Object> getEstimatedFlowH2HIndeval(@Valid @RequestBody RequestSegIndevalPronostico requestPronostico) throws ServiceException {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE DETALLE DE FLUJO ESTIMADO
            response = UtilRestClient.crearResponseEntity(iSeguimientoIndevalService.getEstimatedFlowH2HIndeval(requestPronostico), HttpStatus.OK);
        } catch (ServiceException | HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            log.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
