package mx.santander.liquidez.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
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

import mx.santander.liquidez.control.reporte.model.RequestReporteDTO;
import mx.santander.liquidez.control.reporte.model.RequestReporteEspecialesDTO;
import mx.santander.liquidez.control.reporte.model.ResponseReporteDTO;
import mx.santander.liquidez.control.reporte.service.ReporteService;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ReportesServiceTest.java <br>
 * <b>Description:</b> Clase Test. Clase que se encarga de generar las pruebas
 * unitarias del MS de reporte
 *
 * @author FSW Praxis Victor Basurto Alonso
 * @company Praxis
 * @created 22 Mar. 2021
 * @since JDK:1.8
 *
 * @version Control de cambios:
 * @version 1.0 23 Mar. 2021 FSW Lacertus VBA
 *
 * @category Test
 *
 */

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ReportesServiceTest.class)
@ContextConfiguration(classes = { ReportesServiceTest.class })
@Ignore
public class ReportesServiceTest {

    public static final String VALUE_T = "T";
    @InjectMocks
    private ReporteService reporteService;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(reporteService, "uriReporte", "http://localhost:8080/general/reporte");
        ReflectionTestUtils.setField(reporteService, "uriReporteEspecial", "http://localhost:8080/general/reporte?id=1");
    }

    @Test
    public void generaReportGenericTest() throws ServiceException {
        try {
            ResponseEntity<Object> response = new ResponseEntity<Object>(org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(Object.class), anyString())).thenReturn(response);
            reporteService.generaReporte(generateRequestReportGeneric());
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/proceso\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }

    @Test
    public void generaReportPronosticoTest() throws ServiceException {
        try {
            ResponseEntity<ResponseReporteDTO> response = new ResponseEntity<ResponseReporteDTO>(
                    org.springframework.http.HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST),
                    Mockito.any(HttpEntity.class), Mockito.eq(ResponseReporteDTO.class), anyString()))
                    .thenReturn(response);
            reporteService.generaReportePronostico(new RequestReporteEspecialesDTO(), 1L);
        } catch (ResourceAccessException ex) {
            assertEquals("I/O error on POST request for \"http://localhost:8080/conciliaciones/proceso\": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect",
                    ex.getMessage());
        }
    }
    
    @SuppressWarnings("serial")
    private RequestReporteDTO generateRequestReportGeneric() {
        RequestReporteDTO requestReporteDTO = new RequestReporteDTO();
        requestReporteDTO.setValue(VALUE_T);
        requestReporteDTO.setColumnas(new LinkedList<String[]>() {{add(new String[] { "Banco", "Cve Banco", "C/V", "Tip. Movto", "Importe", "Parcialidades" });}});
        requestReporteDTO.setFilas(new LinkedList<String[]>() {{add(new String[] { "CBSCOTIA", "010070810", "C" });add(new String[] { "CBSCOTIA", "010070810", "C" });}});
        requestReporteDTO.setIdentificador(1);
        requestReporteDTO.setImagen(new byte[1]);
        return requestReporteDTO;
    }

}
