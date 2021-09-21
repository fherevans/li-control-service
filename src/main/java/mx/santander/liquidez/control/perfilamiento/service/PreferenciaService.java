package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.perfilamiento.model.Preferencia;
import mx.santander.liquidez.control.perfilamiento.request.model.PreferenciaRequest;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> PreferenciaService.java <br>
 * <b>Description:</b> Preferencias Service.
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
public class PreferenciaService implements IPreferenciaService {

    /**
     * Uri de servicio para preferencia.
     */
    @Value("${control.endpoint.perfilamiento.preferencia}")
    private String uriPreferencias;
    
    /**
     * Inyeccion de RestTemplate para consumir preferencias.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Preferencia> findByIdUserColumnas(String idUser) {
        return restTemplate.getForObject(uriPreferencias + "/{idUser}", List.class, idUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Preferencia> updatePreferencias(List<PreferenciaRequest> preferencias) {
        return restTemplate.postForObject(uriPreferencias, preferencias, List.class);
    }
}







