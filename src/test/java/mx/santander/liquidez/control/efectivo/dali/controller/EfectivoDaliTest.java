package mx.santander.liquidez.control.efectivo.dali.controller;

import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.efectivo.dali.model.ControllerException;
import mx.santander.liquidez.control.efectivo.dali.service.EfectivoDaliService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class EfectivoDaliTest {
    @Mock
    private RestTemplate restTemplate;
    
    @Test
    public void getEfectivoDaliTest_01() {
        getEfectivoDaliTest_base("a","b", "c", true);
    }
    @Test
    public void getEfectivoDaliTest_02() {
        getEfectivoDaliTest_base("","b", "c", false);
    }    
    @Test
    public void getEfectivoDaliTest_03() {
        getEfectivoDaliTest_base("a","", "c", false);
    } 
    @Test
    public void getEfectivoDaliTest_04() {
        when(restTemplate.getForObject("/2/15/13-09-2021", String.class)).thenThrow(new RestClientException("err"));
        EfectivoDaliService efectivoDaliService = new EfectivoDaliService(restTemplate);
        EfectivoDaliController edc = new EfectivoDaliController(efectivoDaliService);
        try {
            edc.getEfectivoDali(" 2 ", " 15 ", "13-09-2021");
            assert(false);
        } catch (ControllerException e) {
            assert(e.toString().length()>0);
        }
    }
    
    @Test
    public void controllerAdviceTest() {
        CustomControllerAdvice cca = new CustomControllerAdvice();
        ControllerException exception = new ControllerException(
                HttpStatus.ACCEPTED, "code", "message", "description", "level", "moreInfo");
        ResponseEntity<Map<String, Object>> re = cca.errorHandler(exception);
        assert(re.getStatusCode().equals(HttpStatus.ACCEPTED));
    }

    private void getEfectivoDaliTest_base(String id, String num, String fecha, boolean result) {
        when(restTemplate.getForObject("/"+id+"/"+num+"/"+fecha, String.class)).thenReturn("OK");
        EfectivoDaliService efectivoDaliService = new EfectivoDaliService(restTemplate);
        EfectivoDaliController edc = new EfectivoDaliController(efectivoDaliService);
        try {
            edc.getEfectivoDali(id, num, fecha);
            assert(result);
        } catch (ControllerException e) {
            assert(!result);
        }
    }
}
