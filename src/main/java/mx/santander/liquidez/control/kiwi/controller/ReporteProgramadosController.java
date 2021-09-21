package mx.santander.liquidez.control.kiwi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import mx.santander.liquidez.control.kiwi.service.IReporteProgramadoService;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ReporteProgramadosController.java
 * <br><b>Description:</b>
 * Clase creada para 
 *
 * @author FSW Lacertus Herwin Toral Rios
 * @company Praxis
 * @created 2 dic 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0  2 dic 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/pagos")
public class ReporteProgramadosController {
    
    /**
     * Variable iReporteProgramadoService de tipo IReporteProgramadoService usado en la clase.
     * by: tori 
     */
    private IReporteProgramadoService iReporteProgramadoService;
    
    /**
     * obtener reporte de los programados por fecha
     * @param fechaLiquidacion - fecha a la cual pertenece la consulta
     * @return objeto con la informacion de la consulta
     */
    @GetMapping("/{fechaLiquidacion}")
    public ResponseEntity<Object> obtenerReporteProgramadosByFecha(@PathVariable("fechaLiquidacion") String fechaLiquidacion){
        ResponseEntity<Object> response = null;
        try {
            response = UtilRestClient.crearResponseEntity(this.iReporteProgramadoService
                    .obtenerProgramadosByFecha(fechaLiquidacion), HttpStatus.OK);
        } catch (ServiceException e) {
            response = UtilRestClient.crearResponseEntity(ErrorUtil.obtenerUsando(e), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpStatusCodeException  e) {
            //RESPUESTA DE ERROR DEL SERVICIO
            response = UtilRestClient.crearResponseEntity(ErrorUtil.responseBodyToError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
