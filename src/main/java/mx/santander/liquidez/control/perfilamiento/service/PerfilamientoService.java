package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.perfilamiento.response.model.PerfilamientoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.PermisoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.RolResponse;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PerfilamientoService.java <br>
 * <b>Description:</b> Perfilamiento Service.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 3 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 3 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
@Service
public class PerfilamientoService implements IPerfilamientoService {

    @Value("${control.endpoint.perfilamiento.perfilamiento}")
    private String uriPerfilamiento;

    /**
     * Inyeccion de rest template para consumir servicios.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public PerfilamientoResponse getPerfilamientoByUserId(String idUser) throws ServiceException {
        try {
            return restTemplate.getForObject(uriPerfilamiento + "/{idUser}", PerfilamientoResponse.class, idUser);
        } catch (RestClientException e) {
            throw new ServiceException("Id de usuario no existe", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PermisoResponse> getNombrePermisosNoAsignadosPagina(Long idPage) {
        return restTemplate.getForObject(uriPerfilamiento + "/permisos_no_asignados/paginas/{idPage}", List.class,
                idPage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PermisoResponse> permisosNoAsignadosUsuario(String idUsuario) {
        return restTemplate.getForObject(uriPerfilamiento + "/permisos_no_asignados/usuarios/{idUsuario}", List.class,
                idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RolResponse> rolesNoAsignadosUsuario(String idUsuario) {
        return restTemplate.getForObject(uriPerfilamiento + "/roles_no_asignados/usuarios/{idUsuario}", List.class,
                idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PermisoResponse> getPermisosPagina(Long idPage) {
        return restTemplate.getForObject(uriPerfilamiento + "/permisos/paginas/{idPage}", List.class, idPage);
    }

}