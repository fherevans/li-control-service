package mx.santander.liquidez.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.santander.liquidez.bitacora.balance.dto.model.BitacoraSistemaDTO;
import mx.santander.liquidez.bitacora.balance.dto.model.DatosProgramadosDTO;
import mx.santander.liquidez.control.balance.controller.BalanceBitacoraController;
import mx.santander.liquidez.control.balance.controller.BalanceBrokerController;
import mx.santander.liquidez.control.balance.service.IBalanceBitacoraService;
import mx.santander.liquidez.control.balance.service.IBalanceService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;
import mx.santander.liquidez.procesamiento.balance.model.RegistrosDTO;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> BalanceBitacoraControllerTest.java <br>
 * <b>Description:</b> Clase Test. Clase que se encarga de generar las pruebas
 * unitarias del MS de balance
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
@WebMvcTest(value = BalanceControllerTest.class)
@ContextConfiguration(classes = { BalanceControllerTest.class })
public class BalanceControllerTest {

    @Mock
    private MockHttpServletRequest request = new MockHttpServletRequest("GET", "/bitacoras/balances");
    private static final String URL = "/bitacoras/balances/22-03-2021";
    @InjectMocks
    private BalanceBitacoraController balanceBitacoraController;
    @InjectMocks
    private BalanceBrokerController balanceBrokerController;
    @Mock
    private IBalanceBitacoraService iBalanceBitacoraService;
    private static final String DATE = "22-03-2021";
    private static final String UTF_8 = "utf-8";
    private static final String AUDIT = "audit";
    @Mock
    private IBalanceService balanceService;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(balanceBitacoraController).build();
    }

    @Test
    public void consultaByFechaTest() throws ServiceException {
        request.addHeader(AUDIT, AUDIT);
        ResponseEntity<List<BitacoraSistemaDTO>> responseEntity = balanceBitacoraController.consultaByFecha(DATE,
                request);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void consultaByFechaMVCTest() throws Exception {
        Mockito.when(iBalanceBitacoraService.consultaByFecha(DATE, AUDIT)).thenReturn(generateResponseBitacoraBalance());
        request.addHeader(AUDIT, AUDIT);
        MvcResult mvcResult = mockMvc.perform(get(URL).param(AUDIT, AUDIT).contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(UTF_8).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    
    @Test
    public void subscribeTest() throws ServiceException {
        List<BalanceDTO> responseEntity = balanceBrokerController.subscribe(DATE);
        assertThat(Objects.nonNull(responseEntity));
    }
    
    @Test
    public void recibeTest() throws ServiceException {
        balanceBrokerController.recibe(DATE, generateListBalance().get(0));
    }
    
    @Test
    public void consultarFechasTest() throws ServiceException {
        ResponseEntity<Object> responseEntity = balanceBrokerController.consultarFechas();
        assertThat(Objects.nonNull(responseEntity));
    }

    @Test
    public void subscribeMVCTest() throws Exception {
        Mockito.when(balanceService.obtenerUltimos(DATE)).thenReturn(generateListBalance());
        MvcResult mvcResult = mockMvc.perform(get(URL).param(DATE, DATE)
                .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding(UTF_8)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        assertThat(Objects.nonNull(mvcResult));
    }

    private List<BalanceDTO> generateListBalance() {
        List<BalanceDTO> list = new ArrayList<>();
        BalanceDTO dto = new BalanceDTO();
        dto.setDivisa("MXN");
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

    private List<BitacoraSistemaDTO> generateResponseBitacoraBalance() {
        List<BitacoraSistemaDTO> list = new ArrayList<>();
        BitacoraSistemaDTO dto = new BitacoraSistemaDTO();
        dto.setDatosProgramados(new ArrayList<DatosProgramadosDTO>());
        list.add(dto);
        return list;
    }

}
