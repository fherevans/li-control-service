package mx.santander.liquidez.control.parametria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import mx.santander.liquidez.control.parametria.service.ISaldoService;
import mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SaldosController.java <br>
 * <b>Description:</b> Clase controller.
 * encargada de exponer los endPoint para las
 * consultas de saldos historicos 
 * historicos de los sistemas SPEI, SIAC y DALI 
 * en la pantalla de seguimiento valores historicos
 *
 * @author FSW Praxis Christian Ivan Miranda Paulin
 * @version Control de cambios:
 * @version 1.0, 26 nov. 2020 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  26 nov. 2020
 * @category Cotroller
 */
@RefreshScope
@RestController
@RequestMapping("/saldos")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class SaldosController {
    
    /**
     * Instancia LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SaldosController.class);
    
    /**
     * Instancia iSaldosService de tipo ISaldosService
     */
    @Autowired
    private ISaldoService iSaldosService;
    
    /**
     * Obtener saldos.
     * Metodo que se encargara
     * de obtener los saldos para casa de bolsa santander y banco santander
     * de los sistemas SIAC, SPEI, DALI de acuerdo a la fecha seleccionada
     * para ser mostrados en la pantalla de seguimento de valores
     * @param fecha con la que se realizara la consulta T y  T-1 a T-30
     * @param bandera parametro que indica si consultara los saldos C=casa de bolsa o B=Banco Santander
     * @return lista de saldos obtenidos en lla consulta
     */
    @GetMapping("/{fecha}/{bandera}")
    public ResponseEntity<Object> obtenerSaldo(
            @PathVariable(required = true, name = "fecha") String fecha,
            @PathVariable(required = true, name = "bandera") String bandera){
        ResponseEntity<Object> response = null;
        try {
            /*CONSULTAR SALDOS*/
            response = ResponseEntity.status(HttpStatus.OK).body(iSaldosService.obtenerSaldos(fecha, bandera));
        } catch (ServiceException e) {
            LOGGER.error("ERROR AL CONSULTAR LOS SALDOS HISTORICOS EN EL SERVICIO DE PARAMETRIA \n");
            Error error = ErrorUtil.obtenerUsando(e);
            response = UtilRestClient.crearResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error(error.toString(), e);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            LOGGER.error("ERROR AL CONSUMIR EL SERVICIO DE CONSULTAR LOS SALDOS HISTORICOS (PARAMETRIA) ......... \n", e);
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
