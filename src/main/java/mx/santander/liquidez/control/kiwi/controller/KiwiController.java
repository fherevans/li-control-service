/**
 * 
 */
package mx.santander.liquidez.control.kiwi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.kiwi.service.IKiwiService;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> KiwiController.java
 * <br><b>Description:</b> Reemplazar con una descripcion acorde a la
 * funcionalidad de la clase.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Descripcion breve del cambio
 * @since JDK1.8
 * @company Praxis
 * @created 5 sep 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
@RestController              
@RequestMapping("/catalogos/kiwis")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class KiwiController {

    /** The i kiwi service. */
    @Autowired
    private IKiwiService iKiwiService;

    /**
     * Obtiene lista de todos los kiwis.
     *
     * @param idRol the id rol
     * @param flagDia - bandera para consultar los kiwis del dia o dia + N
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return List de Kiwis.
     */
    @GetMapping("/{idRol}/{flagDia}")
    public List<KiwiDTO> consultaKiwiAll(@PathVariable("idRol") Long idRol, @PathVariable("flagDia") int flagDia, 
            HttpServletRequest requestHttp) {
        return this.iKiwiService.consultaKiwiAll(idRol, flagDia,  StringUtil.obtenerHeadersAudit(requestHttp));
    }

    /**
     * Registro de kiwis.
     * 
     * @param kiwi a registrar.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Kiwi registrado.
     */
    @PostMapping
    public KiwiDTO registrarKiwi(@RequestBody KiwiDTO kiwi, HttpServletRequest requestHttp) {
        return this.iKiwiService.registrarKiwi(kiwi, StringUtil.obtenerHeadersAudit(requestHttp));
    }

    /**
     * Actualizar kiwi.
     * 
     * @param id   de kiwi.
     * @param kiwi datos de kiwi.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return Kiwi actualizado.
     */
    @PutMapping("/{id}")
    public KiwiDTO actualizarKiwi(@PathVariable("id") String id, @RequestBody KiwiDTO kiwi, 
            HttpServletRequest requestHttp) {
        return this.iKiwiService.actualizarKiwi(kiwi, StringUtil.obtenerHeadersAudit(requestHttp));
    }

    /**
     * ELiminar un kiwi.
     * 
     * @param id de kiwi a eliminar.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return id de kiwi eliminado.
     */
    @DeleteMapping("/{id}")
    public String eliminarKiwi(@PathVariable("id") long id, HttpServletRequest requestHttp) {
        return this.iKiwiService.eliminarKiwi(id, StringUtil.obtenerHeadersAudit(requestHttp));
    }

}
