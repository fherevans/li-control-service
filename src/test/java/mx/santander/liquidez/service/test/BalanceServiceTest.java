package mx.santander.liquidez.service.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.bitacora.balance.dto.model.BitacoraSistemaDTO;
import mx.santander.liquidez.control.balance.repository.IBalanceRepository;
import mx.santander.liquidez.control.balance.service.BalanceBitacoraService;
import mx.santander.liquidez.control.balance.service.IBalanceService;
import mx.santander.liquidez.control.util.CodigoError;
import mx.santander.liquidez.control.util.DataAccessException;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;
import mx.santander.liquidez.procesamiento.balance.model.RegistrosDTO;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-reporte-service <br>
 * <b>Class:</b> ReportesServiceTest.java <br>
 * <b>Description:</b> Clase Test. Clase que se encarga de generar las pruebas
 * unitarias para el MS de balance
 *
 * @author FSW Praxis Victor Basurto Alonso
 * @company Praxis
 * @created 12 Mar. 2021
 * @since JDK:1.8
 *
 * @version Control de cambios:
 * @version 1.0 12 Mar. 2021 FSW Lacertus VBA
 *
 * @category Test
 *
 */

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = BalanceServiceTest.class)
@ContextConfiguration(classes = { BalanceServiceTest.class })
public class BalanceServiceTest {

    @InjectMocks
    private BalanceBitacoraService balanceBitacoraService;
    private static final String DATE = "22-03-2021";
    @Mock
    private IBalanceRepository balanceRepository;
    @Mock
    private IBalanceService balanceService;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(balanceRepository.findAllByFechaLiquidacion(Mockito.any())).thenReturn(generateListBalance());
        Mockito.when(balanceRepository.findAll()).thenReturn(generateListBalance());
    }

    @SuppressWarnings("rawtypes")
    @Test
    @DisplayName(value = "Test -> Resultado de la consulta de balance por fecha.")
    public void consultaByFechaTest() throws ServiceException {
        ResponseEntity<List> response = new ResponseEntity<List>(org.springframework.http.HttpStatus.ACCEPTED);
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
                Mockito.any(HttpEntity.class), Mockito.eq(List.class), anyString())).thenReturn(response);
        balanceBitacoraService.consultaByFecha(DATE, "user");
    }

    @Test
    @DisplayName(value = "Test -> Resultado de la consulta de los últimos balances de redis.")
    public void obtenerUltimosTest() throws ServiceException {
        balanceService.obtenerUltimos(DATE);
    }

    @Test
    @DisplayName(value = "Test -> Resultado del envío de una lista de balance.")
    public void enviarTest() throws ServiceException {
        balanceService.enviar(generateListBalance());
    }

    @Test
    @DisplayName(value = "Test -> Resultado del envío de un balance.")
    public void enviarOneBalanceTest() throws ServiceException, DataAccessException {
        balanceService.enviar(generateListBalance().get(0), DATE);
    }

    @Test
    @DisplayName(value = "Test -> Resultado de la consulta del balance.")
    public void consultarFechasTest() throws ServiceException {
        Mockito.when(balanceService.consultarFechas()).thenReturn(getBalanceByFecha());
    }

    @Test
    @DisplayName(value = "Test -> Resultado del envío de balance en cache de redis.")
    public void enviarTodosTest() throws ServiceException {
        balanceService.enviarTodos();
    }

    private String[] getBalanceByFecha() {
        return new String[] { "Balance 1", "Balance 2" };
    }

    private List<BalanceDTO> generateListBalance() {
        List<BalanceDTO> list = new ArrayList<>();
        BalanceDTO dto = new BalanceDTO();
        dto.setDivisa("MXN");
        dto.setFechaLiquidacion(DATE);
        dto.setId(1L);
        dto.setIdDivisa(2);
        dto.setIdSistema(3);
        dto.setRegistros(new RegistrosDTO());
        dto.setSistema("SPEI");
        dto.setTiempoRegistro(new Date());
        list.add(dto);
        return list;
    }

    /**
     * Consulta by fecha exception test. Metodo test para simular la exception
     * 
     * @throws ServiceException the service exception
     */
    @Test
    public void consultaByFechaExceptionTest() throws ServiceException {

        List<BitacoraSistemaDTO> lista = new ArrayList<BitacoraSistemaDTO>();

        BitacoraSistemaDTO bitacoraSistemaDTO = new BitacoraSistemaDTO();
        bitacoraSistemaDTO.setId(1L);

        lista.add(bitacoraSistemaDTO);

        @SuppressWarnings("rawtypes")
        ResponseEntity<List> response = new ResponseEntity<List>(lista, HttpStatus.ACCEPTED);

        /* Simula respuesta */
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
                Mockito.any(HttpEntity.class), Mockito.eq(List.class), Mockito.anyString())).thenReturn(response);

        /* Ejecucion Prueba */
        balanceBitacoraService.consultaByFecha("22-03-2021", "usuario");

        /* Simula respuesta */
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET),
                Mockito.any(HttpEntity.class), Mockito.eq(List.class), Mockito.anyString()))
                .thenThrow(Mockito.mock(RestClientException.class));

        /* restClientException */
        ServiceException restClientException = Assertions.assertThrows(ServiceException.class, () -> {
            balanceBitacoraService.consultaByFecha("22-03-2021", "usuario");
        });

        /* Valida prueba */
        assertTrue(restClientException.getCodigoError() == CodigoError.CLIENTE_REST);
    }
}
