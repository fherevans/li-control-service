package mx.santander.liquidez.control.efectivo.dali.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.liquidez.control.efectivo.dali.model.BusinessException;
import mx.santander.liquidez.control.efectivo.dali.model.ControllerException;
import mx.santander.liquidez.control.efectivo.dali.service.IEfectivoDaliService;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Clase:</b> EfectivoDaliController.java
 * <br><b>Description:</b>
 * Controlador que expone el servicio REST para efectivo/dali
 *
 * @author FSW Gustavo Adolfo Arellano Sandoval
 * @company CECoaching
 * @created 10 sep. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 0 sep. 2021: Creacion de la clase
 *
 * @category Controller
 * 
 */
@RestController
@RequestMapping(value = "/efectivos")
public class EfectivoDaliController {    
    @Value("${control.endpoint.efectivo.dali}")
    private String urlEfectivosEndpoint = "";
    
    /**
     * Sericio de "efectivo-dali"
     */
    private IEfectivoDaliService efectivoDaliService = null;

    /**
     * Constructor de la clase
     * @param efectivoDaliService Instancia del servicio EfectivoDaliService a emplear.
     */
    public EfectivoDaliController(IEfectivoDaliService efectivoDaliService) {
        this.efectivoDaliService = efectivoDaliService;
    }
    /**
     * Endpoint asociado a "Efectivo Dali".
     * 
     * @param idInst
     * @param numFolioInst
     * @param fecha
     * 
     * @return Cadena con respuesta JSON
     * @throws ControllerException Se dispara en caso de que ocurra un error a nivel Controlador.
     */
    @GetMapping(
            path = "/dali/{idInst}/{numFolioInst}/{fecha}",
            produces = "application/json; charset=utf-8")
    public String getEfectivoDali(
            @PathVariable String idInst, 
            @PathVariable String numFolioInst, 
            @PathVariable String fecha) throws ControllerException {
        idInst = valida(idInst);
        numFolioInst = valida(numFolioInst);
        valida(fecha); // without padding
        
        // PROBAR CON: http://localhost:8080/efectivos/dali/07/16/13-09-2022
        return efectivoDaliService.getEfectivoDali(idInst, numFolioInst, fecha, urlEfectivosEndpoint);
        
        //para prueba con: (" 2 ", " 15 ", "13-09-2021", urlEfectivosEndpoint);
    }
    
    /**
     * Valida que una cadena no sea nula o vacia o constituida por puros espacios.
     * 
     * @param s Cadena a evaluar
     * @throws BusinessException Disparada en caso de que la cadena sea nula o vacia o sea una cadena de puros espacios.
     */
    private String valida(String s) throws BusinessException {
        String SPACE = " ";
        if(s==null || s.trim().length()<1) {
            throw new BusinessException();
        } else {
            return SPACE + s + SPACE;
        }
    }
}
