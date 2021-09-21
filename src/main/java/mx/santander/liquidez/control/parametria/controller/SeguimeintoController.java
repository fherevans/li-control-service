package mx.santander.liquidez.control.parametria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.parametria.model.Detalle;
import mx.santander.liquidez.control.parametria.model.Totales;
import mx.santander.liquidez.control.parametria.service.ISeguimientoService;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-seguimiento-valores-service <br>
 * <b>Class:</b> ValoresController.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 9 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Controller.
 *
 */
@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/seguimientos")
public class SeguimeintoController {

    /**
     * Inyeccion de seguimiento service.
     */
    @Autowired
    private ISeguimientoService seguimientoService;

    /**
     * API para obtener valores.
     * 
     * @return valores actuales.
     */
    @GetMapping("/totales")
    public ResponseEntity<List<Totales>> obtenerTotales() {
        ResponseEntity<List<Totales>> response = null;
        List<Totales> totales = seguimientoService.obtenerTotales();
        response = ResponseEntity.status(HttpStatus.OK).body(totales);
        return response;
    }

    /**
     * API para obtener en transito.
     * 
     * @return Valores en transito.
     */
    @GetMapping("/detalles")
    public ResponseEntity<List<Detalle>> obtenerDetaller() {
        ResponseEntity<List<Detalle>> response = null;
        List<Detalle> detalle = seguimientoService.obtenerDetalle();
        response = ResponseEntity.status(HttpStatus.OK).body(detalle);
        return response;
    }
    
}
