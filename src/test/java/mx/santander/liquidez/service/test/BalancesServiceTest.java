package mx.santander.liquidez.service.test;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import mx.santander.liquidez.control.balance.repository.IBalanceRepository;
import mx.santander.liquidez.control.balance.service.BalanceService;
import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.procesamiento.balance.model.BalanceDTO;
import mx.santander.liquidez.procesamiento.balance.model.RegistrosDTO;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> BalancesServiceTest.java <br>
 * <b>Description:</b> Clase Test.
 * Clase que se encarga de generar las pruebas unitarias
 * para el MS de control para la clase BalancesService
 *
 * @author Christian Ivan Miranda Paulin
 * @version Control de cambios:
 * @version 1.0, 19 may. 2021 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  19 may. 2021
 * @category Test
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class BalancesServiceTest {

    /**
     * Instancia balanceService de tipo @InjectMocks
     */
    @InjectMocks
    private BalanceService balanceService;
    
    /**
     * Instancia balanceRepository de tipo @Mock
     */
    @Mock
    private IBalanceRepository balanceRepository;
    
    /**
     * setUp para mockito
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    /**
     * Consultar fechas order by test.
     * Metodo de prueba unitaria del ajuste del order by
     * al retorno y consulta de las fechas de balance
     * @throws ServiceException the service exception
     */
    @Test
    public void consultarFechasOrderByTest() throws ServiceException {
        List<BalanceDTO> listaBalances = this.generateListBalance("19-05-2021", "18-06-2021", "19-06-2021");
        Mockito.when(balanceRepository.findAll()).thenReturn(listaBalances);
        assertNotNull(balanceService.consultarFechas());
    }
    
    /**
     * Consultar fechas order by fecha format fail test.
     * Metodo test con una fecha con formato incorrecto y 
     * procesa las demas fechas
     * @throws ServiceException the service exception
     */
    @Test
    public void consultarFechasOrderByFechaFormatFailTest() throws ServiceException {
        List<BalanceDTO> listaBalances = this.generateListBalance("19-05-2021", "18/06/2021", "19-06-2021");
        Mockito.when(balanceRepository.findAll()).thenReturn(listaBalances);
        assertNotNull(balanceService.consultarFechas());
    }
    
    /**
     * Consultar fechas order by fecha null test.
     * Metodo que realiza la consulta de las fechas
     * liquidacion de los balances si obtiene una null
     * no la agrega
     * @throws ServiceException the service exception
     */
    @Test
    public void consultarFechasOrderByFechaNullTest() throws ServiceException {
        List<BalanceDTO> listaBalances = this.generateListBalance("19-05-2021", null, "19-06-2021");
        Mockito.when(balanceRepository.findAll()).thenReturn(listaBalances);
        assertNotNull(balanceService.consultarFechas());
    }
    
    /**
     * Consultar fechas order by fecha iguales test.
     * Metodo que realiza la validacion 
     * de las fechas que son iguales, para validar que solo regresa
     * un registro
     * @throws ServiceException the service exception
     */
    @Test
    public void consultarFechasOrderByFechaIgualesTest() throws ServiceException {
        List<BalanceDTO> listaBalances = this.generateListBalance("19-05-2021", "19-05-2021", "19-05-2021");
        Mockito.when(balanceRepository.findAll()).thenReturn(listaBalances);
        assertNotNull(balanceService.consultarFechas());
    }
    
    /**
     * Generate list balance.
     * Metodo que se encarga
     * de generar una lista de objetos dummy del
     * DTO de balances
     * @param fecha valor dummy de fecha
     * @param fechaDos valor dummy de fecha
     * @param fechaTres valor dummy de fecha
     * @return regresa la lista dummy
     */
    private List<BalanceDTO> generateListBalance( String fecha,  String fechaDos,  String fechaTres) {
        List<BalanceDTO> list = new ArrayList<>();
        BalanceDTO dto = new BalanceDTO();
        dto.setDivisa("MXN");
        dto.setFechaLiquidacion(fecha);
        dto.setId(1L);
        dto.setIdDivisa(6);
        dto.setIdSistema(5);
        dto.setRegistros(new RegistrosDTO());
        dto.setSistema("SPEI");
        dto.setTiempoRegistro(new Date());
        list.add(dto);
        
        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.setDivisa("MXN");
        balanceDTO.setFechaLiquidacion(fechaDos);
        balanceDTO.setId(2L);
        balanceDTO.setIdDivisa(6);
        balanceDTO.setIdSistema(2);
        balanceDTO.setRegistros(new RegistrosDTO());
        balanceDTO.setSistema("DALI");
        balanceDTO.setTiempoRegistro(new Date());
        list.add(balanceDTO);
        
        BalanceDTO balanceDTO1 = new BalanceDTO();
        balanceDTO1.setDivisa("MXN");
        balanceDTO1.setFechaLiquidacion(fechaTres);
        balanceDTO1.setId(2L);
        balanceDTO1.setIdDivisa(6);
        balanceDTO1.setIdSistema(2);
        balanceDTO1.setRegistros(new RegistrosDTO());
        balanceDTO1.setSistema("DALI");
        balanceDTO1.setTiempoRegistro(new Date());
        list.add(balanceDTO1);
        
        return list;
    }
    
    
}
