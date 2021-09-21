/**
 * 
 */
package mx.santander.liquidez.control.parametria.service;

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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.santander.liquidez.control.parametria.model.CustomPageImpl;
import mx.santander.liquidez.control.parametria.model.DetalleSpeiSpidDTO;
import mx.santander.liquidez.control.parametria.model.RespSpeiSpidDTO;
import mx.santander.liquidez.control.parametria.model.SeguimientoSpeiSpidDTO;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SeguimientoSpeiSpidService.java
* <br><b>Description:</b> Clase Service de implementacion del seguimiento de SPEI y SPID.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 27 ene. 2020
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 27 ene. 2020 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Service.
*
*/
@Service
public class SeguimientoSpeiSpidService implements ISeguimientoSpeiSpidService {
    
    /**
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguimientoSpeiSpidService.class.getName());
    
    /**
     * Variable CONTENT_TYPE de tipo String
     */
    private static final String CONTENT_TYPE = "Content-Type";
    
    /**
     * Variable APPLICATION_JSON de tipo String
     */
    private static final String APPLICATION_JSON = "application/json";
    
    /**
     * Variable ACCEPT de tipo String
     */
    private static final String ACCEPT = "Accept";
    
    /**
     * Variable uriSeguimientoSpeiSpid de tipo String
     */
    @Value("${control.endpoint.seguimientos.filtros.get}")
    private String uriSeguimientoSpeiSpid;
    
    /**
     * Variable uriSeguimientoSpeiSpidTotales de tipo String
     */
    @Value("${control.endpoint.seguimientos.totales.post}")
    private String uriSeguimientoSpeiSpidTotales;
    
    /**
     * Variable uriSeguimientoSpeiSpidDetalle de tipo String
     */
    @Value("${control.endpoint.seguimientos.detalle.post}")
    private String uriSeguimientoSpeiSpidDetalle;

    /**
     * Inyeccion de RestTemplate para consumir api de kiwiRol.
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object obtenerFiltros() throws ServiceException {
        //CONSULTA FILTROS SEGUIMIENTO SPEI Y SPID
        try {
            return restTemplate.getForObject(uriSeguimientoSpeiSpid, Object.class);
        } catch (RestClientException e) {
            //ERROR AL LLAMAR EL SERVICIO PARAMETRIA
            throw new ServiceException(CodigoError.CLIENTE_REST, uriSeguimientoSpeiSpid, e);
        }
    }

    @Override
    public Object consultaSeguimientoTotalesSpeiSpid(SeguimientoSpeiSpidDTO seguimiento, String canal, 
            String operacion) throws ServiceException {
        Gson gson = new Gson();
        String json = gson.toJson(seguimiento);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        
        //LLAMA SERVICIO DE CONSULTA TOTALES DEL SEGUIMIENTO SPEI Y SPID
        String ruta = uriSeguimientoSpeiSpidTotales.replaceAll("\\%s/%s", "");
        ResponseEntity<CustomPageImpl<RespSpeiSpidDTO>> response = restTemplate.exchange(
                ruta + "{canal}" + "/{operacion}", HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<RespSpeiSpidDTO>>() {}, canal, operacion);

        LOGGER.info("CODIGO RESPUESTA DE SEGUIMIENTO SPEI Y SPID TOTALES: " + response.getStatusCodeValue());
        //RETORNA RESULTADO DE LA CONSULTA
        return response;
    }

    @Override
    public Object consultaSeguimientoDetalleSpeiSpid(SeguimientoSpeiSpidDTO seguimiento, String canal, 
            String operacion) throws ServiceException {
        Gson gson = new Gson();
        String json = gson.toJson(seguimiento);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        
        //LLAMA SERVICIO DE CONSULTA DETALLE DEL SEGUIMIENTO SPEI Y SPID
        String ruta = uriSeguimientoSpeiSpidDetalle.replaceAll("\\%s/%s", "");
        ResponseEntity<CustomPageImpl<DetalleSpeiSpidDTO>> response = restTemplate.exchange(
                ruta + "{canal}" + "/{operacion}", HttpMethod.POST, entity,
                new ParameterizedTypeReference<CustomPageImpl<DetalleSpeiSpidDTO>>() {}, canal, operacion);
        
        LOGGER.info("CODIGO RESPUESTA DE SEGUIMIENTO SPEI Y SPID DETALLE: " + response.getStatusCodeValue());
        //RETORNA RESULTADO DE LA CONSULTA
        return response;
    }

}
