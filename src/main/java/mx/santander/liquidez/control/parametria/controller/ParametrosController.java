package mx.santander.liquidez.control.parametria.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.Parametros;
import mx.santander.liquidez.control.parametria.service.IParametrosService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ParametrosController.java
* <br><b>Description:</b> Clase Controller para administar las peticiones del modulo de parametros.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 nov. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 nov. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RefreshScope
@RestController
@RequestMapping("/parametros")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ParametrosController {

    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ParametrosController.class);
    
    /**
     * Variable iParametrosService de tipo IParametrosService
     */
    @Autowired
    private IParametrosService iParametrosService;
    
    /**
     * Metodo para consultar un parametro de liquidez
     * @param id identificador del parametro a consultar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return valor del parametro consultado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtieneParametro(@PathVariable String id,  HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            // CONSULTA PARAMETRO
            response =  UtilRestClient.crearResponseEntity(iParametrosService.consultaParametro(id, StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);        
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA PARAMETRO (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para actualizar el valor de un parametro de liquidez
     * @param parametro objeto con los datos del parametro a actualizar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return objeto Parametros con valores actualizados
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizaOperacion(@RequestBody Parametros parametro,  HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            // ACTUALIZA PARAMETRO
            response = UtilRestClient.crearResponseEntity(
                            iParametrosService.actualizaParametro(parametro.getId(), parametro.getTxtValor(),  StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA PARAMETRO EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR PARAMETRO (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }
    
    /**
     * Método para consultar estatus de indeval
     * @return ResponseEntity<Object> con los estatus de indeval
     */
    @GetMapping("/estatus_indeval")
    public ResponseEntity<Object> getAllStatusIndeval() {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE TODOS LOS ESTATUS DE INDEVAL
            response = UtilRestClient.crearResponseEntity(iParametrosService.getAllStatusIndeval(), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR LA CONSULTA DE ESTATUS INDEVAL DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA DE ESTATUS INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * Busca parametro.
     * Metodo que se encarga de exponer el
     * servicio para consultar los parametros por
     * id para consultar y regresar la informacion de acuerdo
     * a ese id 
     * @param id identificador del parametro a consultar
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return valor del bean del parametro
     */
    @RequestMapping(value = "/especificos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscaParametro(@PathVariable String id,  HttpServletRequest request){
        ResponseEntity<Object> response = null;
        try {
            /*CONSULTA PARAMETRO*/
            response =  UtilRestClient.crearResponseEntity(iParametrosService.consultaParametroEspecifico(id, StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);        
        } catch (ServiceException e) {
            /*Error*/
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            /*RESPUESTA DE ERROR DEL SERVICIO*/
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA PARAMETRO (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
}
