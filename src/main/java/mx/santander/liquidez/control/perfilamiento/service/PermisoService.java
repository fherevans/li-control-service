package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.santander.liquidez.control.perfilamiento.model.Permiso;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PermisoService.java <br>
 * <b>Description:</b> Permiso service.
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
 * @category Service.
 *
 */
@Service
public class PermisoService implements IPermisoService {

    /**
     * Uri para servicio de permisos.
     */
    @Value("${control.endpoint.perfilamiento.permisos}")
    private String uriPermisos;

    /**
     * Inyeccion de RestTemplate para consumir permisos services.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     * @throws ServiceException excepcion de servicio.
     */
    @Override
    public Permiso createPermiso(Permiso permiso) throws ServiceException {
        try {
            return restTemplate.postForObject(uriPermisos, permiso, Permiso.class);
        }catch(RestClientException e) {
            throw new ServiceException("Permiso ya existe", e);
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Permiso> getAllPermisos(String nombre) {
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriPermisos)
                .queryParam("nombre", nombre);
        
        ResponseEntity<List<Permiso>> response = 
                restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Permiso>>() {
                });
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long deletePermiso(Long idPermiso, String idUsuario) {
        restTemplate.delete(uriPermisos + "/{idPermiso}/{idUsuario}", idPermiso, idUsuario);
        return idPermiso;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Permiso updatePermiso(Permiso permiso) throws ServiceException {
        
        try {
            restTemplate.put(uriPermisos, permiso);
        }catch(RestClientException e) {
            throw new ServiceException("Permiso ya existe", e);
        }
        
        return permiso;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Permiso getPermisoByIdPerm(Long idPerm) {
        return restTemplate.getForObject(uriPermisos + "/{idPerm}", Permiso.class, idPerm);
    }

}