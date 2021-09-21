package mx.santander.liquidez.control.efectivo.dali.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.santander.liquidez.control.efectivo.dali.model.ControllerException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Clase:</b> CustomControllerAdvice.java
 * <br><b>Description:</b>
 * Controlador que manejara las excepciones lanzadas por los demas
 * controladores.
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
@ControllerAdvice
public class CustomControllerAdvice {
    
    /*
     * Logger para la clase CustomControllerAdvice.
     */
    private Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    /**
     * Método que maneja las exepciones de {@link io.kebblar.petstore.api.model.exceptions.ControllerException}.
     *
     * @param geEx la excepción que manejará (de tipo ControllerException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(ControllerException geEx) {
        // Se construye una traza personalizada del dump de la excepción
        String traza = getStackTraceExStr(geEx);
        // se manda esa traza al log con el estatus "error" para su posterior análisis
        logger.error(traza);
        return new ResponseEntity<>(crearMapaRetorno(geEx), geEx.getHttpStatus());
    }

    /**
     * Método auxiliar que crea el objeto a mostrarse cuando se lance la excepcion.
     *
     * @param ex la excepcion a mapear
     * @return el diccionario con la excepcion mapeada
     */
    private Map<String, Object> crearMapaRetorno(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof ControllerException) {
            ControllerException ad = (ControllerException) (ex);
            map.put("code", ad.getCode());
            map.put("message", ad.getMessage());
            map.put("description", ad.getDescription());
            map.put("level", ad.getLevel());
            map.put("moreInfo", ad.getMoreInfo());
            map.put("httpResponse",  ad.getHttpStatus());
        }
        return map;
    }

    /**
     * Método auxiliar que obtiene a traza de la excepcion completa.
     *
     * @param excepcion la excepcion que se debe rastrear
     * @return su representacion en string
     */
    private String getStackTraceExStr(Exception excepcion) {
        StringBuilder errorGenerica = new StringBuilder();
        if (excepcion instanceof ControllerException) {
            ControllerException ge = (ControllerException) (excepcion);
            errorGenerica.append("httpStatus: ");
            errorGenerica.append(ge.getHttpStatus());
            errorGenerica.append("code: ");
            errorGenerica.append(ge.getCode());
            errorGenerica.append("message : ");
            errorGenerica.append(ge.getMessage());
            errorGenerica.append("description:  ");
            errorGenerica.append(ge.getDescription());
            errorGenerica.append("level : ");
            errorGenerica.append(ge.getLevel());
            errorGenerica.append("moreInfo : ");
            errorGenerica.append(ge.getMoreInfo());
            StringWriter errores = new StringWriter();
            ge.printStackTrace(new PrintWriter(errores));
            errorGenerica.append("\n");
        }
        return errorGenerica.toString();
    }

}

