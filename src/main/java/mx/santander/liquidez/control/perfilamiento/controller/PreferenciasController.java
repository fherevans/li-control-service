package mx.santander.liquidez.control.perfilamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.perfilamiento.model.Preferencia;
import mx.santander.liquidez.control.perfilamiento.request.model.PreferenciaRequest;
import mx.santander.liquidez.control.perfilamiento.service.IPreferenciaService;


/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PageController.java <br>
 * <b>Description:</b> API para realizar CRUD de tabla.
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
 * @category controller.
 * 
 */
@RestController
@RequestMapping("/preferencias")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PreferenciasController {

    /**
     * Inyeccion de preferencia service.
     */
    @Autowired
    private IPreferenciaService preferenciaService;

    /**
     * Metodo para obtener las columnas asignadas a un usuario.
     * @param idUser is de usuario.
     * @return Lista de preferencias asignadas a un usuario.
     */
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<List<Preferencia>> obtenerColumnasAsignadasUsuario(
            @PathVariable(value = "idUser") String idUser) {
        ResponseEntity<List<Preferencia>> response = null;
        List<Preferencia> columnas = preferenciaService.findByIdUserColumnas(idUser);
        response = ResponseEntity.status(HttpStatus.OK).body(columnas);
        return response;
    }

    /**
     * API para actualizar preferencias.
     * 
     * @param listPreferencias lista de preferencias a actualizar.
     * @return cantidad de preferencias actualizadas.
     */
    @PostMapping
    public ResponseEntity<List<Preferencia>> actualizarPreferencias(@RequestBody List<PreferenciaRequest> listPreferencias) {
        List<Preferencia> cantidad = preferenciaService.updatePreferencias(listPreferencias);
        return new ResponseEntity<List<Preferencia>>(cantidad, HttpStatus.OK);

    }

}
