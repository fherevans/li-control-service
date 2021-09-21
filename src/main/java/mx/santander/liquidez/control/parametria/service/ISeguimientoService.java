package mx.santander.liquidez.control.parametria.service;

import java.util.List;

import mx.santander.liquidez.control.parametria.model.Detalle;
import mx.santander.liquidez.control.parametria.model.Totales;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ISeguimientoService.java <br>
 * <b>Description:</b> API para seguimiento.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 9 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Service.
 *
 */
public interface ISeguimientoService {

    /**
     * Metodo para obtener valores de seguimiento.
     * 
     * @return Valores opics, dali y diferencias-.
     */
    List<Totales> obtenerTotales();

    /**
     * Metodo para obtener detalle.
     * 
     * @return Detalle opic, dali, diferencias y detalles.
     */
    List<Detalle> obtenerDetalle();
    
}
