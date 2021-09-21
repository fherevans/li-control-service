package mx.santander.liquidez.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.service.ConciliacionesService;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ConciliacionServiceTest.java <br>
 * <b>Description:</b> Clase Test.
 * Clase que se encarga de generar las pruebas unitarias
 * para el MS de control para la clase ConciliacionService
 *
 * @author FSW Christian Ivan Miranda Paulin
 * @version Control de cambios:
 * @version 1.0, 30 mar. 2021 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  30 mar. 2021
 * @category Test
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class ConciliacionServiceTest {

    /**
     * Instancia conciliacionesService de tipo @InjectMocks
     */
    @InjectMocks
    private ConciliacionesService conciliacionesService;
    
    /**
     * Instancia restTemplate de tipo @Mock
     */
    @Mock
    private RestTemplate restTemplate;
    
    /**
     * setUp para mockito
     */
    @Before
    public void setUp() {         
        MockitoAnnotations.initMocks(this);
    }
    
    /**
     * Obtener totales generales conci manual test.
     * Metodo que realiza el test correcto 
     * de los totales de la conciliacion manual
     * @throws ServiceException the service exception
     */
    @Test
    public void obtenerTotalesGeneralesConciManualTest() throws ServiceException {
        ResponseEntity<Object> response = new ResponseEntity<Object>(new Object []{"39.00"}, HttpStatus.OK);
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any())).thenReturn(response);
        conciliacionesService.obtenerTotalesGeneralesConciManual(this.seteoRequestConsulta());
    }
    
    /**
     * Obtener totales generales conci manual exception test.
     * Metodo que se encargara de realizar el test con exception
     * de los totales de la conciliacione manual
     * @throws ServiceException the service exception
     */
    @Test
    public void obtenerTotalesGeneralesConciManualExceptionTest() throws ServiceException {
        
        /* Simula respuesta */
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any()))
                .thenThrow(Mockito.mock(RestClientException.class));

        /* restClientException */
        ServiceException restClientException = Assertions.assertThrows(ServiceException.class, () -> {
            conciliacionesService.obtenerTotalesGeneralesConciManual(this.seteoRequestConsulta());
        });

        /* Valida prueba */
        assertTrue(restClientException.getCodigoError() == CodigoError.CLIENTE_REST);
    }
    
    /**
     * Totales conciliaciones test.
     * Metodo que realiza el test correcto 
     * de la consulta de subtotales de las conciliaciones
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesTest() throws ServiceException {
        ResponseEntity<Object> response = new ResponseEntity<Object>(new Object []{"45.00"}, HttpStatus.OK);
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any())).thenReturn(response);
        conciliacionesService.totalesConciliaciones(this.generateRequestConci());
    }
    
    /**
     * Totales conciliaciones exception test.
     * Metodo que realiza el test de exception
     * de los subtotales de la conciliaciones
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesExceptionTest() throws ServiceException {
        
        /* Simula respuesta */
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any()))
                .thenThrow(Mockito.mock(RestClientException.class));

        /* restClientException */
        ServiceException restClientException = Assertions.assertThrows(ServiceException.class, () -> {
            conciliacionesService.totalesConciliaciones(this.generateRequestConci());
        });

        /* Valida prueba */
        assertTrue(restClientException.getCodigoError() == CodigoError.CLIENTE_REST);
    }
    
    /**
     * Totales conciliaciones paginacion test.
     * Metodo que realiza el test correcto Paginacion 
     * de la consulta de subtotales de las conciliaciones con Paginacion
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesPaginacionTest() throws ServiceException {
        ResponseEntity<Object> response = new ResponseEntity<Object>(new Object []{"45.00"}, HttpStatus.OK);
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any())).thenReturn(response);
        conciliacionesService.totalesConciliacionesPaginacion(this.generateRequestConci());
    }
    
    /**
     * Totales conciliaciones paginacion exception test.
     * Metodo que realiza el test de exception con paginacion
     * de los subtotales de la conciliaciones
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesPaginacionExceptionTest() throws ServiceException {
        
        /* Simula respuesta */
        Mockito.when(restTemplate.exchange(Matchers.anyString(), 
                Matchers.any(HttpMethod.class),
                Matchers.<HttpEntity<?>> any(), 
                Matchers.<Class<Object>> any()))
                .thenThrow(Mockito.mock(RestClientException.class));

        /* restClientException */
        ServiceException restClientException = Assertions.assertThrows(ServiceException.class, () -> {
            conciliacionesService.totalesConciliacionesPaginacion(this.generateRequestConci());
        });

        /* Valida prueba */
        assertTrue(restClientException.getCodigoError() == CodigoError.CLIENTE_REST);
    }
    
    /**
     * Seteo request consulta.
     * Metodo que realiza el seteo dummy
     * de los test de conciliacion manual
     * @return bean con la informacion manual dummy para los test
     */
    private RequestConsultaConciDTO seteoRequestConsulta() {
        RequestConsultaConciDTO requestConsultaConciDTO = new RequestConsultaConciDTO();
        requestConsultaConciDTO.setEntradaSalida("E");
        requestConsultaConciDTO.setFecha("30-03-2021");
        requestConsultaConciDTO.setRealProgramada("P");
        requestConsultaConciDTO.setSistema("DALI");
        return requestConsultaConciDTO;
    }
    
    /**
     * Generate request conci list.
     * Metodo que genera el seteo dummy del request de listas
     * @return the request conci lista DTO
     */
    public RequestConciListaDTO generateRequestConciList() {
        RequestConciListaDTO request = new RequestConciListaDTO();
        request.setConciliacion("C");
        request.setFechaValor("22-03-2021");
        request.setFolioInstContra(1);
        request.setFolioInstitucion(2);
        request.setIdInstContra(3);
        request.setIdInstitucion(4);
        request.setInconsistencias("I");
        request.setMercado("PB");
        return request;
    }
    
    /**
     * Generate request conci .
     * Metodo que genera el seteo dummy del request de los totales
     * de conciliacion
     * @return the request conci lista DTO
     */
    private RequestConciliacionesDTO generateRequestConci() {
        RequestConciliacionesDTO request = new RequestConciliacionesDTO();
        request.setConciliacion("C");
        request.setFechaValor("22-03-2021");
        request.setFolioInstContra(1);
        request.setFolioInstitucion(2);
        request.setIdInstContra(3);
        request.setIdInstitucion(4);
        request.setInconsistencias("I");
        request.setMercado("PB");
        request.setPage(1);
        request.setSize(10);
        return request;
    }
}
