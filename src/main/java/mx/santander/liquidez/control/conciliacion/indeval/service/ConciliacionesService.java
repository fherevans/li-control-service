package mx.santander.liquidez.control.conciliacion.indeval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestProcesoConciDTO;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;
import mx.santander.liquidez.control.util.UtilRestClient;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ConciliacionesService.java <br>
 * <b>Description:</b> cliente con li-conciliacion-indeval-service.
 *
 * @author Victor Basurto Alonso
 * @company Praxis
 * @created 15 Feb. 2021
 * @since JDK:1.8
 *
 * @category Service.
 *
 */
@Slf4j
@Service
public class ConciliacionesService implements IConciliacionesService {

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
     * Un REST template.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Variable uriSeguimientoOpicsDali de tipo String
     */
    @Value("${control.endpoint.conciliaciones.opicsDali}")
    private String uriSeguimientoOpicsDali;
    
    /**
     * Variable uriActivaProcesoConci de tipo String
     */
    @Value("${control.endpoint.conciliaciones.procesos}")
    private String uriActivaProcesoConci;
    
    /**
     * Variable uriConciliacionesListas de tipo String
     */
    @Value("${control.endpoint.conciliaciones.listas}")
    private String uriConciliacionesListas;
    
    /**
     * uriSeguimientoHtoHDali de tipo String, Uri para seguimiento.
     */
    @Value("${control.endpoint.conciliaciones.htohDali}")
    private String uriSeguimientoHtohDali;

    /**
     * Variable uriConciliacionesManuales de tipo String
     */
    @Value("${control.endpoint.conciliaciones.manuales}")
    private String uriConciliacionesManuales;
    
    /**
     * Variable uriConciliacionesTotales de tipo String
     */
    @Value("${control.endpoint.conciliaciones.totales}")
    private String uriConciliacionesTotales;
    
    
    /**
     * Método que realiza la consulta de las operaciones conciliadas H2h vs Dali
     * 
     * @param requestSegIndevalConciPageable bean que contiene la información con los que se realizará la consulta
     * @return Object (CustomPageImpl<ConciliacionesDTO>) objeto pageable con las operaciones
     * @throws ServiceException the service exception
     */
    @Override
    public Object getConciliacionesH2HDaliPageable(RequestConciliacionesDTO request) throws ServiceException {
        log.info("Ingresando a ConciliacionesService.getConciliacionesH2HDaliPageable() .........");
        return UtilRestClient.executeServiceRest(request, StringUtil.obtenerEncabezados(null), uriSeguimientoHtohDali, HttpMethod.POST);
    }

