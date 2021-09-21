package mx.santander.liquidez.control.parametria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.santander.liquidez.control.parametria.model.DiasInhabiles;
import mx.santander.liquidez.control.parametria.service.IDiasInhabilesService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;



/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> DiasInhabilesController.java
 * <br><b>Description:</b> Clase para acceso a 
 * todos los servicios para la tabla Dias Inhabiles
 *
 * @author  FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0 5 sep 2019 FSW Praxis
 * Nombre del autor: Marcos Magana Hernandez
 * Descripcion breve del cambio
 * @since JDK1.8
 * @company Praxis
 * @created 5 sep 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
@RestController              
@RequestMapping("/dias_inhabiles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class DiasInhabilesController {

    
    /**  Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DiasInhabilesController.class.getName());
    
    /**  Variable iDiasInhabilesService de tipo IDiasInhabilesService. */
    @Autowired
    private IDiasInhabilesService iDiasInhabilesService;
    
    
    /**
     * Metodo para consultar todos los Dias Inhabiles.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<List<DiasInhabiles>> lista con los datos de los Sistemas
     */
    @GetMapping
    public ResponseEntity<List<DiasInhabiles>> consultaDiasInhabiles(HttpServletRequest request) {
        ResponseEntity<List<DiasInhabiles>> response = null;
        List<DiasInhabiles> result = new ArrayList<>();
        HttpStatus estatus = null;    
        try {
            result = iDiasInhabilesService.consultaDiasInhabiles(StringUtil.obtenerHeadersAudit(request));
            if(null != result) {
                estatus = HttpStatus.OK;
                LOGGER.info("La consulta se realizo correctamente - " + estatus);
            }         
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Ha ocurrido un error al consultar el catalogo de Dias Inhabiles", e);
        }
        response = ResponseEntity.status(estatus).body(result);
        return response;
    }
    
        
    /**
     * Metodo para consultar un Dia Inhabil por identificador.
     * @param id identificador del Dia Inhabil
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<DiasInhabiles> objeto con datos de los Dias Inhabiles
     */
    @GetMapping("/{id}")
    public ResponseEntity<DiasInhabiles> consultaDiasInhabilesById(@PathVariable("id") Long id, HttpServletRequest request) {
        ResponseEntity<DiasInhabiles> response = null;
        DiasInhabiles result = new DiasInhabiles();
        HttpStatus estatus = null;    
        try {
            result = iDiasInhabilesService.consultaDiasInhabilesById(id, StringUtil.obtenerHeadersAudit(request));
            if(null == result) {
                estatus = HttpStatus.NOT_FOUND;
                LOGGER.info("No se encontraron datos - " + estatus);
            } else {
                estatus = HttpStatus.OK;
                LOGGER.info("La consulta se realizo correctamente - " + estatus);
            }
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Ha ocurrido un error al consultar el catalogo de Dias Inhabiles", e);
        }
        response = ResponseEntity.status(estatus).body(result);
        return response;
    }
    
        
    /**
     * Metodo para actualizar un Dia Inhabil en liquidez por identificador.
     * @param diasInhabiles the diasInhabiles
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<DiasInhabiles> retorna codigo de operacion correcta o incorrecta
     */
    @PostMapping
    public ResponseEntity<DiasInhabiles> saveDiasInhabiles(@RequestBody DiasInhabiles diasInhabiles, HttpServletRequest request) {
        DiasInhabiles result = new DiasInhabiles();
        HttpStatus estatus = HttpStatus.OK;
        try {
            result = iDiasInhabilesService.saveDiasInhabiles(diasInhabiles, StringUtil.obtenerHeadersAudit(request));
        } catch(ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Ocurrio un error al intentar guardar el Dia Inhabil: {}" , e);
        }
        return new ResponseEntity<DiasInhabiles>(result, estatus);
    }
    
    /**
     * Metodo para actualizar un Dia Inhabil en liquidez por identificador.
     * @param id identificador unico del Sistema
     * @param diasInhabiles the diasInhabiles
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<DiasInhabiles> retorna codigo de operacion correcta o incorrecta
     */
    @PutMapping("/{id}")
    public ResponseEntity<DiasInhabiles> updateDiasInhabiles(@PathVariable("id") Long id, @RequestBody DiasInhabiles diasInhabiles, HttpServletRequest request) {        
        DiasInhabiles result = new DiasInhabiles();
        HttpStatus estatus = HttpStatus.OK;
        try {
            result = iDiasInhabilesService.updateDiasInhabiles(id, diasInhabiles, StringUtil.obtenerHeadersAudit(request));    
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Ocurrio un error al intentar actualizar el Dia Inhabil: {}" , e);
        }
        return new ResponseEntity<DiasInhabiles>(result, estatus);
    }
    
    /**
     * Metodo para borrar un Dia Inhabil en liquidez.
     * @param id identificador unico del Dia Inhabil
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<String> retorna codigo de operacion correcta o incorrecta
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiasInhabiles(@PathVariable("id") Long id, HttpServletRequest request) {        
        String result = "";
        HttpStatus estatus = HttpStatus.OK;
        try {
            result = iDiasInhabilesService.deleteDiasInhabiles(id, StringUtil.obtenerHeadersAudit(request));
        } catch (ServiceException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            result = "500";
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Ocurrio un error al intentar eliminar el Dia Inhabil: " , e);
        }
        return new ResponseEntity<String>(result,estatus);
    }
}
