/**
 * 
 */
package mx.santander.liquidez.control.semaforo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.semaforo.service.IKiwiSemaforoService;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SemaforoController.java
* <br><b>Description:</b> Clase Controller para administrar las peticiones de los
* semaforos de los sistemas de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 16 oct. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 16 oct. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller
*
*/
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/semaforos")
public class SemaforoController {

    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SemaforoController.class);
    
    /**
     * Variable service de tipo IKiwiSemaforo
     */
    @Autowired
    private IKiwiSemaforoService service;

    /**
     * Metodo para consultar los semaforos del rol solicitado en liquidez
     * @param rol identificador unico del rol de liquidez
     * @param fechaLiquidacion - Fecha a la cual se realiza la consulta
     * @return objeto con los datos de los semaforos solicitados
     */
    @RequestMapping(value = "/{rol}/{fechaLiquidacion}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultaSemaforos(@PathVariable String rol, @PathVariable int fechaLiquidacion){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(service.consultaSemaforos(rol, fechaLiquidacion), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL CONSULTAR LOS SEMAFOROS POR ROL");
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTA SEMAFOROS (NOTIFICACION) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    
    /**
     * Metodo para actualizar los semaforos asignados al rol solicitado en liquidez
     * @param semaforo lista con los datos de los semaforo a actualizar en liquidez
     * @return lista de los semaforos actualizados en liquidez
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizaSemaforos(@Valid @RequestBody SemaforoBalanceDTO semaforo){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(service.actualizarSemaforo(semaforo), HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL ACTUALIZAR EL SEMAFORO POR ROL");
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE ACTUALIZA SEMAFOROS (NOTIFICACION) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
