package mx.santander.liquidez.control.parametria.service;

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
import mx.santander.liquidez.control.parametria.model.Sistema;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SistemasService.java
 * <br><b>Description:</b> Clase Service de implementacion de los metodos de negocio de los
 *  sistemas de liquidez.
 *
 * @author Jose Manuel Gonzalez Quillo
 * @version Control de cambios:
 * @version 1.0, 18 sep. 2019 FSW Praxis, 
 * Nombre del autor: Jose Manuel Gonzalez Quillo
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 18 sep. 2019
 * @category Service
 */
@Service
public class SistemasService implements ISistemasService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SistemasService.class);
    
    /**
     * Inyeccion de RestTemplate para consumir api de Sistemas.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**  uri del servicio obtener sistema por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.sistemas.get.all}")
    private String uriSistemaGetAll;
    
    /**  uri del servicio obtener sistema por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.sistemas.get.byId}")
    private String uriSistemaGetById;
    
    
    /**  uri del servicio obtener sistema por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.sistemas.save}")
    private String uriSistemaPostSave;
    
    /**  uri del servicio obtener sistema por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.sistemas.update}")
    private String uriSistemaPutUpdate;
    
    /**  uri del servicio obtener sistema por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.sistemas.delete}")
    private String uriSistemaDelete;
    
    
    /**
     * Metodo para consultar los sistemas de liquidez.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Sistema} con la informacion de los sistemas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public List<Sistema> consultaSistemas(String audit) throws ServiceException {
        LOGGER.info("Consultar Sistemas: {}", uriSistemaGetAll);
        HttpEntity<String> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        ResponseEntity<List<Sistema>> response = restTemplate.exchange(uriSistemaGetAll, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Sistema>>() {});        
        return response.getBody();
    }

    /**
     * Metodo para consultar un Sistema por id.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    @Override
    public Sistema consultaSistemasById(Long id, String audit) throws ServiceException {
        LOGGER.info("Consultar Sistema por id: {}", id+" -- "+uriSistemaGetById);
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        ResponseEntity<Sistema> response = restTemplate.exchange(StringUtil.concat(uriSistemaGetById, id), HttpMethod.GET, entity,new ParameterizedTypeReference<Sistema>() {});
        return response.getBody();
    }

    /**
     * Metodo para guardar un Sistema.
     * @param sistema the sistema
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    @Override
    public Sistema saveSistema(Sistema sistema, String audit) throws ServiceException {
        LOGGER.info("Guardar Sistema "+uriSistemaDelete);
        HttpEntity<Sistema> entity = new HttpEntity<>(sistema, StringUtil.obtenerHeaders(audit));
        return restTemplate.postForObject(uriSistemaPostSave,entity,Sistema.class);
    }

    /**
     * Metodo para actualizar un Sistema.
     * @param id the id
     * @param sistema the sistema
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    @Override
    public Sistema updateSistema(Long id, Sistema sistema, String audit) throws ServiceException {
        LOGGER.info("Actualizar Sistema por id: {}", id+" -- "+uriSistemaDelete);    
        HttpEntity<Sistema> entity = new HttpEntity<>(sistema, StringUtil.obtenerHeaders(audit));
        restTemplate.exchange(StringUtil.concat(uriSistemaPutUpdate, id), HttpMethod.PUT, entity, Sistema.class);
        return sistema;
    }

    /**
     * Metodo para Borrar un Sistema.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    @Override
    public String deleteSistema(Long id, String audit) throws ServiceException {
        LOGGER.info("Eliminar Sistema por id: {}", id+" -- "+uriSistemaDelete);                
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        restTemplate.exchange(StringUtil.concat(uriSistemaDelete, id), HttpMethod.DELETE, entity, Object.class);
        return "200";
    }

}
