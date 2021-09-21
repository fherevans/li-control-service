/**
 * 
 */
package mx.santander.liquidez.procesamiento.contingencia.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.contingencia.model.ActualizacionContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.model.ContingenciaDTO;
import mx.santander.liquidez.procesamiento.contingencia.service.IContingenciaService;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ContingenciaController.java
 * <br><b>Description:</b>
 * Controlador para los servicios de control de contingencia.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 4 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 * 
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/contingencias",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ContingenciaController {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ContingenciaController.class);
    
    /**
     * Es una referencia de contingencia service.
     */
    @Autowired
    private IContingenciaService contingenciaService;
    
    /**
     * Recibe la senial de control para activar contingencia.
     * @param idUsuario es el Id del usuario que activa contingencia
     * @param httpRequest es la referencia al objeto de HTTP Request.
     * @return un objeto {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<Object> activar(@RequestParam("idUsuario")
            String idUsuario, HttpServletRequest httpRequest) {
        try {
            /* Activacion. */
            String ipRemota = httpRequest.getRemoteAddr();
            contingenciaService.activar(idUsuario, ipRemota);
            
            LOGGER.info("Se ha activado la contingencia");
            
            return ResponseEntity.status(HttpStatus.OK)
                    .body(HttpStatus.OK.getReasonPhrase());

        } catch (ServiceException e) {
            /* Error */
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.warn(error.toString(), e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }
    
    /**
     * Solicita la actualizacion del estatus de contingencia.
     * @param actualizacionContingencia datos para actualizacion de contingencia
     * @param httpRequest es la referencia al objeto de HTTP Request.
     * @return un objeto {@link ResponseEntity}
     */
    @PutMapping
    public ResponseEntity<Object> actualizar(@RequestBody ActualizacionContingenciaDTO
            actualizacionContingencia, HttpServletRequest httpRequest) {
        try {            
            /* Actualizacion. */
            String ipRemota = httpRequest.getRemoteAddr();
            actualizacionContingencia.setIpRemota(ipRemota);
            ContingenciaDTO contingencia = contingenciaService
                    .actualizar(actualizacionContingencia);
            
            LOGGER.info("Actualizacion de contingencia realizada: ");

            return ResponseEntity.status(HttpStatus.OK).body(contingencia);

        } catch (ServiceException e) {
            /* Error */
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.warn(error.toString(), e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }
    
    /**
     * Obtiene el estatus que guarda la contingencia desde base de datos.
     * @param idUsuario es el Id del usuario que solicita el estatus
     * @param httpRequest es la referencia al objeto de HTTP Request.
     * @return un objeto {@link ResponseEntity}
     */
    @GetMapping
    public ResponseEntity<Object> obtenerEstatus(@RequestParam("idUsuario")
            String idUsuario, HttpServletRequest httpRequest) {
        try {
            /* Solicita consulta de estatus. */
            String ipRemota = httpRequest.getRemoteAddr();
            ContingenciaDTO contingencia = contingenciaService
                    .obtenerEstatus(idUsuario, ipRemota);
            
            LOGGER.info("Consulta de estatus de contingencia");
            
            return ResponseEntity.status(HttpStatus.OK).body(contingencia);

        } catch (ServiceException e) {
            /* Error */
            Error error = ErrorUtil.obtenerUsando(e);
            LOGGER.warn(error.toString(), e);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }

}
