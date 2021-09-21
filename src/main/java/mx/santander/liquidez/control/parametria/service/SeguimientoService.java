package mx.santander.liquidez.control.parametria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.santander.liquidez.control.parametria.model.Detalle;
import mx.santander.liquidez.control.parametria.model.Totales;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SeguimientoService.java <br>
 * <b>Description:</b> cliente con parametria.
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
@Service
public class SeguimientoService implements ISeguimientoService {

    /**
     * Uri para seguimiento.
     */
    @Value("${control.endpoint.seguimiento}")
    private String uriSeguimientoValores;

    /**
     * Rest template para crear cliente de servicio.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Metodo para obtener los totales de seguimiento.
     */
    @Override
    public List<Totales> obtenerTotales() {
        return restTemplate.getForObject(uriSeguimientoValores + "/totales", List.class);
    }

    /**
     * Metodo para obtener detalle de seguimiento.
     */
    @Override
    public List<Detalle> obtenerDetalle() {
        return restTemplate.getForObject(uriSeguimientoValores + "/detalles", List.class);
    }
    
}
