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

import mx.santander.liquidez.control.perfilamiento.model.Pagina;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PaginaService.java <br>
 * <b>Description:</b> Servicio para invocar RestTemplate.
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
public class PaginaService implements IPaginaService {
    
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
     * Endpoint de perfilamiendo para paginas
     */
    @Value("${control.endpoint.perfilamiento.paginas}")
    private String uriPaginas;

    /**
     * RetTemplate object para crear cliente.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     * 
     * @throws ServiceException excepcion de servicio.
     */
    @Override
    public void crearPage(Pagina page) throws ServiceException {

        try {
            restTemplate.postForObject(uriPaginas, page, Pagina.class);

        } catch (RestClientException e) {
            throw new ServiceException("Pagina ya existe", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pagina> getAllPages(String nombre, String nivPrio, String permiso) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriPaginas).queryParam("nombre", nombre)
                .queryParam("nivPrio", nivPrio).queryParam("permiso", permiso);

        ResponseEntity<List<Pagina>> response = 
                restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Pagina>>() {
                });
        
        return response.getBody();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws ServiceException
     */
    @Override
    public void updatePage(Pagina page) throws ServiceException {

        try {
            restTemplate.put(uriPaginas, page);
        } catch (RestClientException e) {
            throw new ServiceException("Pagina ya existe", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePage(Long idPage, String idUsuario) throws ServiceException {
        
        Map<String, String> encabezados = new HashMap<String, String>();
        encabezados.put(CONTENT_TYPE, APPLICATION_JSON);
        encabezados.put(ACCEPT, APPLICATION_JSON);

        UtilRestClient.executeServiceRest(null, encabezados, 
                uriPaginas + "/" + idPage + "/" + idUsuario, HttpMethod.DELETE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pagina findByIdPagina(Long idPage) {
        return restTemplate.getForObject(uriPaginas + "/{idPage}", Pagina.class, idPage);
    }

}
