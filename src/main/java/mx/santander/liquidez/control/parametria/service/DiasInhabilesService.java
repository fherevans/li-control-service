package mx.santander.liquidez.control.parametria.service;

import java.util.ArrayList;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import mx.santander.liquidez.control.parametria.model.DiasInhabiles;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;


/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> DiasInhabilesService.java
 * <br><b>Description:</b> Clase Service de implementacion de los metodos de negocio de los
 *  dias inhabiles.
 *
 * @author Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 18 sep. 2019 FSW Praxis, 
 * Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 18 sep. 2019
 * @category Service
 */
@Service
public class DiasInhabilesService implements IDiasInhabilesService {
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DiasInhabilesService.class);
    
    /**
     * Inyeccion de RestTemplate para consumir api de Dias Inhabiles.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**  uri del servicio obtener los dias inhabilesexpuesto en el api li-parametria-service. */
    @Value("${control.endpoint.dias.inhabiles.get.all}")
    private String uriDiaInhabilGetAll;
    
    /**  uri del servicio obtener los dias inhabiles por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.dias.inhabiles.get.byId}")
    private String uriDiaInhabilGetById;
    
    
    /**  uri del servicio para guardar los dias inhabiles expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.dias.inhabiles.save}")
    private String uriDiaInhabilPostSave;
    
    /**  uri del servicio para actualizar un dia inhabil por id en el api li-parametria-service. */
    @Value("${control.endpoint.dias.inhabiles.update}")
    private String uriDiaInhabilPutUpdate;
    
    /**  uri del servicio eliminar un dia inhabil por id expuesto en el api li-parametria-service. */
    @Value("${control.endpoint.dias.inhabiles.delete}")
    private String uriDiaInhabilDelete;
    
    
    /**
     * Metodo para consultar los dias inhabiles de liquidez.
     * @return lista del objeto {@link DiasInhabiles} con la informacion de los dias inhabiles
     * @throws ServiceException excepcion de negocio de liquidez
     */
    @Override
    public List<DiasInhabiles> consultaDiasInhabiles(String audit) throws ServiceException {
        LOGGER.info("Consultar Dias Inhabiles: {}", uriDiaInhabilGetAll);
        List<DiasInhabiles> response  = new ArrayList<DiasInhabiles>();
        try {
            HttpEntity<String> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            response = restTemplate.exchange(uriDiaInhabilGetAll, HttpMethod.GET, entity, new ParameterizedTypeReference<List<DiasInhabiles>>() {}).getBody();
        } catch(RestClientException e) {
            response  = new ArrayList<DiasInhabiles>();
            LOGGER.error(CodigoError.CLIENTE_REST+" : "+uriDiaInhabilGetAll ,e);
        }                
        return response;
    }

    /**
     * Metodo para consultar un dia inhabil por id.
     * @param id the id
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    @Override
    public DiasInhabiles consultaDiasInhabilesById(Long id, String audit) throws ServiceException {
        LOGGER.info("Consultar Dia Inhabil por id: {}", id+" -- "+uriDiaInhabilGetById);            
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        ResponseEntity<DiasInhabiles> response = restTemplate.exchange(StringUtil.concat(uriDiaInhabilGetById, id), HttpMethod.GET, entity,new ParameterizedTypeReference<DiasInhabiles>() {});
        return response.getBody();
    }

    /**
     * Metodo para guardar los dias inhabiles.
     *
     * @param diasInhabiles the dias inhabiles
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    @Override
    public DiasInhabiles saveDiasInhabiles(DiasInhabiles diasInhabiles, String audit) throws ServiceException {
        LOGGER.info("Guardar Dia Inhabil "+uriDiaInhabilDelete);    
        HttpEntity<DiasInhabiles> entity = new HttpEntity<>(diasInhabiles,  StringUtil.obtenerHeaders(audit));
        return restTemplate.postForObject(uriDiaInhabilPostSave,entity,DiasInhabiles.class);
    }

    /**
     * Metodo para actualizar un dia inhabil.
     * @param id the id
     * @param diasInhabiles the dias inhabiles
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    @Override
    public DiasInhabiles updateDiasInhabiles(Long id, DiasInhabiles diasInhabiles, String audit) throws ServiceException {
        LOGGER.info("Actualizar Dia Inhabil por id: {}", id+" -- "+uriDiaInhabilDelete);    
        HttpEntity<DiasInhabiles> entity = new HttpEntity<>(diasInhabiles, StringUtil.obtenerHeaders(audit));
        restTemplate.exchange(StringUtil.concat(uriDiaInhabilGetById, id), HttpMethod.PUT, entity, DiasInhabiles.class);
        return diasInhabiles;
    }

    /**
     * Metodo para Borrar un dia inhabil.
     * @param id the id
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    @Override
    public String deleteDiasInhabiles(Long id, String audit) throws ServiceException {
        LOGGER.info("Eliminar Dia Inhabil por id: {}", id+" -- "+uriDiaInhabilDelete);                
        HttpEntity<Long> entity = new HttpEntity<>(id, StringUtil.obtenerHeaders(audit));
        restTemplate.exchange(StringUtil.concat(uriDiaInhabilGetById, id), HttpMethod.DELETE, entity, long.class);
        return "200";
    }

}
