/**
 * 
 */
package mx.santander.liquidez.control.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ControlController.java
 * <br><b>Description:</b>
 * Controlador principal de la aplicacion.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 4 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 4 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Controller
 * 
 */
@RefreshScope
@RestController
@RequestMapping(value = "/controles",
        produces = "application/json; charset=utf-8")
public class ControlController {
    
    @Value("${control.messages.greetings}")
    private String saludos;
    
    /**
     * Retorna un mensaje como indicador de que
     * el control esta habilitado.
     * @return un simple mensaje
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String obtenerSaludos() {
        return saludos;
    }

}
