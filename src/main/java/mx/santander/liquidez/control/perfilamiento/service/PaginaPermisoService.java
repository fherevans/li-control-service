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

import mx.santander.liquidez.control.perfilamiento.model.PaginaPermiso;
import mx.santander.liquidez.control.perfilamiento.model.PaginaPermisoPK;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PaginaPermisoService.java <br>
 * <b>Description:</b> Servicios para permisos asignados a la pagina.
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
public class PaginaPermisoService implements IPaginaPermisoService {

    /**
     * Endpoint de pagina permiso.
     */
    @Value("${control.endpoint.perfilamiento.paginapermiso}")
    private String uriPaginaPermiso;

    /**
     * RestTemplate para asignar permisos a paginas.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPagePerm(PaginaPermiso pagePerm) {
        restTemplate.postForObject(uriPaginaPermiso, pagePerm, PaginaPermiso.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaPermiso> getAllPagePerm() {
        ResponseEntity<List<PaginaPermiso>> response = restTemplate.exchange(uriPaginaPermiso, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PaginaPermiso>>() {
                });
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePagePerm(PaginaPermisoPK pagePermId) {
        Gson gson = new Gson();
        String json = gson.toJson(pagePermId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
        restTemplate.exchange(uriPaginaPermiso, HttpMethod.DELETE, entity, PaginaPermisoPK.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePagePerm(PaginaPermiso pagePerm) {
        restTemplate.put(uriPaginaPermiso, pagePerm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaPermiso> findByIdPerm(Long idPerm) {
        return restTemplate.getForObject(uriPaginaPermiso + "/permisos/{idPerm}", List.class, idPerm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaginaPermiso> findByIdPage(Long idPage) {
        return restTemplate.getForObject(uriPaginaPermiso + "/paginas/{idPage}", List.class, idPage);
    }

}
