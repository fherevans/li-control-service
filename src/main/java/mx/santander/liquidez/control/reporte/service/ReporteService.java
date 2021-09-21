package mx.santander.liquidez.control.reporte.service;

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

import mx.santander.liquidez.control.reporte.model.RequestReporteDTO;
import mx.santander.liquidez.control.reporte.model.RequestReporteEspecialesDTO;
import mx.santander.liquidez.control.reporte.model.ResponseReporteDTO;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ReporteService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 6 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Service
public class ReporteService implements IReporteService {
    
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
     * Uri para obtener reporte.
     */
    @Value("${control.endpoint.reportes.generales}")
    private String uriReporte;
    
    /**
     * Uri para obtener reporte.
     */
    @Value("${control.endpoint.reportes.especiales}")
    private String uriReporteEspecial;

    /**
     * Resttemplate para consumir servicio de reportes.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Genera reporte. Metodo para generar archivo excel
     * 
     * @param requestBalanceDTO the request balance DTO
     * @return {@link ResponseReporteDTO} respuesta reporte
     * @throws ServiceException the service exception
     */
    @Override
    public ResponseReporteDTO generaReporte(RequestReporteDTO requestBalanceDTO) throws ServiceException {
        Gson gson = new Gson();
        String json = gson.toJson(requestBalanceDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<ResponseReporteDTO> response = restTemplate.exchange(uriReporte, HttpMethod.POST, entity,
                new ParameterizedTypeReference<ResponseReporteDTO>() {
                });
        return response.getBody();
    }

    /**
     * Genera reporte. Metodo para generar archivo excel con fórmulas
     * 
     * @param req de tipo RequestReporteEspecialesDTO
     * @param id de tipo Long
     * @return {@link ResponseReporteDTO} respuesta reporte
     * @throws ServiceException the service exception
     */
    @Override
    public ResponseReporteDTO generaReportePronostico(RequestReporteEspecialesDTO req, Long id) throws ServiceException {
        Gson gson = new Gson();
        String json = gson.toJson(req);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        ResponseEntity<ResponseReporteDTO> response = restTemplate.exchange(uriReporteEspecial+"?id="+id, HttpMethod.POST, entity,
                new ParameterizedTypeReference<ResponseReporteDTO>() {
                });
        return response.getBody();
    }

}
