package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import mx.santander.liquidez.control.perfilamiento.model.Usuario;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> UsuarioService.java <br>
 * <b>Description:</b> Usuario Service.
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
public class UsuarioService implements IUsuarioService {

    /**
     * Uni para servicio de usuarios.
     */
    @Value("${control.endpoint.perfilamiento.usuarios}")
    private String uriUsuarios;

    /**
     * Inyeccion de RestTemplate para crear usuarios.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return restTemplate.postForObject(uriUsuarios, usuario, Usuario.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Usuario> getAllUsuarios(String nombre, String apePat, String apeMat, String correo) {
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriUsuarios)
                .queryParam("nombre", nombre)
                .queryParam("apePat", apePat)
                .queryParam("apeMat", apeMat)
                .queryParam("correo", correo);

        ResponseEntity<List<Usuario>> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteUsuario(String idUsuario, String idUsuari) {
        restTemplate.delete(uriUsuarios, "/{idUsuario}", idUsuario, "/{idUsuari}");
        return idUsuario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario updateUsuario(Usuario usuario) {
        restTemplate.put(uriUsuarios, usuario);
        return usuario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario getUsuarioById(String idUsr) {
        return restTemplate.getForObject(uriUsuarios + "/{idUsr}", Usuario.class, idUsr);
    }

}