package mx.santander.liquidez.control.perfilamiento.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermiso;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoIdRequest;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoPK;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoRequest;
import mx.santander.liquidez.control.perfilamiento.service.IUsuarioPermisoService;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserPermController.java <br>
 * <b>Description:</b> API para realizar CRUD de asignacion de permisos a
 * usuarios.
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
@RequestMapping("/perfilamientos/usuarios_permisos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class UsuariosPermisosController {

    /**
     * Inyeccion de objeto service.
     */
    @Autowired
    private IUsuarioPermisoService service;

    /**
     * Crea de un permiso asignado a un usuario.
     * 
     * @param userPermRequest con valores para crear un nuevo Permiso asignado a un
     *                        usario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<UsuarioPermiso> createUserPermResponse(@RequestBody UsuarioPermisoRequest userPermRequest) {
        UsuarioPermiso userPerm = new UsuarioPermiso();
        BeanUtils.copyProperties(userPermRequest, userPerm);
        service.createUserPerm(userPerm);
        return new ResponseEntity<UsuarioPermiso>(userPerm, HttpStatus.OK);
    }

    /**
     * Obtiene todos los permisos asignados a los usarios.
     * 
     * @return lista con todos los permisos asignados a todos los usuarios.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioPermiso>> getAll() {
        ResponseEntity<List<UsuarioPermiso>> response = null;
        List<UsuarioPermiso> userPerm = service.getAllUserPerm();
        response = ResponseEntity.status(HttpStatus.OK).body(userPerm);
        return response;
    }

    /**
     * Obtiene todos los permisos asignados a un usuario.
     * 
     * @param idUser de quien se desan obtener los permisos.
     * @return list con todos los permisos asignados a un usuario.
     */
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<List<UsuarioPermiso>> getUsuarioPermisoPorIdUsuario(String idUser) {
        ResponseEntity<List<UsuarioPermiso>> response = null;
        List<UsuarioPermiso> permisos = service.getAllUserPermByIdUser(idUser);
        response = ResponseEntity.status(HttpStatus.OK).body(permisos);
        return response;
    }

    /**
     * Actualiza un permiso asignado a un usuario.
     * 
     * @param userPermRequest con valores para actualziar un permiso asignado a un
     *                        usario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<UsuarioPermiso> updatePermResponse(@RequestBody UsuarioPermisoRequest userPermRequest) {
        UsuarioPermiso userPerm = new UsuarioPermiso();
        BeanUtils.copyProperties(userPermRequest, userPerm);
        service.updateUserPerm(userPerm);
        return new ResponseEntity<UsuarioPermiso>(userPerm, HttpStatus.OK);
    }

    /**
     * Elimina un permiso asignado a un usario.
     * 
     * @param userPermIdRequest con valores para eliminar un permiso asignado a un
     *                          usario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping
    public ResponseEntity<UsuarioPermisoPK> deleteUserPerm(@RequestBody UsuarioPermisoIdRequest userPermIdRequest) {
        UsuarioPermisoPK userPerm = new UsuarioPermisoPK();
        BeanUtils.copyProperties(userPermIdRequest, userPerm);
        service.deleteUserPerm(userPerm);
        return new ResponseEntity<UsuarioPermisoPK>(userPerm, HttpStatus.OK);
    }

}