    /**
     * Metodo de implementacion para consultar las operaciones conciliadas Opics vs Dali
     * @param request objeto con filtros de la consulta de operaciones
     * @return Object (CustomPageImpl<ConciliacionesDTO>) objeto pageable con las operaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object conciliacionOpicsDali(RequestConciliacionesDTO request) throws ServiceException {
        log.info("Ingresando a ConciliacionesService.consultaConciliadas() .........");
        // para consultar operaciones conciliadas Opics vs Dali
        return UtilRestClient.executeServiceRest(request, StringUtil.obtenerEncabezados(null), uriSeguimientoOpicsDali, HttpMethod.POST);
    }

    /**
     * Consulta conciliaciones.
     * Metodo que se encargara de realiza
     * el proceso de obtener la informacion
     * de las conciliaciones
     * @param requestConciListaDTO bean que contiene la informacion para realizar la consulta
     * @return regresa la lista de la informaicon encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object consultaConciliaciones(RequestConciListaDTO requestConciListaDTO) throws ServiceException {
        log.info("Ingresando a ConciliacionesService.consultaConciliaciones() .........");
        /*Consulta operaciones conciliadas*/
        return UtilRestClient.executeServiceRest(
                requestConciListaDTO, StringUtil.obtenerEncabezados(null), uriConciliacionesListas, HttpMethod.POST);
    }

    /**
     * Consulta conciliaciones manuales.
     * Metodo que realiza la consulta inicial de las conciliaciones
     * manuales, para SIAC, DALI tanto programadas como reales
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object consultaConciliacionesManuales(RequestConsultaConciDTO requestConsultaConciDTO)
            throws ServiceException {
        /*Consulta conciliacion manual*/
        return UtilRestClient.executeServiceRest(
                requestConsultaConciDTO, StringUtil.obtenerEncabezados(null), uriConciliacionesManuales, HttpMethod.POST);
    }

    /**
     * Conciliaciones manuales listas.
     * Metodo que realiza la consulta inicial de las conciliaciones
     * manuales, para SIAC, DALI tanto programadas como reales para
     * la generacion del excel
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object conciliacionesManualesListas(RequestConsultaConciDTO requestConsultaConciDTO)
            throws ServiceException {
        /*Consulta conciliacion manual listas*/
        String urlListas =  StringUtil.concat(uriConciliacionesManuales,"/listas");
        return UtilRestClient.executeServiceRest(
                requestConsultaConciDTO, StringUtil.obtenerEncabezados(null), urlListas, HttpMethod.POST);
    }

    /**
     * Activa proceso.
     * Metodo que realiza activacion de proceso
     * de conciliacion manual de las operaciones
     * por sistema
     * @param requestProcesoConciDTO bean que contiene la informacion de la activacion del proceso
     * @return regresa la lista de la informacion encontrada en la BD
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object activaProceso(RequestProcesoConciDTO requestProcesoConciDTO) throws ServiceException {
        /*Consulta conciliacion manual*/
        return UtilRestClient.executeServiceRest(
                requestProcesoConciDTO, StringUtil.obtenerEncabezados(null), uriActivaProcesoConci, HttpMethod.POST);
    }

    /**
     * Obtener totales generales conci manual.
     * Metodo que realiza la consulta
     * de los totales
     * para las conciliaciones manuales
     * @param requestConsultaConciDTO bean que contiene la informacion de la consulta
     * @return regresa el total del programado o real del sistema
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object obtenerTotalesGeneralesConciManual(RequestConsultaConciDTO requestConsultaConciDTO)
            throws ServiceException {
        String urlTotales =  StringUtil.concat(uriConciliacionesManuales,"/totales");
        try {
            HttpHeaders headers = new HttpHeaders();
            //SE AGREGAN ENCABEZADOS A LA PETICION
            headers.add(CONTENT_TYPE, APPLICATION_JSON);
            headers.add(ACCEPT, APPLICATION_JSON);
            HttpEntity<RequestConsultaConciDTO> entity = new HttpEntity<RequestConsultaConciDTO>(requestConsultaConciDTO, headers);
            
            /* Invoca POST */
            ResponseEntity<Object> response = restTemplate
                    .exchange(urlTotales, HttpMethod.POST, entity, Object.class);
                                
            log.info("Consulta de los totales de conciliacion manual exitosa.");
            return response.getBody();
            
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,
                    urlTotales, e);
        }
    }

    /**
     * Totales conciliaciones paginacion.
     * Metodo que realiza la consulta
     * de los totales de las conciliaciones con paginacion
     * @param requestConciliacionesDTO bean que contiene la informacion de la consulta de totales
     * @return regresa un bean con la informacion de totales de las conciliaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object totalesConciliacionesPaginacion(RequestConciliacionesDTO requestConciliacionesDTO)
            throws ServiceException {
        log.info("Inicia consumo de la consulta de totales por paginación de conciliaciones");
        try {
            /* Invoca POST */
            return restTemplate
                    .exchange(uriConciliacionesTotales, HttpMethod.POST, this.generaHttpEntity(requestConciliacionesDTO), Object.class).getBody();                        
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,
                    uriConciliacionesTotales, e);
        }
    }
    
    /**
     * Totales conciliaciones.
     * Metodo que realiza la consulta
     * de los totales de las conciliaciones
     * @param requestConciliacionesDTO bean que contiene la informacion de la consulta de totales
     * @return regresa un bean con la informacion de totales de las conciliaciones
     * @throws ServiceException excepcion de negocio de liquidez intradia
     */
    @Override
    public Object totalesConciliaciones(RequestConciliacionesDTO requestConciliacionesDTO) throws ServiceException {
        log.info("Inicia consumo de la consulta de totales de conciliaciones");
        try {
            /* Invoca POST */
            return restTemplate
                    .exchange(StringUtil.concat(uriConciliacionesTotales,"/listas"), HttpMethod.POST, this.generaHttpEntity(requestConciliacionesDTO), Object.class).getBody();                        
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,
                    uriConciliacionesTotales, e);
        }
    }
    
    /**
     * Genera http entity.
     * Metodo que se encarga de generar
     * el HttpEntity para usarlo en las peticiones 
     * @param requestConciliacionesDTO bean que contiene la informacion de la consulta de totales
     * @return regresa el httpEntity informado
     */
    private HttpEntity<RequestConciliacionesDTO> generaHttpEntity(RequestConciliacionesDTO requestConciliacionesDTO){
        
        /*SE AGREGAN ENCABEZADOS A LA PETICION*/
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        
        /*Generamos httpEntity*/
        return new HttpEntity<RequestConciliacionesDTO>(requestConciliacionesDTO, headers);
    }
}
