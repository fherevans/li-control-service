package mx.santander.liquidez.control.perfilamiento.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.santander.liquidez.control.perfilamiento.model.Rol;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> RolService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 2 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Service
public class RolService implements IRolService {
    
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
     * Uri para servicio de uris.
     */
    @Value("${control.endpoint.perfilamiento.roles}")
    private String uriRoles;

    /**
     * Inyeccion de RestTemplate para crear roles.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     * @throws ServiceException 
     */
    @Override
    public Rol createRol(Rol rol) throws ServiceException {
        try {
            return restTemplate.postForObject(uriRoles, rol, Rol.class);    
        }catch(RestClientException e) {
            throw new ServiceException("Rol ya existe", e);
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Rol> getAllRol(String nombre, String pagina) {
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriRoles)
                 .queryParam("nombre", nombre)
                 .queryParam("pagina", pagina);
        
        ResponseEntity<List<Rol>> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Rol>>() {
                });
        
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     * @throws ServiceException 
     */
    @Override
    public void deleteRol(Long id, String idUsuario) throws ServiceException {
        
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);
        
    UtilRestClient.executeServiceRest(null, encabezados, 
                uriRoles + "/" + id + "/" + idUsuario, HttpMethod.DELETE);
    }

    /**
     * {@inheritDoc}
     *  
     */
    @Override
    public Rol updateRol(Rol rol) throws ServiceException {
        try {
            restTemplate.put(uriRoles, rol);
            return rol;
        } catch (RestClientException e) {
            throw new ServiceException("Rol ya existe", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rol findByIdRol(Long idRol) {
        return restTemplate.getForObject(uriRoles + "/{idRol}", Rol.class, idRol);
    }


}
