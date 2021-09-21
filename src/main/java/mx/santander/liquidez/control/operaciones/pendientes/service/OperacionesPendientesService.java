package mx.santander.liquidez.control.operaciones.pendientes.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.operaciones.pendientes.dto.model.OperacionesConciliadasDTO;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> OperacionesPendientesService.java
 * <br><b>Description:</b> Clase service de 
 * implementacion del  negocio de Operaciones Pendientes
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 17 ago. 2019 FSW Praxis, 
 * Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category Service
 */
@Service
public class OperacionesPendientesService implements IOperacionesPendientesService {
    
    /** Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesPendientesService.class);
    
    /**  uri del servicio uriGetComboTablas no asignado expuesto en el api Operaciones Pendientes. */
    @Value("${control.endpoint.operacionsPendientes.get.consultaOperacion}")
    private String uriGetOperacionPendiente;
        
    /** Inyeccion de RestTemplate para consumir api seguimientos operaciones pendientes. */
    @Autowired
    private RestTemplate restTemplate;
    
    

    /**
     * Metodo para obtener las operaciones pendientes.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the lista operaciones pendientes
     * @throws ServiceException the service exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OperacionesConciliadasDTO> getListaOperacionesPendientes(String audit) throws ServiceException {
        LOGGER.info("consulta Operaciones Pendientes ... ");            
        List<OperacionesConciliadasDTO> result = new ArrayList<OperacionesConciliadasDTO>();
        try {
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            result = restTemplate.exchange(uriGetOperacionPendiente,HttpMethod.GET, entity, List.class).getBody();
            LOGGER.info("consulta Operaciones Pendientes ejecutada correctamente ... ");        
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,uriGetOperacionPendiente, e);
        }
        return result;        
        
    }
    
    
}
