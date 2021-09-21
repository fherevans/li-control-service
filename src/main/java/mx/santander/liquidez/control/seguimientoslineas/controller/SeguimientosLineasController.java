package mx.santander.liquidez.control.seguimientoslineas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.seguimientoslineas.dto.model.FiltroLineasCarteraDTO;
import mx.santander.liquidez.control.seguimientoslineas.service.ISeguimientosLineasService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> SeguimientoLineasController.java
 * <br><b>Description:</b> Clase controller para administrar 
 * las peticiones del  Seguimiento de Linea
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
@RequestMapping("/seguimientos_lineas")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class SeguimientosLineasController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguimientosLineasController.class);
    
    /**  Variable iSeguimientoLineasService de tipo ISeguimientoLineasService. */
    @Autowired
    private ISeguimientosLineasService iSeguimientoLineasService;

    /**
     * Metodo para consulta el Seguimiento de la Linea.
     *
     * @param filtros variable de tipo FiltroLineasCarteraDTO para obtener la lista de lineas
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<List<?>> lista con los datos de Seguimiento de Lineas
     * @throws ServiceException the service exception
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getListaLinea(@Valid @RequestBody FiltroLineasCarteraDTO filtros, HttpServletRequest requestHttp) throws ServiceException   {    
        LOGGER.info("Peticion recibida para obtener lista de Seguimientos Lineas ............ ");
        ResponseEntity<Object> response = null;
        Error error = null;
        try {                                            
            response = UtilRestClient.crearResponseEntity(iSeguimientoLineasService.procesaLytLinea(filtros, StringUtil.obtenerHeadersAudit(requestHttp)), HttpStatus.OK);                                
        }  catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR CONSULA LINEAS CONTROL MONITOR \n", e);
            error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ALINEAS (CONTROL MONITOR) ......... \n", e);
            error = ErrorUtil.responseBodyToError(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }    
        return response;                            
    }
    
}
