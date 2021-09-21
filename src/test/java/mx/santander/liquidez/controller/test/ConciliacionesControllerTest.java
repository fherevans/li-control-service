package mx.santander.liquidez.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mx.santander.liquidez.control.conciliacion.indeval.controller.ConciliacionesController;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciListaDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConciliacionesDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestConsultaConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.model.RequestProcesoConciDTO;
import mx.santander.liquidez.control.conciliacion.indeval.service.IConciliacionesService;
import mx.santander.liquidez.control.parametria.model.OrderByDTO;
import mx.santander.liquidez.control.parametria.model.PaginacionDTO;
import  mx.santander.liquidez.control.util.Error;
import mx.santander.liquidez.control.util.ErrorUtil;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ConciliacionesControllerTest.java <br>
 * <b>Description:</b> Clase Test. Clase que se encarga de generar las pruebas
 * unitarias del MS de conciliacion
 *
 * @author FSW Praxis Victor Basurto Alonso
 * @company Praxis
 * @created 22 Mar. 2021
 * @since JDK:1.8
 *
 * @version Control de cambios:
 * @version 1.0 22 Mar. 2021 FSW Lacertus VBA
 *
 * @category Test
 *
 */

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ConciliacionesControllerTest.class)
@ContextConfiguration(classes = { ConciliacionesControllerTest.class })
public class ConciliacionesControllerTest {

    @InjectMocks
    private ConciliacionesController conciliacionesController;
    @Mock
    private IConciliacionesService iConciliacionesService;
    private static final String DATE = "22-03-2021";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultaConciliacionesListTest() throws ServiceException {
        Mockito.when(iConciliacionesService.consultaConciliaciones(generateRequestConciList())).thenThrow(new ServiceException("Error", new NullPointerException()));
        ResponseEntity<Object> responseEntity = conciliacionesController.consultaConciliaciones(generateRequestConciList());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
    }

    @Test
    public void consultaConciliacionesTest() throws ServiceException {
        Mockito.when(iConciliacionesService.consultaConciliaciones(generateRequestConciList())).thenThrow(new ServiceException("Error", new NullPointerException()));
        ResponseEntity<Object> responseEntity = conciliacionesController.consultaConciliaciones(generateRequestConci());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    @Test
    public void conciliacionesManualesListasTest() throws ServiceException {
        ResponseEntity<Object> responseEntity = conciliacionesController.conciliacionesManualesListas(generateRequestConci());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void activaProcesoTest() throws ServiceException {
        ResponseEntity<Object> responseEntity = conciliacionesController.activaProceso(generateRequestConciPro());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    @Test
    public void getConciliacionesH2HDaliPageableTest() throws ServiceException {
        ResponseEntity<Object> responseEntity = conciliacionesController.getConciliacionesH2HDaliPageable(new RequestConciliacionesDTO());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    @Test
    public void getDetalleOpicsDaliTest() throws ServiceException {
        ResponseEntity<Object> responseEntity = conciliacionesController.getDetalleOpicsDali(new RequestConciliacionesDTO());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    @Test
    public void errorUtilTest() throws ServiceException {
        Mockito.when(ErrorUtil.obtenerUsando(new ServiceException("Error"))).thenReturn(new Error());
    }
    
    /**
     * Totales conciliaciones manuales test.
     * Metodo que realiza el test correcto
     * de la consulta de totales de la conciliacion manual
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesManualesTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConsultaConciDTO requestConsultaConciDTO = this.seteoRequestConsulta();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        /* llamada al service */
        Mockito.when(iConciliacionesService.obtenerTotalesGeneralesConciManual(requestConsultaConciDTO)).thenReturn(new Object());

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliacionesManuales(requestConsultaConciDTO);

        /* Validamos que regrese 200 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    /**
     * Totales conciliaciones manuales exception test.
     * Metodo que realiza el test de exception de la consulta
     * de totales de la conciliacion manual
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesManualesExceptionTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConsultaConciDTO requestConsultaConciDTO = this.seteoRequestConsulta();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    
        /* llamada al service */
        Mockito.when(iConciliacionesService.obtenerTotalesGeneralesConciManual(requestConsultaConciDTO)).thenThrow(new ServiceException("Error", new NullPointerException()));

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliacionesManuales(requestConsultaConciDTO);

        /* Validamos que regrese 500 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
    }
    
    /**
     * Totales conciliaciones test.
     * Metodo que realiza el test correcto 
     * de los totales de conciliacion
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConciliacionesDTO requestConciliacionesDTO = new RequestConciliacionesDTO();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        /* llamada al service */
        Mockito.when(iConciliacionesService.totalesConciliaciones(requestConciliacionesDTO)).thenReturn(new Object());

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliaciones(requestConciliacionesDTO);

        /* Validamos que regrese 200 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    /**
     * Totales conciliaciones exception test.
     * Metodo que realiza el test de exception de
     * la consulta de subtotales de conciliaciones
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesExceptionTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConciliacionesDTO requestConciliacionesDTO = new RequestConciliacionesDTO();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    
        /* llamada al service */
        Mockito.when(iConciliacionesService.totalesConciliaciones(requestConciliacionesDTO)).thenThrow(new ServiceException("Error", new NullPointerException()));

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliaciones(requestConciliacionesDTO);

        /* Validamos que regrese 500 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
    }
    
    /**
     * Totales conciliaciones Paginacion test.
     * Metodo que realiza el test correcto 
     * de los totales de conciliacion paginado
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionPaginacionTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConciliacionesDTO requestConciliacionesDTO = new RequestConciliacionesDTO();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        /* llamada al service */
        Mockito.when(iConciliacionesService.totalesConciliacionesPaginacion(requestConciliacionesDTO)).thenReturn(new Object());

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliacionesPaginacion(requestConciliacionesDTO);

        /* Validamos que regrese 200 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    
    /**
     * Totales conciliaciones paginacion exception test.
     * Metodo que realiza el test de exception de
     * la consulta de subtotales de conciliaciones paginado
     * @throws ServiceException the service exception
     */
    @Test
    public void totalesConciliacionesPaginacionExceptionTest() throws ServiceException {
        /* Iniciamos bean */
        RequestConciliacionesDTO requestConciliacionesDTO = new RequestConciliacionesDTO();

        /* Clases para lanzar la peticion opcionales */
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    
        /* llamada al service */
        Mockito.when(iConciliacionesService.totalesConciliacionesPaginacion(requestConciliacionesDTO)).thenThrow(new ServiceException("Error", new NullPointerException()));

        /* Ejecutamos pruebas */
        ResponseEntity<Object> responseEntity = conciliacionesController.totalesConciliacionesPaginacion(requestConciliacionesDTO);

        /* Validamos que regrese 500 */
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
    }
    
    private RequestConciListaDTO generateRequestConciList() {
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

    private RequestConsultaConciDTO generateRequestConci() {
        RequestConsultaConciDTO request = new RequestConsultaConciDTO();
        request.setEntradaSalida("E");
        request.setFecha("22-03-2021");
        request.setOrderBy(new OrderByDTO());
        request.setPaginacion(new PaginacionDTO());
        request.setRealProgramada("R");
        request.setSistema("SPEI");
        return request;
    }
    
    private RequestProcesoConciDTO generateRequestConciPro() {
        RequestProcesoConciDTO dto = new RequestProcesoConciDTO();
        dto.setFecha(DATE);
        dto.setSistema("SPEI");
        return dto;
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
}
