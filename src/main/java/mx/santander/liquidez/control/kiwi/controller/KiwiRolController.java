package mx.santander.liquidez.control.kiwi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.kiwi.service.IKiwiRolService;
import mx.santander.liquidez.notificacion.kiwi.model.Kiwi;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiRol;
import mx.santander.liquidez.request.model.KiwiRolRequest;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> KiwiRolController.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 5 sep 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
 */
@RestController
@RequestMapping("/kiwis_roles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class KiwiRolController {
    
    @Autowired
    private IKiwiRolService iKiwiRolService;
    
    /**
     * metodo para obtener la lista de kiwis asignados a un rol.
     * 
     * @param idRol - id de rol.
     * @param flagDia - bandera a cual dia pertenece la consulta
     * @return lista de kiwis asignados a un rol.
     */
    @GetMapping("/roles/{idRol}/{flagDia}")
    public ResponseEntity<List<Kiwi>> obtenerKiwiIdRol(@PathVariable("idRol") Long idRol, @PathVariable("flagDia") int flagDia) {
        ResponseEntity<List<Kiwi>> response = null;
        List<Kiwi> kiwisPorRol = this.iKiwiRolService.obtenerKiwiIdRol(idRol, flagDia);
        response = ResponseEntity.status(HttpStatus.OK).body(kiwisPorRol);
        return response;
    }
    
    /**
     * API para obtener kiwis no asignados a un rol.
     * 
     * @param idRol id de rol.
     * @param flagDia - bandera a cual dia pertenece la consulta
     * @return Kiwis no asignados a un rol.
     */
    @GetMapping("/kiwis_no_asignados_roles/rol/{idRol}/{flagDia}")
    public ResponseEntity<List<Kiwi>> obtenerKiwisNoAsignadosIdRol(@PathVariable("idRol") Long idRol, @PathVariable("flagDia") int flagDia) {
        ResponseEntity<List<Kiwi>> response = null;
        List<Kiwi> kiwisNOAsignados = this.iKiwiRolService.obtenerKiwisNoAsignadosIdRol(idRol, flagDia);
        response = ResponseEntity.status(HttpStatus.OK).body(kiwisNOAsignados);
        return response;
    }

    /**
     * Metodo para eliminar una relacion de kiwi rol.
     * @param kiwiRolRequest kiwi rol request.
     * @return kiwiRol eliminado.
     */
    @DeleteMapping
    public ResponseEntity<String> eliminarKiwiIdRol(@RequestBody KiwiRolRequest kiwiRolRequest) {
        
            this.iKiwiRolService.eliminarKiwiIdRol(kiwiRolRequest);
        
        return new ResponseEntity<String>("200", HttpStatus.OK);
    }

    /**
     * API para crear un nuevo kiwi rol.
     * 
     * @param kiwiRolRequest kiwi rol request.
     * @return kiwiRol creado.
     */
    @PostMapping
    public ResponseEntity<KiwiRol> asignarKiwiRol(@RequestBody KiwiRolRequest kiwiRolRequest) {
        return new ResponseEntity<KiwiRol>(this.iKiwiRolService.asignarKiwiRol(kiwiRolRequest), HttpStatus.OK);
    }

}
