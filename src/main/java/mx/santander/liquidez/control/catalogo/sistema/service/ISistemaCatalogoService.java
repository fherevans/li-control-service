/**
 * 
 */
package mx.santander.liquidez.control.catalogo.sistema.service;

import mx.santander.liquidez.control.parametria.model.Sistema;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> ISistemaCatalogoService.java
 * <br><b>Description:</b>
 * Es una interfaz de servicio para el catologo de sistemas. 
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Service Interface
 *
 */
public interface ISistemaCatalogoService {
    
    /**
     * Obtiene el catalogo completo de sistemas.
     * @return un arreglo de {@link Sistema}s
     * @throws ServiceException si un error ocurre durante el proceso
     */
    Sistema[] obtenerTodos() throws ServiceException;

}
