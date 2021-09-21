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

import mx.santander.liquidez.control.perfilamiento.model.Usuario;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRol;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRolPK;
import mx.santander.liquidez.control.perfilamiento.request.model.UserRolIdRequest;
import mx.santander.liquidez.control.perfilamiento.request.model.UsuarioRolRequest;
import mx.santander.liquidez.control.perfilamiento.service.IUsuarioRolService;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UserRolController.java <br>
 * <b>Description:</b> API para realizar CRUD de asignaciones de roles a
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
@RequestMapping("/perfilamientos/usuarios_roles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class UsuariosRolesController {

    /**
     * Inyeccion de objeto service.
     */
    @Autowired
    private IUsuarioRolService service;
    

    /**
     * Crea una nueva asignacion de un rol a un usuario.
     * 
     * @param userRolRequest con valores para asignar un rol a un usuario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<UsuarioRol> crearUserRol(@RequestBody UsuarioRolRequest userRolRequest) {
        UsuarioRol userRol = new UsuarioRol();
        BeanUtils.copyProperties(userRolRequest, userRol);
        service.createUserRol(userRol);
        return new ResponseEntity<UsuarioRol>(userRol, HttpStatus.OK);
    }

    /**
     * Obtiene todos los roles asignados a usuarios.
     * 
     * @return list de roles asignado a usuarios.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioRol>> getAll() {
        ResponseEntity<List<UsuarioRol>> response = null;
        List<UsuarioRol> allUsers = service.getAllUserRol();
        response = ResponseEntity.status(HttpStatus.OK).body(allUsers);
        return response;
    }

    /**
     * Obtiene los roles asignados a un usuario por id del usuario.
     * 
     * @param idUser id de usuario de quien se va obtener sus roles.
     * @return list con roles asignados al usuario.
     */
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<List<UsuarioRol>> findByIdUser(@PathVariable(value = "idUser") String idUser) {
        ResponseEntity<List<UsuarioRol>> response = null;
        List<UsuarioRol> roles = service.findByIdUser(idUser);
        response = ResponseEntity.status(HttpStatus.OK).body(roles);
        return response;
    }

    /**
     * Actualiza un rol asignado a un usario.
     * 
     * @param userRolRequest con valores para actualizar un rol asignado a un
     *                       usuario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<UsuarioRol> updateUserRol(@RequestBody UsuarioRolRequest userRolRequest) {
        UsuarioRol userRol = new UsuarioRol();
        BeanUtils.copyProperties(userRolRequest, userRol);
        service.updateUserRol(userRol);
        return new ResponseEntity<UsuarioRol>(userRol, HttpStatus.OK);
    }

    /**
     * Elimina un rol asignado a un usuario.
     * 
     * @param userRolIdRequest con valores de llave para eliminar un rol asignado a
     *                         un usario.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping
    public ResponseEntity<UsuarioRolPK> deleteUserRol(@RequestBody UserRolIdRequest userRolIdRequest) {
        UsuarioRolPK userRolId = new UsuarioRolPK();
        BeanUtils.copyProperties(userRolIdRequest, userRolId);
        service.deleteUserRol(userRolId);
        return new ResponseEntity<UsuarioRolPK>(userRolId, HttpStatus.OK);
    }

    /**
     * Obtiene lista de usuarios asignados a los roles de Kiwi y sistema.
     * 
     * @param idRol para obtener usuario asignado al rol del kiwi.
     * @return List de usuarios asignados.
     */
    @GetMapping("/id_roles/{idRol}")
    public ResponseEntity<List<Usuario>> getUserByIdKiwi(@PathVariable(value = "idRol") Long idRol) {
        ResponseEntity<List<Usuario>> response = null;
        List<Usuario> usuarios = service.getUsersByIdRol(idRol);
        response = ResponseEntity.status(HttpStatus.OK).body(usuarios);
        return response;
    }

}
