package mx.santander.liquidez.control.conciliacion.indeval.model;

import java.io.Serializable;
import lombok.Data;
import mx.santander.liquidez.control.parametria.model.OrderByDTO;
import mx.santander.liquidez.control.parametria.model.PaginacionDTO;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-conciliacion-indeval-service<br>
 * <b>Class:</b> RequestConsultaConciDTO.java <br>
 * <b>Description:</b> Clase dto que trasnporta la informacion
 * de las consulta incial de conciliacion manual
 * @author Christian Ivan Miranda Paulin
 * @company Praxis
 * @created 09 mar. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 09 mar. 2021, Nombre del autor:IVPA
 * Creacion de clase
 *
 * @category DTO
 */
@Data
public class RequestConsultaConciDTO implements Serializable {

    /**
     * Version Serial
     */
    private static final long serialVersionUID = -2738689219634419263L;
    
    /**
     * Variable sistema de tipo Sting
     */
    private String sistema;
    
    /**
     * Variable fecha de tipo Sting
     */
    private String fecha;
    
    /**
     * Variable entradaSalida de tipo Sting
     */
    private String entradaSalida;
    
    /**
     * Variable realProgramada de tipo Sting
     */
    private String realProgramada;

    /**
     * Variable paginacion de tipo PaginacionDTO
     */
    private PaginacionDTO paginacion;
    
    /**
     * Variable orderBy de tipo OrderByDTO
     */
    private OrderByDTO orderBy;
}
