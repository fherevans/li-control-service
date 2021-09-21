package mx.santander.liquidez.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestProcesoConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.service.ConciliacionesService;
import mx.santander.liquidez.control.util.ServiceException;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ConciliacionesServiceTest.class)
@ContextConfiguration(classes = { ConciliacionesServiceTest.class })
@Ignore
public class ConciliacionesServiceTest {

    @InjectMocks
    private ConciliacionesService conciliacionesService;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(conciliacionesService, "uriSeguimientoOpicsDali", "http://localhost:8080/conciliaciones/opics_dali");
        ReflectionTestUtils.setField(conciliacionesService, "uriActivaProcesoConci", "http://localhost:8080/conciliaciones/proceso");
        ReflectionTestUtils.setField(conciliacionesService, "uriConciliacionesListas", "http://localhost:8080/conciliaciones/listas");
        ReflectionTestUtils.setField(conciliacionesService, "uriSeguimientoHtohDali", "http://localhost:8080/conciliaciones/htoh_dali");
        ReflectionTestUtils.setField(conciliacionesService, "uriConciliacionesManuales", "http://localhost:8080/conciliaciones/listas_manuales");
    }

    @Test
    @DisplayName(value = "Test -> Resultado consulta de las operaciones conciliadas H2h vs Dali.")
    public void getConciliacionesH2HDaliPageableTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class))).thenReturn(response);
            conciliacionesService.getConciliacionesH2HDaliPageable(new RequestConciliacionesDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/htoh_dali\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                ex.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Test -> Resultado consulta de las operaciones conciliadas Opics vs Dali.")
    public void conciliacionOpicsDaliTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            conciliacionesService.conciliacionOpicsDali(new RequestConciliacionesDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/opics_dali\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Test -> Resultado consulta conciliaciones.")
    public void consultaConciliacionesTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            conciliacionesService.consultaConciliaciones(new RequestConciListaDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/listas\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Test -> Resultado consulta conciliación manual.")
    public void consultaConciliacionesManualesTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            conciliacionesService.consultaConciliacionesManuales(new RequestConsultaConciDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/listas_manuales\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Test -> Resultado consulta conciliacion listas correcta.")
    public void conciliacionesManualesListasTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            conciliacionesService.conciliacionesManualesListas(new RequestConsultaConciDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/listas_manuales/listas\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Test -> Resultado activación de proceso.")
    public void activaProcesoTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            conciliacionesService.activaProceso(new RequestProcesoConciDTO());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/proceso\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

}
