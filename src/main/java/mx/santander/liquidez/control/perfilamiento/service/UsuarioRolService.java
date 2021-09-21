package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

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

import mx.santander.liquidez.control.perfilamiento.model.Usuario;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRol;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRolPK;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> UsuarioRolService.java <br>
 * <b>Description:</b> Servicio para invocar a usuario rol service
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
public class UsuarioRolService implements IUsuarioRolService {

    /**
     * Uri para consumir servicio de user rol.
     */
    @Value("${control.endpoint.perfilamiento.usuariorol}")
    private String uriUserRol;

    /**
     * RestTemplate para consumir servicio de usuario rol.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createUserRol(UsuarioRol userRol) {
        restTemplate.postForObject(uriUserRol, userRol, UsuarioRol.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UsuarioRol> getAllUserRol() {
        ResponseEntity<List<UsuarioRol>> response = restTemplate.exchange(uriUserRol, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UsuarioRol>>() {
                });
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UsuarioRol> findByIdUser(String idUser) {
        return restTemplate.getForObject(uriUserRol + "/{idUser}", List.class, idUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUserRol(UsuarioRolPK userRolId) {    
        Gson gson = new Gson();
        String json = gson.toJson(userRolId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");    
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        restTemplate.exchange(uriUserRol, HttpMethod.DELETE, entity, UsuarioRolPK.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserRol(UsuarioRol userRol) {
        restTemplate.put(uriUserRol, userRol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Usuario> getUsersByIdRol(Long idRol) {
        return restTemplate.getForObject(uriUserRol + "/id_roles/{idRol}", List.class, idRol);
    }


}
