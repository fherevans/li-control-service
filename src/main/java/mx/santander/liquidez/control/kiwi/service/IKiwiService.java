/**
 * 
 */
package mx.santander.liquidez.control.kiwi.service;

import java.util.List;

import mx.santander.liquidez.notificacion.kiwi.model.Kiwi;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiDTO;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> KiwiService.java
 * <br><b>Description:</b> Servicio para comunicarnos con la api de Ctrl-Monitoreo
 * para realizar el CRUD de Kiwi.
 *
 * @author  FSW Herwin Toral
 * @version Control de cambios:
 * @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral
 * Creacion de la clase
 * @since JDK1.8
 * @company Praxis
 * @created 5 sep 2019
 * @category @Service
 */
public interface IKiwiService {

    /**
     * Metodo para obtener kiwi por idKiwi.
     * 
     * @param id -  corresponde al idKiwi a consultar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link kiwi - el kiwi consultado}
     */
    Kiwi consultaKiwiById(long id, String audit);
    
    /**
     * Metodo para obtener los kiwis disponibles.
     * @param flagDia - bandera para consultar los kiwis del dia o dia + N
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link List<Kiwi>} corresponde a la lista de kiwis consultados
     */
    List<Kiwi> consultaKiwiAll(int flagDia, String audit);
    
    /**
     * Metodo para obtener los kiwis disponibles.
     *
     * @param idRol the id rol
     * @param flagDia - bandera para consultar los kiwis del dia o dia + N
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link List<Kiwi>} corresponde a la lista de kiwis consultados
     */
    List<KiwiDTO> consultaKiwiAll(Long idRol,  int flagDia, String audit);

    /**
     * Metodo para registrar un kiwi.
     * 
     * @param kiwi - el objeto kiwi a registrar
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link KiwiDTO} - el kiwi registrado en el sistema
     */
    KiwiDTO registrarKiwi(KiwiDTO kiwi, String audit);
    
    /**
     * Metodo para actualizar informacion de los kiwi.
     *
     * @param kiwi - objeto kiwi con nuevos datos a modificar.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return {@link KiwiDTO} Objeto actualizado en sistema
     */
    KiwiDTO actualizarKiwi(KiwiDTO kiwi, String audit);
    
    /**
     * Metodo para eliminar un kiwi en el sistema.
     *
     * @param id -  idKiwi que fue eliminado
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return confirmacion del kiwi eliminado
     */
    String eliminarKiwi(long id, String audit);
    
}
