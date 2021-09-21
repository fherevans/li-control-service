/**
 * 
 */
package mx.santander.liquidez.control.catalogo.tiempo.controller;

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

import mx.santander.liquidez.control.catalogo.tiempo.service.ITiempoCatalogoService;
import mx.santander.liquidez.control.parametria.model.RequestTiemposEspecDTO;
import mx.santander.liquidez.control.parametria.model.TiempoEspecifico;
import mx.santander.liquidez.control.parametria.model.TiemposEspecRequest;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> TiempoCatalogoController.java
 * <br><b>Description:</b>
 * Controla las solicitudes del servicio de catalogo de tiempos.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 5 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 * @see ITiempoCatalogoService
 *
 */
@RestController
@RequestMapping(value = "/tiempos_especificos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TiempoCatalogoController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoCatalogoController.class);
    
    /**
     * Instancia del servicio de catalogo de tiempos.
     */
    @Autowired
    private ITiempoCatalogoService tiempoCatalogoService;
    
    /**
     * Metodo para consultar los tiempos especificos de liqudiez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de tiempos especificos encotrados en liquidez
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTodos(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA TIEMPOS ESPECIFICOS
            response = UtilRestClient.crearResponseEntity(tiempoCatalogoService.obtenerTodos(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA TIEMPOS ESPECIFICOS (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA TIEMPOS ESPECIFICOS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo que consulta los tiempos especificos de liquidez
     * @param request datos de la consulta a realizar 
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return un arreglo del objeto {@link TiempoEspecifico}
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTodosTiempos(@RequestBody TiemposEspecRequest request, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA TIEMPOS ESPECIFICOS PAGINADO
            response = ResponseEntity.status(HttpStatus.OK).body(tiempoCatalogoService.obtenerTodos(request, StringUtil.obtenerHeadersAudit(requestHttp)));    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA TIEMPOS ESPECIFICOS EN EL SERVICIO DE PARAMETRIA \n", e);
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return response;
    }
    
    /**
     * Metodo que obtiene un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return un objeto {@link TiempoEspecifico}
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerPorId(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA TIEMPO ESPECIFICO POR ID
            response = UtilRestClient.crearResponseEntity(tiempoCatalogoService.obtenerPorId(id, StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA TIEMPO ESPECIFICO (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA ID TIEMPO ESPECIFICO EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        return response;
    }
    
    /**
     * Crea o salva el tiempo pasado como argumento de llamada.
     * @param tiempo el tiempo a salvar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return un objeto {@link TiempoEspecifico} con su ID generado
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearTiempoEsp(@RequestBody RequestTiemposEspecDTO tiempo, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CREA TIEMPO ESPECIFICO
            response = UtilRestClient.crearResponseEntity(tiempoCatalogoService.crear(tiempo, StringUtil.obtenerHeadersAudit(request)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CREAR TIEMPOS ESPECIFICOS EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR TIEMPO ESPECIFICO (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Actualiza un tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param tiempo el tiempo a actualizar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return la referencia al objeto {@link Tiempo} actualizado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@PathVariable(value = "id") String id, 
            @RequestBody RequestTiemposEspecDTO tiempo, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ACTUALIZA TIEMPO ESPECIFICO
            response = UtilRestClient.crearResponseEntity(tiempoCatalogoService.actualizar(id, tiempo, StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR TIEMPO ESPECIFICO (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZAR TIEMPO ESPECIFICO EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Elimina el tiempo especificado por ID.
     * @param id el identificador de tiempo
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto con datos del tiempo especifico eliminado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@PathVariable(value = "id") String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ELIMINAR TIEMPO ESPECIFICO
            response = UtilRestClient.crearResponseEntity(tiempoCatalogoService.eliminar(id, StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINA TIEMPO ESPECIFICO EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR TIEMPO ESPECIFICO (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
