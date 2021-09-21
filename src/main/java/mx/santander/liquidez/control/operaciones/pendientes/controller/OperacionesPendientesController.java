package mx.santander.liquidez.control.operaciones.pendientes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.operaciones.pendientes.dto.model.OperacionesConciliadasDTO;
import mx.santander.liquidez.control.operaciones.pendientes.service.IOperacionesPendientesService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;



/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> TraductorController.java
 * <br><b>Description:</b> Clase controller para administrar las peticiones del 
 * servicio de Operaciones Pendientes
 *
 * @author FSW Marcos Magaña Hernández
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, 
 * Nombre del autor: Marcos Magaña Hernández
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category Controller
 */
@RefreshScope
@RestController
@RequestMapping("/operaciones_pendientes")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class OperacionesPendientesController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesPendientesController.class);
    
    /**  Variable iOperacionesPendientesService de tipo IOperacionesPendientesService. */
    @Autowired
    private IOperacionesPendientesService iOperacionesPendientesService;
    
    /**
     * Metodo para consulta el Seguimiento de la Linea.
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<List<OperacionesConciliadasDTO>> lista con los datos de Seguimiento Iris
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperacionesConciliadasDTO>> getListaOperacionesPendientes(HttpServletRequest requestHttp)   {
        LOGGER.info("Peticion recibida para obtener lista de Seguimiento Linea...");        
        HttpStatus estatus = null;
        List<OperacionesConciliadasDTO> listResult = new ArrayList<OperacionesConciliadasDTO>();        
        try {                                            
            listResult = iOperacionesPendientesService.getListaOperacionesPendientes(StringUtil.obtenerHeadersAudit(requestHttp));
            if(null == listResult) {
                estatus = HttpStatus.NOT_FOUND;
            } else {
                estatus = HttpStatus.OK;
            }                                        
        } catch(ServiceException e) {
            LOGGER.warn(e.getMessage(), e);
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }                
        return new ResponseEntity<List<OperacionesConciliadasDTO>>(listResult,estatus);    
        
    }
    
    
    
}
