/**
 * 
 */
package mx.santander.liquidez.control.catalogo.sistema.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.catalogo.sistema.service.ISistemaCatalogoService;
import mx.santander.liquidez.control.parametria.model.Sistema;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SistemaCatalogoController.java
 * <br><b>Description:</b>
 * Controla las solicitudes del servicio de catalogo de sistemas.
 * Redirige las peticiones al servicio de control y monitoreo para que
 * sean atendidas. Utiliza un REST template y maneja los codigos HTTP.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 *
 * @see sistemaCatalogoService
 */
@RestController
@RequestMapping(value = "/catalogos/sistemas", 
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class SistemaCatalogoController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SistemaCatalogoController.class);
    
    /**
     * Instancia del servicio de catalogo de sistemas.
     */
    @Autowired
    private ISistemaCatalogoService sistemaCatalogoService;
    
    /**
     * Obtiene el catalogo completo de sistemas.
     * @return un arreglo de {@link Sistema}s
     */
    @GetMapping
    public ResponseEntity<Object> obtenerTodos() {
        try {
            Sistema[] sistemas = sistemaCatalogoService.obtenerTodos();
            return ResponseEntity.status(HttpStatus.OK).body(sistemas);            
        } catch (ServiceException e) {
            String error = e.getMessage();
            LOGGER.warn(error, e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al obtener los sistemas");
        }
    }
    
}
