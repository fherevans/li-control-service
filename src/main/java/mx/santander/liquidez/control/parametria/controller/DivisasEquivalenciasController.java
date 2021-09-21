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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.DivisaEquivalencia;
import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaDivDTO;
import mx.santander.liquidez.control.parametria.service.IDivisaEquivalenciaService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> DivisaEquivalenciaController.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category controller.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/equivalencias_divisas")
public class DivisasEquivalenciasController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DivisasEquivalenciasController.class);

    /**
     * inyeccion de service.
     */
    @Autowired
    private IDivisaEquivalenciaService service;

    /**
     * Metodo para crear una divisa equivalencia.
     * @param request datos de la entidad de divisa creada
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con la entidad de divisa creada
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearDivisaEquivalencia(@RequestBody DivisaEquivalencia request, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            //CREA EQUIVALENCIA DIVISA
            response = UtilRestClient.crearResponseEntity(service.crearDivisaEquivalencia(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA EQUIVALENCIAS DIVISAS EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR EQUIVALENCIA DIVISA (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }

    /**
     * Metodo para actualizar una divisa equivalencia.
     * @param request datos de la divisa a actualizar 
     * @param id identificador unico de la divisa
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con la entidad de divisa actualizada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarDivisaEquivalencia(@RequestBody DivisaEquivalencia request, 
            @PathVariable(value = "id") String id, HttpServletRequest requestHttp) {
        Error error = null;
        ResponseEntity<Object> response = null;
        try {
            //ACTUALIZA EQUIVALENCIA DIVISA
            request.setIdEquiv(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(service.actualizarDivisaEquivalencia(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZAR DIVISAS EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR EQUIVALENCIA DIVISA (PARAMETRIA) ......... \n", e);
            error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Metodo para obtener divisa equivalencias por filtro.
     * @param filtros datos de la consulta de divisas
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la consulta paginada
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerDivisasEquivalenciasPaginacion(
            @RequestBody FiltroEquivalenciaDivDTO filtros, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA EQUIVALENCIA DIVISAS PAGINADA
            response = ResponseEntity.status(HttpStatus.OK).body(service.obtenerTodasDivisasEquivalencias(filtros, StringUtil.obtenerHeadersAudit(request)));    
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL LLAMAR CONSULTA DIVISAS EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return response;
    }

    /**
     * Metodo para eliminar una divisa equivalencia en liquidez
     * @param id identificador unico para eliminar divisa equivalencia.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> objeto con datos de la equivalencia eliminada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> eliminarDivisaEquivalencia(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA EQUIVALENCIA DIVISA
            response = UtilRestClient.crearResponseEntity(service.eliminarDivisaEquivalencia(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR DIVISAS EQUIVALENCIAS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR EQUIVALENCIA DIVISA (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para obtener todas las equivalencias de las divisas de liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Lista del objeto DivisaEquivalencia con datos de las divisas de equivalencia
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTodas(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA EQUIVALENCIA DIVISAS
            response = UtilRestClient.crearResponseEntity(service.consultaDivisas(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL LLAMAR CONSULTA DIVISAS EQUIV EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
