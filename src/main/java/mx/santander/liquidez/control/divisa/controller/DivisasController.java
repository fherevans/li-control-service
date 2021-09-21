package mx.santander.liquidez.control.divisa.controller;

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

import mx.santander.liquidez.control.divisa.service.IDivisasService;
import mx.santander.liquidez.control.parametria.dto.model.DivisasPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.Divisas;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-divisas-service
* <br><b>Class:</b> DivisasController.java
* <br><b>Description:</b> Clase Controller para administrar las peticiones de tipo de cambio.
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
* @category Controller
*
*/
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/divisas")
public class DivisasController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DivisasController.class);
    

    /**
     * Variable iDivisasService de tipo IDivisasService
     */
    @Autowired
    private IDivisasService iDivisasService;
    
    /**
     * Metodo para consultar los tipos de cambio disponibles en liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista del objeto TipoCambioDTO con los datos de los tipos de cambio
     */
    @RequestMapping(value = "/listas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultaDivisas(HttpServletRequest request){
        LOGGER.info("Consulta Divisas de cambio de liquidez  ......... ");
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA DIVISAS CON DETALLE
            response = UtilRestClient.crearResponseEntity(iDivisasService.consultaDivisas(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL CONSULTAR LAS DIVISAS EN BD DE LIQUIDEZ \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);            
        }
        return response;
    } 
    
    /**
     * Metodo para consultar los tipos de cambio disponibles en liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista del objeto TipoCambioDTO con los datos de los tipos de cambio
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultaDivisasOper(HttpServletRequest request){
        LOGGER.info("Consulta Divisas de cambio de liquidez  ......... ");
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA DIVISAS
            response = UtilRestClient.crearResponseEntity(iDivisasService.consultaDivisasOperativas(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL CONSULTAR LAS DIVISAS EN BD DE LIQUIDEZ \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    } 
    
    /**
     * API para crear una nueva divisa
     * @param divisa datos de divisa request
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la Divisa creada.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearDivisa(@RequestBody Divisas divisa, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            //CREA DIVISAS
            response = UtilRestClient.crearResponseEntity(iDivisasService.guardaDivisa(divisa, StringUtil.obtenerHeadersAudit(request)), HttpStatus.CREATED);
            
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CREAR DIVISA EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR DIVISA (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para actualizar una divisa.
     * @param id identificador unico de la divisa
     * @param divisa datos de divisa request.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Response entity con la divisa actualizada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarDivisa(@PathVariable String id, @RequestBody Divisas divisa, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ACTUALIZA DIVISAS
            divisa.setIdDivPk(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(iDivisasService.actualizaDivisa(divisa, Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA DIVISAS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR DIVISA (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para obtener la divisas paginadas con filtros
     * @param filtros datos con los filtros para la consulta.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la List de divisas.
     */
    @RequestMapping(value = "/listados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerDivisas(@RequestBody DivisasPaginadaRequest filtros, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA DIVISAS PAGINACION
            response = ResponseEntity.status(HttpStatus.OK).body(iDivisasService.consultaTodosFiltros(filtros, StringUtil.obtenerHeadersAudit(request)));
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA DIVISAS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para eliminar una divisa.
     * @param id llave compuesta para eliminar la divisa.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Response entity con la divisa borrada.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarDivisa(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA DIVISAS
            response = UtilRestClient.crearResponseEntity(iDivisasService.eliminaDivisa(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR DIVISA EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR DIVISA (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
