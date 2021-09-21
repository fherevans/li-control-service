
package mx.santander.liquidez.control.parametria.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import mx.santander.liquidez.control.parametria.model.Institucion;
import mx.santander.liquidez.control.parametria.request.model.InstitucionRequest;
import mx.santander.liquidez.control.parametria.service.IInstitucionService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-s-service <br>
 * <b>Class:</b> InstitucionController.java <br>
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
@RequestMapping("/instituciones")
public class InstitucionesController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitucionesController.class);

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IInstitucionService service;

    /**
     * API para crear una nueva institucion .
     * 
     * @param request Request con parametros necesarios para crear una institucion
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con institucion  creada.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearInstitucion(@RequestBody Institucion request, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            //SE CREA INSTITUCION
            response = UtilRestClient.crearResponseEntity(service.guardarInstitucion(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.CREATED);
        } catch (ServiceException e) {
            //ERROR AL LLAMAR SERVICIO
            LOGGER.error("ERROR AL LLAMAR CREAR INSTITUCIONES EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR INSTITUCION (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para actualizar institucion.
     * @param id identificador unico de la institucion
     * @param request con parametros de actualizacion.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con institucion  actualizada.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarInstitucion(@RequestBody Institucion request, 
            @PathVariable(value = "id") String id, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            request.setIdInst(Long.parseLong(id));
            //SE ACTUALIZA INSTITUCION
            response = UtilRestClient.crearResponseEntity(service.actualizaInstitucion(request, Long.parseLong(id), StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);    
        } catch (ServiceException e) {
            //ERROR AL LLAMAR SERVICIO
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA INSTITUCION EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR INSTITUCION (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        }
        return response;
    }

    /**
     * API para obtener una lista paginada de institucion .
     * @param filtros datos de la consulta paginada
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la lista paginada.
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerInstitucionPaginacion(@RequestBody InstitucionRequest filtros, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA INSTITUCIONES PAGINADO
            response = ResponseEntity.status(HttpStatus.OK).body(service.consultaInstitucionesPag(filtros, StringUtil.obtenerHeadersAudit(request)));    
        } catch (ServiceException e) {
            //ERROR AL LLAMAR SERVICIO            
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERROR AL LLAMAR CONSULTA INSTITUCION EN EL SERVICIO DE PARAMETRIA \n", e);
        }
        return response;
    }

    /**
     * API para eliminar institucion .
     * @param id identificador unico de la institucion
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la llave primaria a eliminar.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarInstitucion(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //SE ELIMINA INSTITUCION
            response = UtilRestClient.crearResponseEntity(service.eliminaInstitucion(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR INSTITUCION (PARAMETRIA) ......... \n");
            Error error = ErrorUtil.responseBodyToError(e);
            LOGGER.error(error.toString(), e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ServiceException e) {
            //ERROR AL LLAMAR SERVICIO
            LOGGER.error("ERROR AL LLAMAR ELIMINAR INSTITUCION EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        }
        return response;
    }
    
    /**
     * Obtiene el catalogo completo de instituciones.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return un arreglo de {@link Institucion}
     */
    @GetMapping
    public ResponseEntity<Object> obtenerTodos(HttpServletRequest request) {
        try {
            //SE CONSULTA INSTITUCIONES
            return UtilRestClient.crearResponseEntity(service.consultaInstituciones(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);            
        } catch (ServiceException e) {
            //ERROR AL LLAMAR SERVICIO
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.error(error.toString(), e);
            return UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
