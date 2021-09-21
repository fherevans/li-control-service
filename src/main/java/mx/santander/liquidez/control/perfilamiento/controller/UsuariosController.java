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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.perfilamiento.model.Usuario;
import mx.santander.liquidez.control.perfilamiento.request.model.UsuarioRequest;
import mx.santander.liquidez.control.perfilamiento.service.IUsuarioService;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> UsuarioController.java <br>
 * <b>Description:</b> API para realizar CRUD de usuarios.
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
@RequestMapping("/perfilamientos/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class UsuariosController {

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IUsuarioService service;

    /**
     * Crea un nuevo usuario.
     * 
     * @param usuarioRequest con atributos necesarios para crear un nuevo usuario.
     * @return responseEntity con mensahe y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        Usuario usuarioR = service.crearUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioR, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los usuarios.
     * 
     * @param nombre filtro opcional.
     * @param apePat filtro opcional.
     * @param apeMat filtro opcional.
     * @param correo filtro opcional.
     * @return list con todos los usuarios.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apePat, @RequestParam(required = false) String apeMat,
            @RequestParam(required = false) String correo) {
        List<Usuario> usuarios = service.getAllUsuarios(nombre, apePat, apeMat, correo);
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    /**
     * obtiene usuario por Id.
     * 
     * @param idUser id de usuario a buscar.
     * @return usuario con id solicitado.
     */
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<Usuario> getUsuarioById(String idUser) {
        ResponseEntity<Usuario> response = null;
        Usuario usuario = service.getUsuarioById(idUser);
        response = ResponseEntity.status(HttpStatus.OK).body(usuario);
        return response;
    }

    /**
     * Actualiza un usuario.
     * 
     * @param usuarioRequest con los atributos necesarios para actualizar.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        Usuario usuarioR = service.updateUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioR, HttpStatus.OK);
    }

    /**
     * Elimina un usuario.
     * 
     * @param idUsuario de usuario que se quiere eliminar.
     * @param idUsuari id de usuario que realiza la operacion.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping(value = "/{idUsuario}/{idUsuari}")
    public ResponseEntity<String> deleteUsuario(@PathVariable(value = "idUsuario") String idUsuario,
                                                @PathVariable(value = "idUsuari") String idUsuari) {
        ResponseEntity<String> response = null;
        service.deleteUsuario(idUsuario, idUsuari);
        response = ResponseEntity.status(HttpStatus.OK).body(idUsuario);
        return response;
    }

}
