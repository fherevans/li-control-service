package mx.santander.liquidez.control.parametria.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.parametria.model.Aprovisionamiento;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.request.model.AprovisionamientoRequest;
import mx.santander.liquidez.control.parametria.service.IAprovisionamientoService;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> AprovisionamientosController.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 26 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 26 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category controller.
 *
 */
@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/control/equivalencias/aprovisionamientos")
public class AprovisionamientosController {

    /**
     * Inyeccion de service.
     */
    @Autowired
    private IAprovisionamientoService aprovisionamientosService;

    /**
     * API para crear un aprovisionamiento nuevo.
     * 
     * @param aprovisionamientoRequest aprovisionamiento request.
     * @return ResponseEntity con el objeto creado.
     */
    @PostMapping
    public ResponseEntity<Aprovisionamiento> crearAprovisionamiento(
            @RequestBody AprovisionamientoRequest aprovisionamientoRequest) {
        Aprovisionamiento aprov = new Aprovisionamiento();
        BeanUtils.copyProperties(aprovisionamientoRequest, aprov);
        Aprovisionamiento aprovResp = aprovisionamientosService.crearAprovisionamiento(aprov);
        return new ResponseEntity<Aprovisionamiento>(aprovResp, HttpStatus.OK);
    }

    /**
     * API para obtener aprovisionamientos con parametros.
     * 
     * @param claveAprov    filtro.
     * @param nombreSistema filtro.
     * @param nombreCanal   filtro.
     * @return ResponseEntity con lista aprovisionamientos.
     */
    @GetMapping
    public ResponseEntity<List<Aprovisionamiento>> obtenerAprovisionamientos(
            @RequestParam(required = false, name = "claveAprov") String claveAprov,
            @RequestParam(required = false, name = "nombreSistema") String nombreSistema,
            @RequestParam(required = false, name = "nombreCanal") String nombreCanal) {

        List<Aprovisionamiento> aprovisionamientos = aprovisionamientosService
                .obtenerTodosAprovisionamientos(claveAprov, nombreSistema, nombreCanal);

        return new ResponseEntity<List<Aprovisionamiento>>(aprovisionamientos, HttpStatus.OK);
    }

    /**
     * API para obtener aprovisionamientos paginados con filtro.
     * 
     * @param claveAprov    filtro.
     * @param nombreSistema filtro.
     * @param nombreCanal   filtro.
     * @param page          filtro.
     * @param size          filtro.
     * @return ResponseEntity con List paginada de aprovisionamiento.
     */
    @GetMapping("/paginados")
    public ResponseEntity<CustomPageImpl<Aprovisionamiento>> obtenerAprovisionamientosPaginas(
            @RequestParam(required = false, name = "claveAprov") String claveAprov,
            @RequestParam(required = false, name = "nombreSistema") String nombreSistema,
            @RequestParam(required = false, name = "nombreCanal") String nombreCanal,
            @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        CustomPageImpl<Aprovisionamiento> aprovisionamientos = aprovisionamientosService
                .obtenerTodosAprovisionamientos(claveAprov, nombreSistema, nombreCanal, page, size);
        return new ResponseEntity<CustomPageImpl<Aprovisionamiento>>(aprovisionamientos, HttpStatus.OK);
    }

}
