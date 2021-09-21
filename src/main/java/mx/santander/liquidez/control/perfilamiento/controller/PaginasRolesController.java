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

import mx.santander.liquidez.control.perfilamiento.model.PaginaRol;
import mx.santander.liquidez.control.perfilamiento.model.PaginaRolPK;
import mx.santander.liquidez.control.perfilamiento.request.model.PaginaRolIdRequest;
import mx.santander.liquidez.control.perfilamiento.request.model.PaginaRolRequest;
import mx.santander.liquidez.control.perfilamiento.service.IPaginaRolService;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageRolController.java <br>
 * <b>Description:</b> API para realizar CRUD de asignaciones de roles a
 * paginas.
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
@RequestMapping("/perfilamientos/paginas_roles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PaginasRolesController {

    /**
     * Inyeccion de objeto service.
     */
    @Autowired
    private IPaginaRolService service;

    /**
     * Crea de un rol nuevo para una pagina.
     * 
     * @param pageRolRequest con valores para asignar un rol a una pagina.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<PaginaRol> createPageRol(@RequestBody PaginaRolRequest pageRolRequest) {
        PaginaRol pageRol = new PaginaRol();
        BeanUtils.copyProperties(pageRolRequest, pageRol);
        service.createPageRol(pageRol);
        return new ResponseEntity<PaginaRol>(pageRol, HttpStatus.CREATED);
    }

    /**
     * obtine todos los roles asignados a una pagina.
     * 
     * @return List de roles asignados a una pagina.
     */
    @GetMapping
    public ResponseEntity<List<PaginaRol>> getAll() {
        ResponseEntity<List<PaginaRol>> response = null;
        List<PaginaRol> allPageRol = service.getAllPageRol();
        response = ResponseEntity.status(HttpStatus.OK).body(allPageRol);
        return response;
    }

    /**
     * Actualizar el rol a una pagina.
     * 
     * @param pageRolRequest con valores para actualziar pageRol.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<PaginaRol> updatePageRol(@RequestBody PaginaRolRequest pageRolRequest) {
        PaginaRol pageRol = new PaginaRol();
        BeanUtils.copyProperties(pageRolRequest, pageRol);
        service.updatePageRol(pageRol);
        return new ResponseEntity<PaginaRol>(pageRol, HttpStatus.OK);
    }

    /**
     * Elimina un rol nuevo para una pagina.
     * 
     * @param pageRolRequest llave para eliminar un rol asignado a una pagina.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping
    public ResponseEntity<PaginaRolPK> deletePageRol(@RequestBody PaginaRolIdRequest pageRolRequest) {
        PaginaRolPK pageRolId = new PaginaRolPK();
        BeanUtils.copyProperties(pageRolRequest, pageRolId);
        service.deletePageRol(pageRolId);
        return new ResponseEntity<PaginaRolPK>(pageRolId, HttpStatus.OK);
    }

    /**
     * Obtiene las paginas asignadas a un rol por idRol.
     * 
     * @param idRol de paginas a buscar.
     * @return List de paginas asignadas a un rol.
     */
    @GetMapping(value = "/idRol/{idRol}")
    public List<PaginaRol> getPaginaRolByIdRol(@PathVariable(value = "idRol") Long idRol) {
        return service.findByIdRol(idRol);
    }

    /**
     * Obtiene las paginas asignadas a un rol por IdPagina.
     * 
     * @param idPage de paginas a buscar.
     * @return List de paginas asignadas a un rol.
     */
    @GetMapping(value = "/idPagina/{idPage}")
    public List<PaginaRol> getPaginaRolByIdPage(@PathVariable(value = "idPage") Long idPage) {
        return service.findByIdPage(idPage);
    }

}
