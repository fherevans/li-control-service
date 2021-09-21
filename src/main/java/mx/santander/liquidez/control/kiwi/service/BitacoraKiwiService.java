/**
 * 
 */
package mx.santander.liquidez.control.kiwi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.notificacion.model.BitacoraKiwiDTO;
import mx.santander.liquidez.notificacion.model.BitacoraKiwiRequestDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> BitacoraKiwiService.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 1 oct 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 1 oct 2019 FSW Praxis Nombre del autor: Herwin Toral
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Service
public class BitacoraKiwiService implements IBitacoraKiwiService {

    /**
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BitacoraKiwiService.class.getName());


    
    /**
     * uri del servicio crear kiwirol expuesto en el api perfilamiento
     */
    @Value("${control.endpoint.bitacora.kiwi.get}")
    private String uriGetBitacoraKiwi;

    /**
     * Inyeccion de RestTemplate para consumir api de kiwiRol.
     */
    @Autowired
    private RestTemplate restTemplate;


    /**
     * Consultar la lista de Kiwis Generados durante el dia Actual.
     * 
     * @param idRol - el rol que hace la consulta
     * @param fecha - la fecha de la consulta del historial
     * @return - Retorna la lista de Kiwis Generados en el Dia de la consulta
     */
    @Override
    public Object obtenerBitacoraKiwiByDay(BitacoraKiwiRequestDTO request) {
        LOGGER.info("Se va a consultar la bitacora de kiwis generados en el dia actual");
        Gson gson = new Gson();
        String json = gson.toJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("ACCEPT", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<CustomPageImpl<BitacoraKiwiDTO>> response = restTemplate.exchange(uriGetBitacoraKiwi, HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<BitacoraKiwiDTO>>() {});
        LOGGER.info("Obtencion de instituciones con codigo de respuesta: " + response.getStatusCodeValue());
        return response.getBody();
    }

}
