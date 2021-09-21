package mx.santander.liquidez.control.balance.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.bitacora.balance.dto.model.BalanceBitacoraDTO;
import mx.santander.liquidez.bitacora.balance.dto.model.BitacoraSistemaDTO;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.control.util.StringUtil;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-ctrl-monitor-service <br>
 * <b>Class:</b> BalanceBitacoraService.java <br>
 * <b>Description:</b> Clase Service para consultar el balance de bitacora.
 *
 * @author FSW Jose Manuel Gonzalez Quillo
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez
 *          Quillo Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 1 ago. 2019
 * @category Service.
 */
@Service
public class BalanceBitacoraService implements IBalanceBitacoraService {

    /** Variable LOGGER de tipo Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceBitacoraService.class);

    /** uri del servicio obtener balanceBitacora por id expuesto en el api Ctrl-Monitoreo. */
    @Value("${control.endpoint.bitacora.balance.get.bydate}")          
    private String uriGetBalanceBitacora;

    /**
     * Inyeccion de RestTemplate para consumir api de Balance Bitacora Balance.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Metodo de implementacion para consultar el balance de bitacora por fecha.
     *
     * @param date fecha a buscar balance
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link BalanceBitacoraDTO} objeto con datos del balance de bitacora
     * @throws ServiceException the service exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<BitacoraSistemaDTO> consultaByFecha(String date, String audit) throws ServiceException {                
        LOGGER.info("Consultar Balance Bitacora por fecha");                
        List<BitacoraSistemaDTO> result = new ArrayList<BitacoraSistemaDTO>();                
        try {
            
            HttpEntity<?> entity = new HttpEntity<>(null, StringUtil.obtenerHeaders(audit));
            result = restTemplate.exchange(uriGetBalanceBitacora +"{fecha}",HttpMethod.GET, entity, List.class, date.toString()).getBody();    
        } catch (RestClientException e) {
            throw new ServiceException(CodigoError.CLIENTE_REST,StringUtil.concat(uriGetBalanceBitacora,date), e);
        }    
        return result;        
        
    }

}