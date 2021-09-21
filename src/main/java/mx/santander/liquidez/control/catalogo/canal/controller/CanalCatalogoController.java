package mx.santander.liquidez.control.catalogo.canal.controller;

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

import mx.santander.liquidez.control.catalogo.canal.service.ICanalService;
import mx.santander.liquidez.control.parametria.model.Canal;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> CanalCatalogoController.java
* <br><b>Description:</b> Controla las solicitudes del servicio de catalogo de canales.
* Redirige las peticiones al servicio de control y monitoreo para que sean atendidas. 
* Utiliza un REST template y maneja los codigos HTTP.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 21 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 21 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RestController
@RequestMapping(value = "/catalogos/canales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class CanalCatalogoController {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CanalCatalogoController.class);
    
    /**
     * Variable iCanalService de tipo ICanalService
     */
    @Autowired
    private ICanalService iCanalService;
    
    /**
     * Metodo para obtener el catalogo completo de canales de liquidez.
     * @return un arreglo del objeto {@link Canal} con los datos de canales
     */
    @GetMapping
    public ResponseEntity<Object> obtenerTodos() {
        ResponseEntity<Object> response = null;
        try {
            Canal[] canal = iCanalService.obtenerCanales();
            response = ResponseEntity.status(HttpStatus.OK).body(canal);            
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL LLAMAR EL END POINT DE CANALES EN EL SERVICIO DE PARAMETRIA \n", e);
            response = ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return response;
    } 
    
}
