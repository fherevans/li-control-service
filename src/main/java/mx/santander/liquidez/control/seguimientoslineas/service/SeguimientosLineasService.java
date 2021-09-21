package mx.santander.liquidez.control.seguimientoslineas.service;

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
import mx.santander.liquidez.control.seguimientoslineas.dto.model.FiltroLineasCarteraDTO;
import mx.santander.liquidez.control.seguimientoslineas.dto.model.LineaCartera;
import mx.santander.liquidez.control.seguimientoslineas.dto.model.LineaCreditoIris;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-ctrl-monitor-service
 * <br><b>Class:</b> SeguimientoLineasService.java
 * <br><b>Description:</b> Interface service 
 *  para exponer los metodos de negocio 
 *  Seguimiento de Linea
 *
 * @author FSW Marcos Magana Hernandez
 * @version Control de cambios:
 * @version 1.0, 18 ago. 2019 FSW Praxis, 
 * Nombre del autor: Marcos Magana Hernandez
 * Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 17 ago. 2019
 * @category IterfaceService
 */
@Service
public class SeguimientosLineasService implements ISeguimientosLineasService  {
    
    /** Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguimientosLineasService.class);
    
    /**
     * Variable AUDIT de tipo String
     */
    private static final String AUDIT = "audit";
    
    /**  uri del servicio uriGetComboTablas no asignado expuesto en el api seguimientos de lineas. */
    @Value("${control.endpoint.lineaSeguimiento.get.consultaLinea}")
    private String uriGetLinea;
    
    /** Inyeccion de RestTemplate para consumir api seguimientos de lineas. */
    @Autowired
    private RestTemplate restTemplate;
            
    /**
     * Metodo de implementacion para 
     * consultar los Linea Iris.
     * @param tipoLinea the tipo linea
     * @param parametro the parametro
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link List<?>} lista de objeto
     * con los datos de los linea iris
     * @throws ServiceException the service exception
     */    
    @Override    
    public Object procesaLytLinea(FiltroLineasCarteraDTO filtros, String audit) throws ServiceException   {
        LOGGER.info("service consultar seguimientos lineas ... ");
        Gson gson = new Gson();
        String json = gson.toJson(filtros);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add(AUDIT, audit);
        
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        if(null != filtros && "CARTERA".equals(filtros.getTipoLinea())) {
            ResponseEntity<CustomPageImpl<LineaCartera>> response = restTemplate.exchange(uriGetLinea, HttpMethod.POST, entity,
                    new ParameterizedTypeReference<CustomPageImpl<LineaCartera>>() {});
            return response.getBody();    
        }    
        if(null != filtros && "IRIS".equals(filtros.getTipoLinea())) {
            ResponseEntity<CustomPageImpl<LineaCreditoIris>> response = restTemplate.exchange(uriGetLinea, HttpMethod.POST, entity,
                    new ParameterizedTypeReference<CustomPageImpl<LineaCreditoIris>>() {});
            return response.getBody();    
        }else {
            return null;
        }            
    }
    
}
