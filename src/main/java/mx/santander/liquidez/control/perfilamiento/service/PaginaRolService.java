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

import mx.santander.liquidez.control.perfilamiento.model.PaginaRol;
import mx.santander.liquidez.control.perfilamiento.model.PaginaRolPK;
import mx.santander.liquidez.control.perfilamiento.response.model.PaginaRolResponse;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PaginaRolService.java <br>
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
public class PaginaRolService implements IPaginaRolService {

    /**
     * Url para paginas roles.
     */
    @Value("${control.endpoint.perfilamiento.paginasroles}")
    private String uriPaginaRol;

    /**
     * Url para consumir servicio de perfilamiento.
     */
    @Value("${control.endpoint.perfilamiento.perfilamiento}")
    private String uriPerfilamiento;

    /**
     * RestTemplate para consimir serviico de paginas roles.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPageRol(PaginaRol pageRol) {
        restTemplate.postForObject(uriPaginaRol, pageRol, PaginaRol.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaRol> getAllPageRol() {
        ResponseEntity<List<PaginaRol>> response = restTemplate.exchange(uriPaginaRol, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PaginaRol>>() {
                });
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePageRol(PaginaRolPK pageRolId) {
        Gson gson = new Gson();
        String json = gson.toJson(pageRolId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        restTemplate.exchange(uriPaginaRol, HttpMethod.DELETE, entity, PaginaRolPK.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePageRol(PaginaRol pageRol) {
        restTemplate.put(uriPaginaRol, pageRol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaRol> findByIdRol(Long idRol) {
        return restTemplate.getForObject(uriPaginaRol + "/idRol/{idRol}", List.class, idRol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaRol> findByIdPage(Long idPage) {
        return restTemplate.getForObject(uriPaginaRol + "/idPagina/{idPage}", List.class, idPage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaRolResponse> getPaginasAsignadasRol(Long idRol) {
        return restTemplate.getForObject(uriPerfilamiento + "/paginas/roles/{idRol}", List.class, idRol);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaRolResponse> paginasNoAsignadasRol(Long idRol) {
        return restTemplate.getForObject(uriPerfilamiento + "/paginas_no_asignadas/roles/{idRol}", List.class, idRol);
    }

}
