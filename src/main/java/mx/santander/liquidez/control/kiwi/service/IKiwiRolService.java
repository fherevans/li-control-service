package mx.santander.liquidez.control.kiwi.service;

import java.util.List;

import mx.santander.liquidez.notificacion.kiwi.model.Kiwi;
import mx.santander.liquidez.notificacion.kiwi.model.KiwiRol;
import mx.santander.liquidez.request.model.KiwiRolRequest;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> KiwiRolService.java
* <br><b>Description:</b> Crear registros Y eliminar relaciones de roles asociados
* a un kiwi.
*
* @author  FSW Herwin Toral
* @company Praxis
* @created 5 sep 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 5 sep 2019 FSW Praxis Nombre del autor: Herwin Toral
* Creacion de la clase
*
* @category @Service
 */
public interface IKiwiRolService {


    /**
     * metodo para obtener la lista de kiwis asignados a un rol.
     * 
     * @param idRol id de rol.
     * @return lista de kiwis asignados a un rol.
     * @param flagDia - flagDia para sontular los kiwis si son dia o dia + 1
     */
    List<Kiwi> obtenerKiwiIdRol(Long idRol, int flagDia);

    /**
     * API para obtener kiwis no asignados a un rol.
     * 
     * @param idRol id de rol.
     * @param flagDia - flagDia para sontular los kiwis si son dia o dia + 1
     * @return Kiwis no asignados a un rol.
     */
    List<Kiwi> obtenerKiwisNoAsignadosIdRol(Long idRol, int flagDia);
    
    /**
     * Metodo para eliminar una relacion de kiwi rol.
     * @param kiwiRolRequest kiwi rol request.
     */
    void eliminarKiwiIdRol(KiwiRolRequest kiwiRolRequest);

    /**
     * API para crear un nuevo kiwi rol.
     * 
     * @param kiwiRolRequest kiwi rol request.
     * @return kiwiRol creado.
     */
    KiwiRol asignarKiwiRol(KiwiRolRequest kiwiRolRequest);

}