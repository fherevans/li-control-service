package mx.santander.liquidez.control.parametria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.santander.liquidez.control.parametria.model.Sistema;
import mx.santander.liquidez.control.parametria.service.ISistemasService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SistemasController.java
 * <br><b>Description:</b> Clase para acceso a 
 * todos los servicios para la tabla Sistemas
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
@RequestMapping("/sistemas")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class SistemasController {

    /**  Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SistemasController.class.getName());
    
    /**  Variable iSistemasService de tipo ISistemasService. */
    @Autowired
    private ISistemasService iSistemasService;
    
    
    /**
     * Metodo para consultar todos los Sisyemas disponibles en liquidez.
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<List<Sistema>> lista con los datos de los Sistemas
     */
    @GetMapping
    public List<Sistema> consultaSistemas(HttpServletRequest request) {
        List<Sistema> result = new ArrayList<>();
        try {
            result = iSistemasService.consultaSistemas(StringUtil.obtenerHeadersAudit(request));
        } catch (ServiceException e) {
            LOGGER.error("Ha ocurrido un error al consultar el catalogo de Sistema", e);
        }
        return result;
    }
    
        
    /**
     * Metodo para consultar un Sistema por identificador.
     * @param id identificador del tiempo especifico
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Sistema> objeto con datos de los Sistemas
     */
    @GetMapping("/{id}")
    public Sistema consultaSistemasById(@PathVariable("id") Long id, HttpServletRequest request) {
        Sistema result = new Sistema();
        try {
            result = iSistemasService.consultaSistemasById(id, StringUtil.obtenerHeadersAudit(request));        
        } catch (ServiceException e) {
            LOGGER.error("Ha ocurrido un error al consultar el catalogo de Sistema", e);
        }
        return result;
    }
    
        
    /**
     * Metodo para actualizar un Sistema en liquidez por identificador.
     * @param sistema the sistema
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Sistema> retorna codigo de operacion correcta o incorrecta
     */
    @PostMapping
    public Sistema saveSistema(@RequestBody Sistema sistema, HttpServletRequest request) {
        Sistema result = new Sistema();
        try {
            result = iSistemasService.saveSistema(sistema, StringUtil.obtenerHeadersAudit(request));
        } catch(ServiceException e) {
            LOGGER.error("Ocurrio un error al intentar guardar el Sistema: " , e);
        }
        return result;
    }
    
    
    /**
     * Metodo para actualizar un Sistema en liquidez por identificador.
     * @param id identificador unico del Sistema
     * @param sistema the sistema
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Sistema> retorna codigo de operacion correcta o incorrecta
     */
    @PutMapping("/{id}")
    public Sistema updateSistema(@PathVariable("id") Long id, @RequestBody Sistema sistema, HttpServletRequest request) {        
        Sistema result = new Sistema();
        try {
            result = iSistemasService.updateSistema(id, sistema, StringUtil.obtenerHeadersAudit(request));
        } catch (ServiceException e) {
            LOGGER.error("Ocurrio un error al intentar actualizar el Sistema: " , e);
        }
        return result;
    }
    
        
    /**
     * Metodo para borrar un Sistema en liquidez.
     * @param id identificador unico del Sistema
     * @param request interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<Sistema> retorna codigo de operacion correcta o incorrecta
     */
    @DeleteMapping("/{id}")
    public String deleteSistema(@PathVariable("id") Long id, HttpServletRequest request) {
        String result = "";
        try {
            result = iSistemasService.deleteSistema(id, StringUtil.obtenerHeadersAudit(request));
        } catch (ServiceException e) {
            result = "500";
            LOGGER.error("Ocurrio un error al intentar eliminar el Sistema: " , e);
        }
        return result;
    }
}
