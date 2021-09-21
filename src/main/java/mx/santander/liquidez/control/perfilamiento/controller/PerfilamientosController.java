package mx.santander.liquidez.control.perfilamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.perfilamiento.response.model.PaginaRolResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.PerfilamientoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.PermisoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.RolResponse;
import mx.santander.liquidez.control.perfilamiento.service.IPaginaRolService;
import mx.santander.liquidez.control.perfilamiento.service.IPerfilamientoService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PerfilamientoController.java <br>
 * <b>Description:</b> API para crear perfilamiento de usuario.
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
@RequestMapping("/perfilamientos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PerfilamientosController {

    /**
     * inyeccion de perfilamiento service.
     */
    @Autowired
    private IPerfilamientoService perfilamientoService;

    /**
     * Inyeccion de pagina rol service.
     */
    @Autowired
    private IPaginaRolService paginaRolService;

    /**
     * API para obtener perfilamiento de usuario por id.
     * 
     * @param idUser id de usuario para obtener perfilamiento.
     * @return responseEntity con todos los datos de perfilamiento.
     */
    @GetMapping("/{idUser}")
    public ResponseEntity<Object> getPerfilamientoUsuarioId(
            @PathVariable(value = "idUser") String idUser) {
        
        ResponseEntity<Object> response = null;
        
        try {
            PerfilamientoResponse perfilamientoResponse = perfilamientoService.getPerfilamientoByUserId(idUser);
            response = UtilRestClient.crearResponseEntity(perfilamientoResponse, HttpStatus.OK);
        }catch(ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
        
        return response;
    }

    /**
     * API para obtener permisos asignados a una pagina.
     * 
     * @param idPage id de pagina a para obtener permisos.
     * @return List de todos los permisos asignados a la pagina.
     */
    @GetMapping("/permisos/paginas/{idPage}")
    public ResponseEntity<List<PermisoResponse>> getPermisosAsignadosPagina(
            @PathVariable(value = "idPage") Long idPage) {
        ResponseEntity<List<PermisoResponse>> response = null;
        List<PermisoResponse> permisosDePagina = perfilamientoService.getPermisosPagina(idPage);
        response = ResponseEntity.status(HttpStatus.OK).body(permisosDePagina);
        return response;
    }

    /**
     * API para obtener paginas asignadas por el rol
     * 
     * @param idRol id rol para obtener paginas asignadas.
     * @return List de de paginas asignadas al rol enviado como parametro.
     */
    @GetMapping("/paginas/roles/{idRol}")
    public ResponseEntity<List<PaginaRolResponse>> getPaginasAsignadasRol(@PathVariable(value = "idRol") Long idRol) {
        ResponseEntity<List<PaginaRolResponse>> response = null;
        List<PaginaRolResponse> paginasAsignadasRol = paginaRolService.getPaginasAsignadasRol(idRol);
        response = ResponseEntity.status(HttpStatus.OK).body(paginasAsignadasRol);
        return response;
    }

    /**
     * API para obtener permisos no asignados a una pagina.
     * 
     * @param idPage id de pagina para obtener sus permisos no asignados.
     * @return List de permisos no asignados a la pagina.
     */
    @GetMapping("/permisos_no_asignados/paginas/{idPage}")
    public ResponseEntity<List<PermisoResponse>> getPermisosNoAsignadosPagina(
            @PathVariable(value = "idPage") Long idPage) {
        ResponseEntity<List<PermisoResponse>> response = null;
        List<PermisoResponse> permisosNoAsignadosPagina = perfilamientoService
                .getNombrePermisosNoAsignadosPagina(idPage);
        response = ResponseEntity.status(HttpStatus.OK).body(permisosNoAsignadosPagina);
        return response;
    }

    /**
     * API para obtener paginas no asignadas a un rol.
     * 
     * @param idRol para obtener paginas no asignadas.
     * @return Lista de paginas no asignadas al idRol.
     */
    @GetMapping("/paginas_no_asignadas/roles/{idRol}")
    public ResponseEntity<List<PaginaRolResponse>> getPaginasNoAsignadasRol(@PathVariable(value = "idRol") Long idRol) {
        ResponseEntity<List<PaginaRolResponse>> response = null;
        List<PaginaRolResponse> paginasNoAsignadasRol = paginaRolService.paginasNoAsignadasRol(idRol);
        response = ResponseEntity.status(HttpStatus.OK).body(paginasNoAsignadasRol);
        return response;
    }

    /**
     * API para obtener los permisos no asignados a un usuarios.
     * 
     * @param idUsuario id de usuario para obtener permisos no asignados al usuario.
     * @return List de permisos no asignados.
     */
    @GetMapping("/permisos_no_asignados/usuarios/{idUsuario}")
    public ResponseEntity<List<PermisoResponse>> getPermisosNoAsignadosUsuario(
            @PathVariable(value = "idUsuario") String idUsuario) {
        ResponseEntity<List<PermisoResponse>> response = null;
        List<PermisoResponse> permisosNoAsignadosUsuario = perfilamientoService.permisosNoAsignadosUsuario(idUsuario);
        response = ResponseEntity.status(HttpStatus.OK).body(permisosNoAsignadosUsuario);
        return response;
    }

    /**
     * API para obtener los roles no asignados al usuario.
     * 
     * @param idUsuario id usuario para obtener roles no asignados.
     * @return List de roles no asignados a un usuario.
     */
    @GetMapping("/roles_no_asignados/usuarios/{idUsuario}")
    public ResponseEntity<List<RolResponse>> getRolesNoAsignadosUsuario(
            @PathVariable(value = "idUsuario") String idUsuario) {
        ResponseEntity<List<RolResponse>> response = null;
        List<RolResponse> rolResponse = perfilamientoService.rolesNoAsignadosUsuario(idUsuario);
        response = ResponseEntity.status(HttpStatus.OK).body(rolResponse);
        return response;
    }

}
