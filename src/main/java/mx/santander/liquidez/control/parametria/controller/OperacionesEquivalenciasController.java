package mx.santander.liquidez.control.parametria.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaOperDTO;
import mx.santander.liquidez.control.parametria.model.OperacionEquivalencia;
import mx.santander.liquidez.control.parametria.service.IOperacionEquivalenciaService;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> OperacionEquivalenciaController.java <br>
 * <b>Description:</b> Clase Controller para administrar las peticiones de las 
 * equivalencias de operaciones de liquidez.
 *
 * @author Jose Manuel Gonzalez Quillo
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Controller
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/equivalencias_operaciones")
public class OperacionesEquivalenciasController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesEquivalenciasController.class);
    
    /**
     * Inyeccion de service.
     */
    @Autowired
    private IOperacionEquivalenciaService service;
    
    /**
     * Metodo para obtener todas las equivalencias de las operaciones de liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Lista del objeto OperacionEquivalencia con  datos de operaciones de equivalencia
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTodos(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(service.consultaTodasOper(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA OPERACIONES EQUIV EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR EQUIVALENCIA OPERACIONES (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para crear una nueva operacion equivalencia.
     * @param equivalencia operacion equivalencia request.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la operacion equivalencia.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearOperacionEquiva(@RequestBody OperacionEquivalencia equivalencia, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(service.crearOperacionEquivalencia(equivalencia, StringUtil.obtenerHeadersAudit(request)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA EQUIVALENCIAS OPERACIONES EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR EQUIVALENCIA DE OPERACION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para actualizar valor de operacion equivalencia.
     * @param request operacion equivalencia request.
     * @param id identificador unico operacion equi
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Response entity con la operacion equivalencia actualizado.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarOperacionEquivalencia(@PathVariable String id, 
             @RequestBody OperacionEquivalencia request, HttpServletRequest requestHttp){
        ResponseEntity<Object> response = null;
        try {
            request.setIdEquiv(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(
                    service.actualizarOperacionEquivalencia(request, Long.parseLong(id), StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA OPERACIONES EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR EQUIVALENCIA OPERACION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Metodo para obtener operacion equivalencia paginados.
     * @param filtros datos con los filtros para la consulta.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la lista paginada
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerOperacionesEquiv(@RequestBody FiltroEquivalenciaOperDTO filtros, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(service.obtenerOperacionesEquivalenciasPage(filtros, StringUtil.obtenerHeadersAudit(request)));    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA OPERACIONES EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para eliminar una operacion equivalencia por llave compuesta.
     * @param id llave compuesta para eliminar operacion equivalencia.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la llave de operacion equivalencia a eliminar.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarOperacionEquivalencia(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(service.eliminarOperacionEquivalencia(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR OPERACIONES EQUIVALENCIAS EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR EQUIVALENCIA INSTITUCION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
