/**
 * 
 */
package mx.santander.liquidez.control.kiwi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.notificacion.kiwi.model.Kiwi;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> KiwiService.java
 * <br><b>Description:</b> Servicio para comunicarnos con la api de Ctrl-Monitoreo
 * para realizar el CRUD de Kiwi.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Creacion de la clase
 * @since JDK1.8
 * @company Praxis
 * @created 5 sep 2019
 * @category @Service
 */
@Service
public class KiwiService implements IKiwiService {

    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(KiwiService.class);
    
    /** uri del servicio obtener kiwi por id expuesto en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.kiwi.get.byid}")
    private String uriGetByIdKiwi;
    
    /** uri del servicio obtener los kiwis registrados en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.kiwi.get.all}")
    private String uriGetKiwi;
    
    /** uri del servicio eliminar kiwi en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.kiwi.delete}")
    private String uriDeleteKiwi;
    
    /** uri del servicio crear kiwi en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.kiwi.post}")
    private String uriPostKiwi;
    
    /** uri del servicio crear kiwirol  expuesto en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.kiwi.put}")
    private String uriPutKiwi;
    
    /**
     * Inyeccion de RestTemplate para consumir api de kiwi.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Metodo para obtener kiwi por idKiwi.
     * 
     * @param id -  corresponde al idKiwi a consultar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link kiwi - el kiwi consultado}
     */
    @Override
    public Kiwi consultaKiwiById(long id, String audit) {
        LOGGER.info("Obtencion codigo de respuesta: {}", uriGetByIdKiwi);
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        ResponseEntity<Kiwi> response = restTemplate.exchange(StringUtil.concat(uriGetByIdKiwi, id), HttpMethod.GET, entity,
                new ParameterizedTypeReference<Kiwi>() {
                });
        return response.getBody();
    }

    /**
     * Metodo para obtener los kiwis disponibles.
     * @param flagDia - bandera para consultar los kiwis del dia o dia + N
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link List<Kiwi>} corresponde a la lista de kiwis consultados
     */
    @Override
    public List<Kiwi> consultaKiwiAll(int flagDia, String audit) {
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        ResponseEntity<List<Kiwi>> response = restTemplate.exchange(StringUtil.concat(uriGetKiwi, "/", flagDia) , HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Kiwi>>() {
                });
        LOGGER.info("Obtencion de tiempos con codigo de respuesta: {}", uriGetKiwi);
        return response.getBody();
    }

    /**
     * Metodo para registrar un kiwi.
     * 
     * @param kiwi - el objeto kiwi a registrar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link Kiwi} - el kiwi registrado en el sistema
     */
    @Override
    public KiwiDTO registrarKiwi(KiwiDTO kiwi, String audit) {
        LOGGER.info("Registrar Objeto Kiwi: {}", kiwi);
        LOGGER.info("Uri KIWI: {}", uriPostKiwi);
        HttpEntity<KiwiDTO> entity = new HttpEntity<>(kiwi, StringUtil.obtenerHeaders(audit));
        return restTemplate.postForObject(uriPostKiwi, entity, KiwiDTO.class);
    }

    /**
     * Metodo para actualizar informacion de los kiwi.
     *
     * @param kiwi - objeto kiwi con nuevos datos a modificar.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link Kiwi} Objeto actualizado en sistema
     */
    @Override
    public KiwiDTO actualizarKiwi(KiwiDTO kiwi, String audit) {
        LOGGER.info("Actualizar Objeto Kiwi: {}", kiwi);
        LOGGER.info("URi kiwi {}", uriPutKiwi);
        HttpEntity<KiwiDTO> entity = new HttpEntity<>(kiwi, StringUtil.obtenerHeaders(audit));
        restTemplate.put(StringUtil.concat(uriPutKiwi, kiwi.getIdKiwi()), entity);        
        return kiwi;
    }

    /**
     * Metodo para eliminar un kiwi en el sistema.
     *
     * @param id -  idKiwi que fue eliminado
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return confirmacion del kiwi eliminado
     */
    @Override
    public String eliminarKiwi(long id, String audit) {
        LOGGER.info("Eliminar Objeto Kiwi por id: {}", id);
        LOGGER.info("Delete Kiwi :: " + id);
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        restTemplate.exchange(StringUtil.concat(uriDeleteKiwi, id), HttpMethod.DELETE, entity,
                Object.class);
        return "200";
    }

    /**
     * Consulta kiwi all.
     *
     * @param idRol - the id rol
     * @param flagDia - flag para la consulta del dia
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the list
     */
    @Override
    public List<KiwiDTO> consultaKiwiAll(Long idRol,  int flagDia, String audit) {
        String urlKiwi = StringUtil.concat(uriGetKiwi,"/",idRol,"/",flagDia);
        LOGGER.info(" :::::: {}", urlKiwi);
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        ResponseEntity<List<KiwiDTO>> response = restTemplate.exchange(urlKiwi, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<KiwiDTO>>() {
                });
        LOGGER.info("Obtencion de tiempos con codigo de respuesta: {}", uriGetKiwi);
        return response.getBody();
    }

}
