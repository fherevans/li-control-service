package mx.santander.liquidez.control.perfilamiento.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.perfilamiento.model.Pagina;
import mx.santander.liquidez.control.perfilamiento.request.model.PaginaRequest;
import mx.santander.liquidez.control.perfilamiento.service.IPaginaService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageController.java <br>
 * <b>Description:</b> API para realizar CRUD de pagina.
 *
 * @author Eduardo Castillo Mendoza
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category controller.
 */
@RestController
@RequestMapping("/perfilamientos/paginas")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PaginasController {
    

    /**
     * Logger para clase de paginas.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PaginasController.class);

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IPaginaService service;

    /**
     * Crea una nueva pagina.
     * 
     * @param pageRequest con los valores para crear una nueva pagina.
     * @return responseEntity con mensajje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<Object> createPage(@RequestBody PaginaRequest pageRequest) {
        Pagina page = new Pagina();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(pageRequest, page);

        try {
            service.crearPage(page);
            response = UtilRestClient.crearResponseEntity(page, HttpStatus.CREATED);
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al crear una pagina", e);
        }

        return response;
    }

    /**
     * Obtiene todas las paginas.
     * 
     * @param nombre  filtro.
     * @param nivPrio filtro.
     * @param permiso filtro.
     * @return list de todas las paginas.
     */
    @GetMapping
    public ResponseEntity<List<Pagina>> getAll(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String nivPrio, @RequestParam(required = false) String permiso) {
        List<Pagina> allPage = service.getAllPages(nombre, nivPrio, permiso);
        return new ResponseEntity<List<Pagina>>(allPage, HttpStatus.OK);
    }

    /**
     * Actualiza una pagina.
     * 
     * @param pageRequest con los valores nuevos para actualizar.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<Object> updatePage(@RequestBody PaginaRequest pageRequest) {
        Pagina page = new Pagina();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(pageRequest, page);
        
        try {
            service.updatePage(page);
            response = UtilRestClient.crearResponseEntity(page, HttpStatus.OK);
        }catch(ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al actualizar una pagina", e);
        }
        
        return response;
    }

    /**
     * Elimina una pagina.
     *
     * @param idPage    de pagina a elimnar.
     * @param idUsuario the id usuario
     * @return responseEntity con mensaje y codigo de respuestas.
     */
    @DeleteMapping(value = "/{idPage}/{idUsuario}")
    public ResponseEntity<Object> deletePage(@PathVariable(value = "idPage") Long idPage,
            @PathVariable(value = "idUsuario") String idUsuario) {
        
        ResponseEntity<Object> response = null;
        
        try {
            service.deletePage(idPage, idUsuario);
            response = UtilRestClient.crearResponseEntity(idPage, HttpStatus.OK);
        }catch(ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al borrar una pagina: {}", e);
        }catch(HttpStatusCodeException e) {
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al borrar una pagina", e);
        }
        
        return response;
    }

    /**
     * Obtiene pagina por Id.
     * 
     * @param idPage de pagina a obtener.
     * 
     * @return responseEntity con pagina y status.
     */
    @GetMapping(value = "/{idPage}")
    public ResponseEntity<Pagina> getPaginaById(@PathVariable(value = "idPage") Long idPage) {
        ResponseEntity<Pagina> response = null;
        Pagina pagina = service.findByIdPagina(idPage);
        response = ResponseEntity.status(HttpStatus.OK).body(pagina);
        return response;
    }

}
