package mx.santander.liquidez.control.efectivo.dali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.efectivo.dali.model.BusinessException;

@Service
public class EfectivoDaliService implements IEfectivoDaliService {
    /**
     * Objeto de tipo RestTemplate para invocar servicios externos
     */
    @Autowired
    private RestTemplate restTemplate = null;
    
    /**
     * Constructor de la clase
     * @param restTemplate Objeto de tipo RestTemplate para invocar servicios externos
     */
    public EfectivoDaliService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }   
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getEfectivoDali(String idInst, String numFolioInst, String fecha, String ep) throws BusinessException {
        StringBuilder sb = new StringBuilder();
        sb.append(ep);
        sb.append("/");
        sb.append(idInst.trim());
        sb.append("/");
        sb.append(numFolioInst.trim());
        sb.append("/");
        sb.append(fecha);
        String urlEndpint = sb.toString();
        try {
            return restTemplate.getForObject(urlEndpint, String.class);
        } catch(RestClientException e) {
            throw new BusinessException(
                    "1001", 
                    e.getMessage(), 
                    "error invoking endpoint " + urlEndpint, 
                    "1", 
                    "Bad url call");
        }
    }
    
}
