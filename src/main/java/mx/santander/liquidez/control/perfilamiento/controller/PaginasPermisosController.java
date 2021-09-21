package mx.santander.liquidez.control.perfilamiento.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.perfilamiento.model.PaginaPermiso;
import mx.santander.liquidez.control.perfilamiento.model.PaginaPermisoPK;
import mx.santander.liquidez.control.perfilamiento.request.model.PaginaPermisoIdRequest;
import mx.santander.liquidez.control.perfilamiento.request.model.PaginaPermisoRequest;
import mx.santander.liquidez.control.perfilamiento.service.IPaginaPermisoService;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PagePermController.java <br>
 * <b>Description:</b> API para realizar CRUD de permisos a paginas.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Incluir si la clase es un Modelo, Service, etc.
 * 
 */
@RestController
@RequestMapping("/perfilamientos/paginas_permisos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PaginasPermisosController {

    /**
     * Inyeccion de objeto service
     */
    @Autowired
    private IPaginaPermisoService service;

    /**
     * Crea de un nuevo permiso para una pagina.
     * 
     * @param pagePermRequest con valores para crear un permiso nuevo a una pagina.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<PaginaPermiso> createPagePerm(@RequestBody PaginaPermisoRequest pagePermRequest) {
        PaginaPermiso pagePerm = new PaginaPermiso();
        BeanUtils.copyProperties(pagePermRequest, pagePerm);
        service.createPagePerm(pagePerm);
        return new ResponseEntity<PaginaPermiso>(pagePerm, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los permisos asignados a las paginas.
     * 
     * @return list de permisos asignados a paginas.
     */
    @GetMapping
    public ResponseEntity<List<PaginaPermiso>> getAll() {
        ResponseEntity<List<PaginaPermiso>> response = null;
        List<PaginaPermiso> allPagePerm = service.getAllPagePerm();
        response = ResponseEntity.status(HttpStatus.OK).body(allPagePerm);
        return response;
    }

    /**
     * Actualiza un permiso asignado a una pagina.
     * 
     * @param pagePermRequest con valores para actualizar un permiso a una pagina.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<PaginaPermiso> updatePagePerm(@RequestBody PaginaPermisoRequest pagePermRequest) {
        PaginaPermiso pagePerm = new PaginaPermiso();
        BeanUtils.copyProperties(pagePermRequest, pagePerm);
        service.updatePagePerm(pagePerm);
        return new ResponseEntity<PaginaPermiso>(pagePerm, HttpStatus.OK);
    }

    /**
     * Elimina un permiso asignado a una pagina.
     * 
     * @param pagePermIdRequest llave unica para eliminar un permiso asignado a una
     *                          pagina.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping
    public ResponseEntity<PaginaPermisoPK> deletePagePerm(@RequestBody PaginaPermisoIdRequest pagePermIdRequest) {
        PaginaPermisoPK pagePermId = new PaginaPermisoPK();
        BeanUtils.copyProperties(pagePermIdRequest, pagePermId);
        service.deletePagePerm(pagePermId);
        return new ResponseEntity<PaginaPermisoPK>(pagePermId, HttpStatus.OK);
    }

    /**
     * Busca permisos asignados a una pagina por el id del permiso.
     * 
     * @param idPerm id permiso a buscar paginas.
     * @return idPerm id de permiso para buscar paginas.
     */
    @GetMapping(value = "/permisos/{idPerm}")
    public ResponseEntity<List<PaginaPermiso>> findByIdPerm(@PathVariable(value = "idPerm") Long idPerm) {
        ResponseEntity<List<PaginaPermiso>> response = null;
        List<PaginaPermiso> permisos = service.findByIdPerm(idPerm);
        response = ResponseEntity.status(HttpStatus.OK).body(permisos);
        return response;
    }

    /**
     * Busca permisos asignados a una pagina por el id de la pagina.
     * 
     * @param idPage id pagina a buscar en paginas.
     * @return List de permisos asignados a una pagina.
     */
    @GetMapping(value = "/paginas/{idPage}")
    public ResponseEntity<List<PaginaPermiso>> findByIdPage(@PathVariable(value = "idPage") Long idPage) {
        ResponseEntity<List<PaginaPermiso>> response = null;
        List<PaginaPermiso> permisos = service.findByIdPage(idPage);
        response = ResponseEntity.status(HttpStatus.OK).body(permisos);
        return response;
    }

}
