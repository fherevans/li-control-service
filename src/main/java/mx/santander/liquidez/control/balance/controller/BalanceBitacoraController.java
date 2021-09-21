package mx.santander.liquidez.control.balance.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.bitacora.balance.dto.model.BitacoraSistemaDTO;
import mx.santander.liquidez.control.balance.service.IBalanceBitacoraService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> BalanceBitacoraController.java
 * <br><b>Description:</b> Clase controller para administrar las peticiones del 
 * servicio de balance de bitacora.
 *
 * @author FSW Jose Manuel Gonzalez Quillo
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category Controller.
 */
@RefreshScope
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/bitacoras/balances")
public class BalanceBitacoraController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceBitacoraController.class);
    
    /** Variable iBalanceBitacoraService de tipo IBalanceBitacoraService. */
    @Autowired
    private IBalanceBitacoraService iBalanceBitacoraService;
    
    /**
     * Metodo para consultar el balance de bitacora diario.
     *
     * @param date fecha de balance a consultar
     * @param requestHttp interfaz para proporcionar información de solicitud para servlets HTTP.
     * @return lista de los balances de bitacora encontrados
     */        
    @RequestMapping(value = "/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BitacoraSistemaDTO>> consultaByFecha(@PathVariable String date, HttpServletRequest requestHttp){                         
        LOGGER.info("Peticion recibida para consultar el balance de bitacora");
        HttpStatus estatus = null;
        List<BitacoraSistemaDTO> listResult = new ArrayList<BitacoraSistemaDTO>();        
        try {                                            
            listResult = iBalanceBitacoraService.consultaByFecha(date, StringUtil.obtenerHeadersAudit(requestHttp));
            if(null == listResult) {
                estatus = HttpStatus.NOT_FOUND;
            } else {
                estatus = HttpStatus.OK;
            }                                        
        } catch(ServiceException e) {
            LOGGER.warn(e.getMessage(), e);
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }                
        return new ResponseEntity<List<BitacoraSistemaDTO>>(listResult,estatus);    
        
    }
    
    

}
