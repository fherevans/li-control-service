package mx.santander.liquidez.bitacora.balance.dto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> BitacoraSaldosDTO.java
* <br><b>Description:</b> Clase embebida en la entidad Saldos.
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 18 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category Entity
*
*/
@Embeddable
@Getter
@Setter
public class BitacoraSaldosDTO implements Serializable {

    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -5129329913473497201L;

    /**  Variable datosReales de tipo DatosReales. */    
    private List<DatosRealesDTO> datosReales = new ArrayList<DatosRealesDTO>();
    
    /**  Variable datosProgramados de tipo DatosProgramados. */    
    private List<DatosProgramadosDTO> datosProgramados = new ArrayList<DatosProgramadosDTO>();
}
