package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.PaginaPermiso;
import mx.santander.liquidez.control.perfilamiento.model.PaginaPermisoPK;



/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> IPaginaPermisoService.java
* <br><b>Description:</b> Pagina permiso service.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 3 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 3 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Service.
*
*/
public interface IPaginaPermisoService {
    
    /**
     * creacion de un permiso para una pagina.
     * 
     * @param pagePerm con los valores necesarios para asignar un permiso a una
     *                 pagina.
     */
    void createPagePerm(PaginaPermiso pagePerm);

    /**
     * Regresa todos los permisos asignados a una pagina.
     * 
     * @return list de pagina de permisos.
     */
    List<PaginaPermiso> getAllPagePerm();

    /**
     * elimina un permiso de una pagina.
     * 
     * @param pagePermId para eliminar permiso asignado a pagina.
     */
    void deletePagePerm(PaginaPermisoPK pagePermId);

    /**
     * actualiza un permiso para una pagina.
     * 
     * @param pagePerm con nuevos valores.
     */
    void updatePagePerm(PaginaPermiso pagePerm);

    /**
     * Metodo para obtener paginas por IdPermiso.
     * 
     * @param idPerm para encontrar los permisos asignados a la pagina.
     * @return List de paginas asignadas a un permiso.
     */
    List<PaginaPermiso> findByIdPerm(Long idPerm);

    /**
     * Metodo para obtener permisos asignados a una pagina por id de pagina.
     * 
     * @param idPage id de pagina para encontrar permisos.
     * @return List de permisos asignados a una pagina
     */
    List<PaginaPermiso> findByIdPage(Long idPage);

}
