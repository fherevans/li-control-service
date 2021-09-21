/**
 * 
 */
package mx.santander.liquidez.control.parametria.controller;

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
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.parametria.model.SeguimientoSiacDTO;
import mx.santander.liquidez.control.parametria.service.ISeguimientoSiacService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SeguimientoSiacController.java
* <br><b>Description:</b> Clase controller para administrar las peticiones de la 
* pantalla de seguimiento de SIAC en Liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Controller.
*
*/
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value ="/seguimientos")
public class SeguimientoSiacController {
    
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguimientoSiacController.class);

    /**
     * Variable iSeguimientoSiacService de tipo ISeguimientoSiacService
     */
    @Autowired
    private ISeguimientoSiacService iSeguimientoSiacService;
    
    /**
     * Metodo para obtener los totales del seguimiento de SPEI y SPID
     * @param seguimiento objeto con los filtros de la consulta de seguimiento
     * @param canal nombre del canal SPID o SPEI
     * @param operacion nombre de operacion CO (real) o PV (programado)
     * @return lista con los datos de los totales de seguimiento de spei y spid
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/siac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getDetalleSeguimientoSpeiSpid(@Valid @RequestBody SeguimientoSiacDTO seguimiento){
        ResponseEntity<Object> response = null;
        try {
            //CONSULTA SEGUIMIENTO SIAC
            ResponseEntity<Object> seguimientoDetalleSiac =(ResponseEntity<Object>) iSeguimientoSiacService.consultaSeguimientoDetalleSiac(seguimiento);
            Object seguimientoDetallleBody = seguimientoDetalleSiac.getBody();
            response = ResponseEntity.status(HttpStatus.OK).body(seguimientoDetallleBody);
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL CONSULTAR EL DETALLE DEL SEGUIMIENTO DE SIAC EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE DETALLE DEL SEGUIMIENTO DE SIAC (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
