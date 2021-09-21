package mx.santander.liquidez.control.reporte.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.santander.liquidez.control.reporte.model.RequestReporteDTO;
import mx.santander.liquidez.control.reporte.model.RequestReporteEspecialesDTO;
import mx.santander.liquidez.control.reporte.model.ResponseReporteDTO;
import mx.santander.liquidez.control.reporte.service.IReporteService;
import mx.santander.liquidez.control.util.FieldErrorException;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> ReporteController.java <br>
 * <b>Description:</b> Bean
 *
 * @author FSW Praxis Christian Iván Miranda Paulin
 * @version Control de cambios:
 * @version 1.0 5 ago. 2019 FSW Praxis, Nombre del autor: Christian Iván Miranda
 *          Paulin Creacion de clase ReporteController
 * @since JDK1.8
 * @company Praxis
 * @created 5 ago. 2019
 * @category Controller
 */
@RestController
@RequestMapping(path = "/reportes")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Api(value = "Reportes Microservice")
public class ReportesController {
    /**
     * The log instance for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportesController.class);
    /**
     * Variable liReporteService de tipo ILiReporteService
     */
    @Autowired(required = true)
    private IReporteService liReporteService;

    /**
     * Genera reporte. Metodo que realiza la ceacion de un archivo excel para
     * liquidez intradia
     * 
     * @param requestReporteDTO the request balance DTO
     * @param result            the result
     * @return the response entity
     * @throws FieldErrorException the field error exception
     */
    @ApiOperation(value = "Metodo utilizado para la generacion de reportes", notes = "Response Codes:<br/")
    @PostMapping(path = "/generales", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseReporteDTO> generaReporte(@Valid @RequestBody RequestReporteDTO requestReporteDTO,
            BindingResult result) throws FieldErrorException {
        HttpStatus estatus = HttpStatus.OK;
        ResponseReporteDTO response = new ResponseReporteDTO();
        try {
            if (result.hasErrors()) {
                throw new FieldErrorException(HttpStatus.BAD_REQUEST.name(), result.getFieldErrors());
            } else {
                response = liReporteService.generaReporte(requestReporteDTO);
            }
        } catch (ServiceException e) {
            /** Control de excepciones */
            LOGGER.error("Ocurrio un error interno al crear el archivo", e);
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, estatus);
    }
    
    /**
     * Método que realiza la creación de un archivo de excel con fórmulas para
     * liquidéz intradia
     * 
     * @param id de tipo Long
     * @param req         de tipo RequestReporteEspecialesDTO
     * @param result      de tipo BindingResult
     * @return ResponseEntity<ResponseReporteDTO>
     * @throws FieldErrorException the field error exception
     * @throws FieldErrorException 
     */
    @ApiOperation(value = "Método utilizado para la generación de reportes especiales con fórmulas", notes = "Response Codes:<br/")
    @PostMapping("/especiales")
    public ResponseEntity<ResponseReporteDTO> generateSpecialReports(final @Valid @RequestParam("id") Long id,
            final @RequestBody RequestReporteEspecialesDTO req, final BindingResult result) throws FieldErrorException {
        ResponseReporteDTO response = new ResponseReporteDTO();
        HttpStatus estatus = HttpStatus.OK;
        try {
            if (result.hasErrors()) {
                throw new FieldErrorException(HttpStatus.BAD_REQUEST.name(), result.getFieldErrors());
            } else {
                    response = liReporteService.generaReportePronostico(req, id);
                }
        } catch (ServiceException e) {
            /** Control de excepciones */
            LOGGER.error("Ocurrio un error interno al crear el archivo:{}", e);
            estatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, estatus);
    }
    
}
