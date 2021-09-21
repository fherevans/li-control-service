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

import mx.santander.liquidez.control.perfilamiento.model.Permiso;
import mx.santander.liquidez.control.perfilamiento.request.model.PermisoRequest;
import mx.santander.liquidez.control.perfilamiento.service.IPermisoService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PermisosController.java <br>
 * <b>Description:</b> Permiso controller.
 *
 * @author Eduardo Castillo Mendoza
 * @version Control de cambios:
 * @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * @since JDK1.8
 * @company Praxis
 * @created 2 sep. 2019
 * @category controller.
 */
@RestController
@RequestMapping("/perfilamientos/permisos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PermisosController {

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IPermisoService service;

    /**
     * Crea un nuevo permiso.
     * 
     * @param permisoRequest con valores necesarios para crear un nuevo permiso.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PostMapping
    public ResponseEntity<Object> createPermiso(@RequestBody PermisoRequest permisoRequest) {
        Permiso permiso = new Permiso();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(permisoRequest, permiso);

        try {
            Permiso perm = service.createPermiso(permiso);
            response = UtilRestClient.crearResponseEntity(perm, HttpStatus.CREATED);
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    /**
     * Obtiene todos los permisos, puede realizar fltro por nombre.
     * 
     * @param nombre filtro.
     * @return list con todos los permisos.
     */
    @GetMapping
    public ResponseEntity<List<Permiso>> getAll(@RequestParam(required = false) String nombre) {
        List<Permiso> permisos = service.getAllPermisos(nombre);
        return new ResponseEntity<List<Permiso>>(permisos, HttpStatus.OK);
    }

    /**
     * Actualiza un permiso.
     * 
     * @param permisoRequest con los atributos necesarios para actualizar.
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @PutMapping
    public ResponseEntity<Object> updatePermiso(@RequestBody PermisoRequest permisoRequest) {
        Permiso permiso = new Permiso();
        ResponseEntity<Object> response = null;
        BeanUtils.copyProperties(permisoRequest, permiso);

        try {
            Permiso perm = service.updatePermiso(permiso);
            response = UtilRestClient.crearResponseEntity(perm, HttpStatus.OK);
        } catch (ServiceException e) {
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    /**
     * ELimina un permiso.
     *
     * @param idPermiso de permiso que se quiere eliminar.
     * @param idUsuario the id usuario
     * @return responseEntity con mensaje y codigo de respuesta.
     */
    @DeleteMapping(value = "/{idPermiso}/{idUsuario}")
    public ResponseEntity<Long> deletePermiso(@PathVariable(value = "idPermiso") Long idPermiso,
            @PathVariable(value = "idUsuario") String idUsuario) {
        service.deletePermiso(idPermiso, idUsuario);
        return new ResponseEntity<Long>(idPermiso, HttpStatus.OK);
    }

    /**
     * Obtiene un permiso por id de permiso.
     * 
     * @param idPerm id permiso a buscar.
     * @return Permiso encontrado con id.
     */
    @GetMapping(value = "/{idPerm}")
    public ResponseEntity<Permiso> getPermisoByIdPerm(@PathVariable(value = "idPerm") Long idPerm) {
        ResponseEntity<Permiso> response = null;
        Permiso permiso = service.getPermisoByIdPerm(idPerm);
        response = ResponseEntity.status(HttpStatus.OK).body(permiso);
        return response;
    }

}
