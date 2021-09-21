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

import mx.santander.liquidez.control.parametria.model.FiltroEquivalenciaInstDTO;
import mx.santander.liquidez.control.parametria.model.InstitucionEquivalencia;
import mx.santander.liquidez.control.parametria.service.IInstitucionEquivalenciaService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> InstitucionEquivalenciaController.java <br>
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
@RequestMapping("/equivalencias_instituciones")
public class InstitucionesEquivalenciasController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitucionesEquivalenciasController.class);

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IInstitucionEquivalenciaService service;
    
    /**
     * Metodo para obtener todas las equivalencias de las instituciones de liquidez
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Lista del objeto InstitucionEquivalencia con datos de instituciones de equivalencia
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTodas(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA TODAS LAS EQUIVALENCIAS INSTITUCIONES
            response = UtilRestClient.crearResponseEntity(service.obtenerInstitucionesEquiv(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA INSTITUCIONES EQUIV EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para crear una nueva institucion equivalencia.
     * 
     * @param request Request con parametros necesarios para crear una institucion
     *                equivalencia.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con institucion equivalencia creada.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearInstitucionEquivalencia(
            @RequestBody InstitucionEquivalencia request, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            //CREA EQUIVALENCIA INSTITUCION
            response = UtilRestClient.crearResponseEntity(service.crearInstitucionEquivalencia(request, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.CREATED);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CREAR EQUIVALENCIAS INSTITUCIONES EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR EQUIVALENCIA INSTITUCIONES (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para actualizar institucion equivalencia.
     * @param id identificador unico de la institucion
     * @param request con parametros de actualizacion.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con institucion equivalencia actualizada.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizarInstitucionEquivalencia(@RequestBody InstitucionEquivalencia request, 
            @PathVariable(value = "id") String id, HttpServletRequest requestHttp) {
        ResponseEntity<Object> response = null;
        try {
            request.setIdEquiv(Long.parseLong(id));
            //ACTUALIZA EQUIVALENCIA INSTITUCION
            response = UtilRestClient.crearResponseEntity(
                    service.actualizarInstitucionEquivalencia(request, Long.parseLong(id), StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ACTUALIZA INSTITUCION EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR EQUIVALENCIA INSTITUCION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    /**
     * API para obtener una lista paginada de institucion equivalencia.
     * @param filtros datos de consulta paginada
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la lista paginada.
     */
    @RequestMapping(value = "/listas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerInstitucionEquivalenciaPaginacion(@RequestBody FiltroEquivalenciaInstDTO filtros,
            HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA EQUIVALENCIAS INSTITUCIONES PAGINADA
            response = ResponseEntity.status(HttpStatus.OK).body(service.obtenerTodasInstitucionesEquivalenciaPage(filtros, StringUtil.obtenerHeadersAudit(request)));    
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULTA INSTITUCION EQUIVALENCIA EN EL SERVICIO DE PARAMETRIA \n", e);
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return response;
    }

    /**
     * API para eliminar institucion equivalencia.
     * @param id identificador unico de la institucion
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity con la llave primaria a eliminar.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarInstitucionEquivalencia(@PathVariable String id, HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            //ELIMINA EQUIVALENCIA INSTITUCION
            response = UtilRestClient.crearResponseEntity(
                    service.eliminarInstitucionEquivalencia(Long.parseLong(id), StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR ELIMINAR INSTITUCION EQUIVALENCIAS EN EL SERVICIO DE PARAMETRIA \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR EQUIVALENCIA INSTITUCION (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
