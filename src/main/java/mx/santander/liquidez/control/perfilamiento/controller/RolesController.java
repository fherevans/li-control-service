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

import mx.santander.liquidez.control.perfilamiento.model.Rol;
import mx.santander.liquidez.control.perfilamiento.request.model.RolRequest;
import mx.santander.liquidez.control.perfilamiento.service.IRolService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> RolController.java <br>
 * <b>Description:</b> API para realizar CRUD de rol.
 *
 * @author Eduardo Castillo Mendoza
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
@RestController
@RequestMapping("/perfilamientos/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class RolesController {
    

    /**
     * Logger para clase de roles.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);

    /**
     * Inyeccion de objecto service.
     */
    @Autowired
    private IRolService service;

    /**
     * Crea un nuevo Rol.
     * 
     * @param rolRequest con los valores para crear un nuevo rol.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<Object> createRol(@RequestBody RolRequest rolRequest) {
        Rol rol = new Rol();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(rolRequest, rol);
        
        try {        
           Rol rolC = service.createRol(rol);
           response = UtilRestClient.crearResponseEntity(rolC, HttpStatus.CREATED);
        }catch(ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al crear un rol", e);
        }
        
        return response;
    }

    /**
     * Obtiene todos los roles y se puede filtrar por nombre.
     * 
     * @param nombre atributo que se utiliza como opcion de busqueda.
     * @param pagina atributo que se utiliza como opcion de busqueda.
     * @return List de roles encontrados.
     */
    @GetMapping
    public ResponseEntity<List<Rol>> getAll(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String pagina) {
        List<Rol> allRol = service.getAllRol(nombre, pagina);
        return new ResponseEntity<List<Rol>>(allRol, HttpStatus.OK);
    }

    /**
     * Actualiza un rol.
     * 
     * @param rolRequest con los valores nuevos para actualizar.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<Object> updateRol(@RequestBody RolRequest rolRequest) {
        Rol rol = new Rol();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(rolRequest, rol);
        Rol rolR;
        try {
            rolR = service.updateRol(rol);
            response = UtilRestClient.crearResponseEntity(rolR, HttpStatus.OK);
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al actualizar un rol", e);
        }
        return response;
    }

    /**
     * Elimina un rol.
     *
     * @param idRol de rol a eliminar.
     * @param idUsuario the id usuario
     * @return responseEntity con mensaje y codigo de respuesta
     */
    @DeleteMapping(value = "/{idRol}/{idUsuario}")
    public ResponseEntity<Object> deleteRol(@PathVariable(value = "idRol") Long idRol,
                                          @PathVariable(value = "idUsuario") String idUsuario) {
        
        ResponseEntity<Object> response = null;

        try {            
            service.deleteRol(idRol, idUsuario);            
            response = UtilRestClient.crearResponseEntity(idRol, HttpStatus.OK);
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al eliminar un rol", e);
        }catch(HttpStatusCodeException e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("Ha ocurrido un error al eliminar un rol", e);
        }
        
        return response;
    }

    /**
     * Se obtiene rol por id.
     * 
     * @param idRol id rol para obtener Rol.
     * @return Rol obtenido por id rol.
     */
    @GetMapping(value = "/{idRol}")
    public Rol getRolbyId(@PathVariable(value = "idRol") Long idRol) {
        return service.findByIdRol(idRol);
    }
    

}
