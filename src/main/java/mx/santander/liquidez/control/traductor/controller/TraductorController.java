package mx.santander.liquidez.control.traductor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mx.santander.liquidez.control.traductor.dto.model.ComboBean;
import mx.santander.liquidez.control.traductor.dto.model.TraductorBean;
import mx.santander.liquidez.control.traductor.service.ITraductorService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> TraductorController.java
 * <br><b>Description:</b> Clase controller 
 * para administrar las peticiones del 
 * servicio de traductor
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
@RequestMapping("/traductores")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TraductorController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraductorController.class);
            
    /**  Variable iTraductorService de tipo ITraductorService. */
    @Autowired
    private ITraductorService iTraductorService;
    
    
    /**
     * Metodo para consultar todos los catalogos 
     * de tablas disponibles .
     * @return ResponseEntity<List<ComboBean>> 
     * lista con los datos de los catalogo de tablas
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComboBean>> consultarCatTablas() {        
        LOGGER.info("Peticion recibida para consultar catalago de tablas ... ");
        HttpStatus estatus = null;
        List<ComboBean> listaTabla = new ArrayList<ComboBean>();        
        try {
            listaTabla = iTraductorService.comboCatTablas();
            if(listaTabla.isEmpty()) {
                estatus = HttpStatus.NOT_FOUND;
                LOGGER.info("No se encontraron datos - " + estatus);
            } else {
                estatus = HttpStatus.OK;
                LOGGER.info("La consulta se realizo correctamente - " + estatus);
            }                        
        } catch(ServiceException e) {
            LOGGER.error("Ha ocurrido un error al consultar el catalogo de tablas", e);
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }        
        return new ResponseEntity<List<ComboBean>>(listaTabla,estatus);
    }
    
    
    /**
     * Metodo para procesar los archivos de carga 
     * Vector Precios, Divisas, Estados de Cuentas .
     * @param bean the bean
     * @param result the result
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return ResponseEntity<List<?>> lista con los datos del resultado de la carga
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<?>> procesarArchivo(@Valid @RequestBody TraductorBean bean, BindingResult result, HttpServletRequest requestHttp) {
        LOGGER.info("Peticion para procesar archivo de carga");
        HttpStatus estatus = null;    
        List<?> response = null;
        try {
            response = iTraductorService.procesarTraductor(bean, StringUtil.obtenerHeadersAudit(requestHttp));
            if(validaArchivo(bean.getData())) {
                estatus = HttpStatus.NOT_ACCEPTABLE;
            } else if(null == response) {
                estatus = HttpStatus.NOT_FOUND;
            } else {
                estatus = HttpStatus.OK;    
            }    
        } catch (ServiceException e) {
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
            ArrayList<String> error = new ArrayList<>();            
            error.add("Ha ocurrido al procesar Traductor: " + bean.getTipoCarga());
            response = error;            
            LOGGER.error("Error al procesar Traductor: ",e);
        }                        
        return new ResponseEntity<List<?>>(response, estatus);        
    }
    
    
    /**
     * Valida que el archivo recibido 
     * no este vacio o nulo
     * @param decodedArchivo the decoded archivo
     * @return true, if successful
     */
    private boolean validaArchivo(String decodedArchivo) {
        boolean result = false;        
        if(null == decodedArchivo) {
            result = true;
        }        
        if("".equals(decodedArchivo)) {
            result = true;
        }        
        if("W10=".equals(decodedArchivo)) {
            result = true;
        }        
        if("[]".equals(decodedArchivo)) {
            result = true;
        }        
        return result;
    }
    
    
        
}

