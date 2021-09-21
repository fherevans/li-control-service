
package mx.santander.liquidez.control.parametria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.InstitucionesPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.RequestInstitucionIndeval;
import mx.santander.liquidez.control.parametria.service.IInstitucionesIndevalService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> InstitucionesIndevalController.java <br>
 * <b>Description:</b> Crud genérico para altas, bajas, actualizaciones y consultas de instituciones de indeval
 * de la clase.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 04 Nov. 2020
 * @since JDK1.8    
 *
 * @category controller.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/instituciones_indeval")
public class InstitucionesIndevalController {

    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstitucionesIndevalController.class);
    
    /**
     * Inyección de service.
     */
    @Autowired
    private IInstitucionesIndevalService iInstitucionesIndevalService;

    /**
     * Método que obtiene el catálogo de instituciones de indival
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la lista de instituciones
     */
    @GetMapping
    public ResponseEntity<Object> getAllInstituciones(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE TODAS LAS INSTITUCIONES
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.getAllInstituciones(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL LLAMAR CONSULTA DE INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA DE INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método que obtiene el catálogo de instituciones de indeval por filtro
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la lista de instituciones
     */
    @GetMapping(value = "/filters")
    public ResponseEntity<Object> getInstitucionesFilters(HttpServletRequest request) {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE INSTITUCIONES FILTRADAS
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.getInstitucionesFilters(StringUtil.obtenerHeadersAudit(request)), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL LLAMAR LA CONSULTA DE FILTROS DE INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO LA CONSULTA DE FILTROS DE INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para crear una institución
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval request para crear una institución
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la institución creada
     */
    @PostMapping
    public ResponseEntity<Object> createsInstitutions(HttpServletRequest request, @Valid @RequestBody RequestInstitucionIndeval requestInstitucionIndeval) {
        ResponseEntity<Object> response = null;
        try {
            // CREA UNA INSTITUCIÓN
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.createsInstitutions(StringUtil.obtenerHeadersAudit(request), requestInstitucionIndeval), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL CREAR INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CREAR INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para actualizar una institución
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval para actualizar una institución
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la institución³n actualizada
     */
    @PutMapping
    public ResponseEntity<Object> updatesInstitutions(HttpServletRequest request, @Valid @RequestBody RequestInstitucionIndeval requestInstitucionIndeval) {
        ResponseEntity<Object> response = null;
        try {
            // ACTUALIZA UNA INSTITUCIÓN
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.updatesInstitutions(StringUtil.obtenerHeadersAudit(request), requestInstitucionIndeval), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL ACTUALIZAR LAS INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZAR LAS INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para eliminar una institución
     * @param requestInstitucionIndeval variable de tipo RequestInstitucionIndeval para eliminar una institución
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la respuesta de eliminación exitosa
     */
    @DeleteMapping
    public ResponseEntity<Object> removesInstitution(HttpServletRequest request, @Valid @RequestBody RequestInstitucionIndeval requestInstitucionIndeval) {
        ResponseEntity<Object> response = null;
        try {
            // ELIMINA UNA INSTITUCIÓN
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.removesInstitutions(StringUtil.obtenerHeadersAudit(request), requestInstitucionIndeval), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL ELIMINAR LAS INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ELIMINAR LAS INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Método para consulta de instituciones paginadas
     * @param institucionesPaginadaRequest variable de tipo InstitucionesPaginadaRequest para obtener las instituciones paginadas
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Object> con la lista de instituciones
     */
    @PostMapping(value = "/pageables")
    public ResponseEntity<Object> getInstitutionsPageable(HttpServletRequest request, @Valid @RequestBody InstitucionesPaginadaRequest institucionesPaginadaRequest) {
        ResponseEntity<Object> response = null;
        try {
            // OBTIENE LAS INSTITUCIONES PAGINADAS
            return UtilRestClient.crearResponseEntity(iInstitucionesIndevalService.getInstitutionsPageable(StringUtil.obtenerHeadersAudit(request), institucionesPaginadaRequest), HttpStatus.OK);
        } catch (ServiceException e) {
            // ENVIA ERROR
            LOGGER.error("ERROR AL LLAMAR CONSULTA PAGINADA DE INSTITUCIONES INDEVAL EN EL SERVICIO DE PARAMETRIA \n", e);
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException e) {
            // RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO CONSULTA PAGINADA DE INSTITUCIONES INDEVAL (PARAMETRIA) ......... \n", e);
            Error error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
