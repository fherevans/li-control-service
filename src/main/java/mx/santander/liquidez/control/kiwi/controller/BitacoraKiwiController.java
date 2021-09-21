package mx.santander.liquidez.control.kiwi.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.kiwi.service.IBitacoraKiwiService;
import mx.santander.liquidez.notificacion.model.BitacoraKiwiRequestDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-notificacion-service
 * <br><b>Class:</b> BitacoraKiwiController.java
 * <br><b>Description:</b> Reemplazar con una descripcion acorde a la
 * funcionalidad de la clase.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 1 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Descripcion breve del cambio
 * @since JDK1.8
 * @company Praxis
 * @created 1 oct 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value ="/bitacoras")
public class BitacoraKiwiController {
    
    /** Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BitacoraKiwiController.class.getName());

    /** The i bitacora kiwi service. */
    @Autowired
    private IBitacoraKiwiService iBitacoraKiwiService;
    
    /**
     * Consultar la lista de Kiwis Generados durante el dia Actual.
     *
     * @param request variable de tipo BitacoraKiwiRequestDTO para obtener bitacora
     * @return - Retorna la lista de Kiwis Generados en el Dia
     */
    @RequestMapping(value = "/kiwis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerBitacoraKiwiByDay(@Valid @RequestBody
            BitacoraKiwiRequestDTO request){
        LOGGER.info("Entra a consutlar la lista de kiwis alertados al dia de hoy {} ", new Date());
        return new ResponseEntity<Object>(this.iBitacoraKiwiService.obtenerBitacoraKiwiByDay(request), HttpStatus.OK);
    }

}
