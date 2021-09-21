package mx.santander.liquidez.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindingResult;

import mx.santander.liquidez.control.reporte.controller.ReportesController;
import mx.santander.liquidez.control.reporte.model.RequestReporteDTO;
import mx.santander.liquidez.control.reporte.model.ResponseReporteDTO;
import mx.santander.liquidez.control.reporte.service.IReporteService;
import mx.santander.liquidez.control.util.FieldErrorException;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ReportesControllerTest.java <br>
 * <b>Description:</b> Clase Test. Clase que se encarga de generar las pruebas
 * unitarias del MS de reporte
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
@WebMvcTest(value = ReportesControllerTest.class)
@ContextConfiguration(classes = { ReportesControllerTest.class })
public class ReportesControllerTest {

    public static final String VALUE_T = "T";
    @InjectMocks
    private ReportesController reportesController;
    @Mock
    private IReporteService iReporteService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generaReportGenericTest() throws ServiceException, FieldErrorException {
        RequestReporteDTO requestReportGeneric = this.generateRequestReportGeneric();
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        ResponseReporteDTO list = this.generateResponseReport();
        Mockito.when(iReporteService.generaReporte(requestReportGeneric)).thenReturn(list);
        ResponseEntity<ResponseReporteDTO> responseEntity = reportesController.generaReporte(requestReportGeneric, result);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
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

    private ResponseReporteDTO generateResponseReport() {
        ResponseReporteDTO response = new ResponseReporteDTO();
        response.setDataArchivo("FileExcelEncodeBase64");
        response.setMessage("Report generated successfully");
        return response;
    }

}
