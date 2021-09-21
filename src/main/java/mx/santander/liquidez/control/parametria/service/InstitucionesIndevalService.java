package mx.santander.liquidez.control.parametria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.parametria.model.Institucion;
import mx.santander.liquidez.control.parametria.model.InstitucionesPaginadaRequest;
import mx.santander.liquidez.control.parametria.model.RequestInstitucionIndeval;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> InstitucionesIndevalService.java <br>
 * <b>Description:</b> Clase de implementacion de los metodos de negocio de las instituciones de liquidéz.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 04 Nov. 2020
 * @since JDK:1.8
 *
 * @category Service
 *
 */
@Service
public class InstitucionesIndevalService implements IInstitucionesIndevalService {

    /**
     * uri para institucion.
     */
    @Value("${control.endpoint.instIndeval}")
    private String uriInstitucionesIndeval;

    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Implementacion del metodo para consultar todas las instituciones de indeval
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object getAllInstituciones(String audit) throws ServiceException {
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval, HttpMethod.GET, entity, Object.class).getBody();
    }
    
    /**
     * Implementacion del metodo para consultar todas las instituciones de indeval
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object getInstitucionesFilters(String audit) throws ServiceException {
        HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval + "/filters", HttpMethod.GET, entity, Object.class).getBody();
    }
    
    /**
     * Implementación del método para crear una institución
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object createsInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException {
        HttpEntity<RequestInstitucionIndeval> entity = new HttpEntity<>(requestInstitucionIndeval, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval, HttpMethod.POST, entity, Object.class).getBody();
    }
    
    /**
     * Implementación del método para actualizar una institución
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object updatesInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException {
        HttpEntity<RequestInstitucionIndeval> entity = new HttpEntity<>(requestInstitucionIndeval, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval, HttpMethod.PUT, entity, Object.class).getBody();
    }
        
    /**
     * Implementación del método para eliminar una institución
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object removesInstitutions(String audit, RequestInstitucionIndeval requestInstitucionIndeval) throws ServiceException {
        HttpEntity<RequestInstitucionIndeval> entity = new HttpEntity<>(requestInstitucionIndeval, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval, HttpMethod.DELETE, entity, Object.class).getBody();
    }
    
    /**
     * Implementación del método para consultar instituciones paginadas
     * 
     * @return lista del objeto {@link Institucion} con los datos de las instituciones
     * @throws ServiceException excepcion de negocio de liquidéz
     */
    @Override
    public Object getInstitutionsPageable(String audit, InstitucionesPaginadaRequest institucionesPaginadaRequest)
            throws ServiceException {
        HttpEntity<InstitucionesPaginadaRequest> entity = new HttpEntity<>(institucionesPaginadaRequest, StringUtil.obtenerHeaders(audit));
        return restTemplate.exchange(uriInstitucionesIndeval + "/pageables", HttpMethod.POST, entity, Object.class).getBody();
    }
    
}
