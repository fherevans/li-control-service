package mx.santander.liquidez.control.parametria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.santander.liquidez.control.parametria.model.Aprovisionamiento;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;



/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> AprovisionamientoService.java
* <br><b>Description:</b> Aprovisionamiento service.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 6 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 6 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
@Service
public class AprovisionamientoService implements IAprovisionamientoService {

    /**
     * Uri para aprovisionamiento.
     */
    @Value("${control.endpoint.equivalencia.aprovisionamientos}")
    private String uriAprovisionamiento;

    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Aprovisionamiento crearAprovisionamiento(Aprovisionamiento aprovisionamiento) {
        return restTemplate.postForObject(uriAprovisionamiento, aprovisionamiento, Aprovisionamiento.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomPageImpl<Aprovisionamiento> obtenerTodosAprovisionamientos(String claveAprov, String nombreSistema,
            String nombreCanal, Integer page, Integer size) {
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriAprovisionamiento + "/paginados")
                .queryParam("claveAprov", claveAprov)
                .queryParam("nombreSistema", nombreSistema)
                .queryParam("nombreCanal", nombreCanal)
                .queryParam("page", page)
                .queryParam("size", size);
        
         ResponseEntity<CustomPageImpl<Aprovisionamiento>> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<CustomPageImpl<Aprovisionamiento>>() {});
        
        return response.getBody();
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Aprovisionamiento> obtenerTodosAprovisionamientos(String claveAprov, String nombreSistema,
            String nombreCanal) {
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriAprovisionamiento)
                .queryParam("claveAprov", claveAprov)
                .queryParam("nombreSistema", nombreSistema)
                .queryParam("nombreCanal", nombreCanal);
        
        ResponseEntity<List<Aprovisionamiento>> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Aprovisionamiento>>() {
                });
        
        return response.getBody();
    }


}
