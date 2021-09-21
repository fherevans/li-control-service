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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.GruposOperacion;
import mx.santander.liquidez.control.parametria.model.GruposOperacionesRequest;
import mx.santander.liquidez.control.parametria.service.IGruposOperacionesService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-service
* <br><b>Class:</b> GruposOperacionesController.java
* <br><b>Description:</b> Clase Controller para administrar las peticiones de los 
* grupos de operaciones de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 13 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 13 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RefreshScope
@RestController
@RequestMapping("/grupos_operaciones")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class GruposOperacionesController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GruposOperacionesController.class);
    
    /**
     * Variable iGruposOperacionesService de tipo IGruposOperacionesService
     */
    @Autowired
    private IGruposOperacionesService iGruposOperacionesService;
    
    /**
     * Metodo para consultar los grupos de operaciones de liqudiez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de grupos de operacion encotrados en liquidez
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerGruposOper(HttpServletRequest request){
        try {
            //CONSULTA GRUPOS OPERACIONES
            return UtilRestClient.crearResponseEntity(iGruposOperacionesService.consultaTodos(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);            
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Metodo para consultar los grupos de operaciones de liqudiez por paginacion
     * @param request objeto con los datos de la consulta a realizar
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de grupos de operacion encotrados en liquidez
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerGruposOperPag(@RequestBody GruposOperacionesRequest request, HttpServletRequest requestHttp){
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA GRUPOS OPERACIONES PAGINADA
            response = ResponseEntity.status(HttpStatus.OK).body(iGruposOperacionesService.consultaTodosFiltros(request, StringUtil.obtenerHeadersAudit(requestHttp)));    
        } catch (ServiceException e) {            
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error("ERROR AL LLAMAR CONSULTA GRUPOS OPERACIONES EN EL SERVICIO DE PARAMETRIA \n");
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para dar de alta un nuevo grupo de operaciones en liquidez
     * @param grupo datos del grupo a dar de alta en liqudiez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto de grupo de operacion dado de alta
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardaGrupoOper(@Valid @RequestBody GruposOperacion grupo, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            //GUARDA UN NUEVO GRUPO DE OPERACIONES
            response = UtilRestClient.crearResponseEntity(iGruposOperacionesService.guardaGrupoOper(grupo, StringUtil.obtenerHeadersAudit(request)), HttpStatus.CREATED);    
        } catch (ServiceException e) {            
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error("ERROR AL LLAMAR CREAR GRUPOS DE OPERACIONES EN EL SERVICIO DE PARAMETRIA \n");
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        }catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO            
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR GRUPOS DE OPERACIONES (PARAMETRIA) ......... \n");
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para actualizar un grupo de operaciones en liquidez
     * @param id identificador del grupo a actualizar
     * @param grupo datos del grupo a actualizar en liqudiez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto de grupo de operacion actualizado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizaGrupoOper(@PathVariable String id, 
            @RequestBody GruposOperacion grupo, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            //ACTUALIZA UN GRUPO DE OPERACIONES
            grupo.setId(Long.parseLong(id));
            response = UtilRestClient.crearResponseEntity(
                    iGruposOperacionesService.actualizarGrupoOper(grupo, Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {        
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA GRUPOS OPERACION EN EL SERVICIO DE PARAMETRIA \n");
            LOGGER.error(error.toString(), e);
        }catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR GRUPO DE OPERACIONES (PARAMETRIA) ......... \n");
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        }
        return response;
    }
    
    /**
     * Metodo para eliminar un grupo de operaciones de liquidiez
     * @param id identificador de la operacion a eliminar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return resultado de la eliminacion del grupo de operaciones
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarGrupoOper(@PathVariable String id, HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA UN GRUPO DE OPERACIONES
            response = UtilRestClient.crearResponseEntity(
                    iGruposOperacionesService.eliminaGripoOper(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {            
            Error error = ErrorUtil.obtenerUsando(e);        
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERROR AL LLAMAR ELIMINAR GRUPO DE OPERACIONES EN EL SERVICIO DE PARAMETRIA \n");
            LOGGER.error(error.toString(), e);        
            //ERROR DE SERVICIO
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO            
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR GRUPO DE OPERACIONES (PARAMETRIA) ......... \n");
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
