package mx.santander.liquidez.control.parametria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.OperacionesLiq;
import mx.santander.liquidez.control.parametria.model.OperacionesRequest;
import mx.santander.liquidez.control.parametria.service.IOperacionesService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.FieldErrorException;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> OperacionesController.java
* <br><b>Description:</b> Clase Controller para administrar las peticiones de las 
* operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 17 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RefreshScope
@RestController
@RequestMapping("/operaciones")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class OperacionesController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesController.class);
    
    /**
     * Variable iOperacionesService de tipo IOperacionesService
     */
    @Autowired
    private IOperacionesService iOperacionesService;
    
    /**
     * Metodo para consultar las operaciones de liqudiez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de las operaciones encotrados en liquidez
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerOperacionesList(HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            response =  UtilRestClient.crearResponseEntity(iOperacionesService.consultaOperaciones(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);            
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA OPERACIONES (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para consultar las operaciones de liqudiez por paginacion
     * @param request objeto con los datos de la consulta a realizar
     * @param result objeto que contiene el resultado de las validaciones JSR 303
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de las operaciones encotrados en liquidez
     * @throws FieldErrorException excepcion para validaciones JSR 303
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerOperaciones(@Valid @RequestBody OperacionesRequest request,
            BindingResult result, HttpServletRequest requestHttp){
        ResponseEntity<Object> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(iOperacionesService.consultaOperacionesPag(request, StringUtil.obtenerHeadersAudit(requestHttp)));    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA OPERACIONES EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para dar de alta una nueva operacion en liquidez
     * @param operacion datos de la operacion a dar de alta en liqudiez
     * @param result objeto que contiene el resultado de las validaciones JSR 303
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto de la operacion dada de alta
     * @throws FieldErrorException excepcion para validaciones JSR 303
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardaOperacion(@Valid @RequestBody OperacionesLiq operacion, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(iOperacionesService.guardaOperacion(operacion, StringUtil.obtenerHeadersAudit(request)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CREAR OPERACION EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR OPERACION (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para actualizar una operacion en liquidez
     * @param id identificador de la operacion a actualizar
     * @param operacion datos de la operacion a actualizar en liqudiez
     * @param result objeto que contiene el resultado de las validaciones JSR 303
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto de la operacion actualizada
     * @throws FieldErrorException excepcion para validaciones JSR 303
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizaOperacion(@PathVariable String id, 
            @RequestBody OperacionesLiq operacion, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            operacion.setId(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(
                    iOperacionesService.actualizaOperacion(operacion, Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA OPERACIONES EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR OPERACION (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Metodo para eliminar una operacion de liquidiez
     * @param id identificador de la operacion a eliminar
     * @param result objeto que contiene el resultado de las validaciones JSR 303
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return resultado de la eliminacion de la operacion
     * @throws FieldErrorException excepcion para validaciones JSR 303
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarOperacion(@PathVariable String id, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(iOperacionesService.eliminaOperacion(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR OPERACION EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR OPERACION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para consultar operaciones de indeval
     */
    @GetMapping("/operaciones_indeval")
    public ResponseEntity<Object> getAllTypesOperations() {
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(iOperacionesService.getAllTypesOperations(), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTAR OPERACIONES DE INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO CONSULTAR OPERACIONES DE INDEVAL (PARAMETRIA) .........\n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
