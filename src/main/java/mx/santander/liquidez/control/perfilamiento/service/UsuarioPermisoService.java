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

import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermiso;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoPK;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> UsuarioPermisoService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
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
public class UsuarioPermisoService implements IUsuarioPermisoService {

    /**
     * Uri para consumir usuario permiso service.
     */
    @Value("${control.endpoint.perfilamiento.usuariopermiso}")
    private String uriUsuarioPermiso;

    /**
     * RestTemplate para consumir servicio de permisos de usuario.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createUserPerm(UsuarioPermiso userPerm) {
        restTemplate.postForObject(uriUsuarioPermiso, userPerm, UsuarioPermiso.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UsuarioPermiso> getAllUserPerm() {
        ResponseEntity<List<UsuarioPermiso>> response = restTemplate.exchange(uriUsuarioPermiso, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UsuarioPermiso>>() {
                });
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UsuarioPermiso> getAllUserPermByIdUser(String idUser) {
        return restTemplate.getForObject(uriUsuarioPermiso + "/{idUser}", List.class, idUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUserPerm(UsuarioPermisoPK userPermId) {
        Gson gson = new Gson();
        String json = gson.toJson(userPermId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);        
        restTemplate.exchange(uriUsuarioPermiso, HttpMethod.DELETE, entity, UsuarioPermisoPK.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserPerm(UsuarioPermiso userPerm) {
        restTemplate.put(uriUsuarioPermiso, userPerm);
    }

}