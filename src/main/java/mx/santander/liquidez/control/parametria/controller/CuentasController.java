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

import mx.santander.liquidez.control.parametria.model.Cuentas;
import mx.santander.liquidez.control.parametria.model.CuentasFiltrosDTO;
import mx.santander.liquidez.control.parametria.service.ICuentasService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> CuentasController.java <br>
 * <b>Description:</b> Clase Controller para administrar las peticiones a control 
 * para obtener cuentas de liquidez
 *
 * @author Manuel Gonzalez Quillo
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Manuel Gonzalez Quillo
 * Creacion de la clase
 *
 * @category Controller.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/cuentas")
public class CuentasController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CuentasController.class);

    /**
     * inyeccion de service.
     */
    @Autowired
    private ICuentasService service;

    /**
     * Metodo para crear una cuenta nueva
     * @param request datos de la entidad de cuenta a crear
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con la entidad de cuenta creada
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearCuenta(@RequestBody Cuentas request, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            //CREA CUENTA
            response = UtilRestClient.crearResponseEntity(service.crearCuenta(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CREAR CUENTA EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR CUENTA (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Metodo para actualizar una cuenta existente
     * @param request datos de la cuenta a actualizar 
     * @param id identificador unico de la cuenta
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con la entidad de cuenta actualizada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarCuenta(@RequestBody Cuentas request, @PathVariable(value = "id") String id
            , HttpServletRequest requestHttp) {
        Error error = null;
        ResponseEntity<Object> response = null;
        try {
            //ACTUALIZA CUENTA
            request.setIdCuenta(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(service.actualizarCuenta(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZAR CUENTA EN EL SERVICIO DE PARAMETRIA \n", e);
            error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR CUENTA (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Metodo para obtener las cuentas por filtro y paginadas.
     * @param filtros datos de la consulta de cuentas
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la consulta de cuentas paginada
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerCuentasPaginacion(@RequestBody CuentasFiltrosDTO filtros, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA CUENTAS PAGINADA
            response = ResponseEntity.status(HttpStatus.OK).body(service.obtenerCuentas(filtros, StringUtil.obtenerHeadersAudit(request)));    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA CUENTAS PAGINADO EN EL SERVICIO DE PARAMETRIA \n", e);
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return response;
    }

    /**
     * Metodo para eliminar una cuenta en liquidez
     * @param id identificador unico para eliminar cuenta
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con datos de la cuenta eliminada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarCuenta(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA CUENTA
            response = UtilRestClient.crearResponseEntity(service.eliminarCuenta(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR CUENTA EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR CUENTA (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }
    
    /**
     * Metodo para obtener todas las cuentas de liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Lista del objeto Cuentas con datos de las cuentas
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerCuentas(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA CUENTAS
            response = UtilRestClient.crearResponseEntity(service.consultaCuentas(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA CUENTAS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para obtener todos los tipos de cuentas de liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Lista del objeto TipoCuentas con datos de los tipos de cuentas
     */
    @RequestMapping(value = "/tipos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTipoCuentas(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA TIPOS DE CUENTAS
            response = UtilRestClient.crearResponseEntity(service.consultaTipoCuentas(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA TIPOS DE CUENTAS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
