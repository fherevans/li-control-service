package mx.santander.liquidez.control.parametria.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SaldoService.java <br>
 * <b>Description:</b> Clase Service. 
 * que sera la encargada de consultar el servicio 
 * de parametria que es el encargado de obtener los saldos
 * historicos de los sistemas SPEI, SIAC y DALI 
 * en la pantalla de seguimiento valores historicos
 *
 * @author FSW Christian Ivan Miranda Paulin
 * @version Control de cambios:
 * @version 1.0, 26 nov. 2020 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  26 nov. 2020
 * @category Service
 */
@Service
public class SaldoService implements ISaldoService{
    
    /**
     * La instancia para logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SaldoService.class);
    
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
     * Variable uriSaldos de tipo String
     */
    @Value("${control.endpoint.saldos}")
    private String uriSaldos;
    
    /**
     * RestTemplate para consumir servicio.
     */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * Obtener saldos
     * 
     * Metodo que se encargara
     * de obtener los saldos
     * de los sistemas SIAC, SPEI, DALI de acuerdo a la fecha seleccionada
     * para ser mostrados en la pantalla de seguimento de dali, para casa de bolsa santander
     * o banco santander de acuerdo a la bandera
     * @param fecha con la que se realizara la consulta T y T-1 a T-30
     * @param  bandera parametro que indica si consultara los saldos C= Casa de bolsa o B= Banco Santander
     * @return lista de saldos obtenidos en la consulta
     * @throws ServiceException error en la ejecucion de la consulta
     */
    @Override
    public Object obtenerSaldos(String fecha, String bandera) throws ServiceException {
        LOGGER.info("CONSULTA SALDOS: [{}]", uriSaldos);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON);
        headers.add(ACCEPT, APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(fecha, headers);
        ResponseEntity<Object> response = restTemplate.exchange(
                uriSaldos + "/{fecha}" + "/{bandera}", HttpMethod.GET, entity,
                new ParameterizedTypeReference<Object>() {}, fecha, bandera);
        return response.getBody();
    }

}
