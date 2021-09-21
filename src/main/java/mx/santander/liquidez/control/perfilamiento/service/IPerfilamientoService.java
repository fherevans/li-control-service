package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.response.model.PerfilamientoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.PermisoResponse;
import mx.santander.liquidez.control.perfilamiento.response.model.RolResponse;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IPerfilamientoService.java <br>
 * <b>Description:</b> IPerfilamientoService.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 6 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
public interface IPerfilamientoService {


    /**
     * Metodo para obtener datos de perfilamiento de un usuario por su Id.
     * 
     * @param idUser id de usuario de quien se quiere obtener la informacion.
     * @throws ServiceException service exception.
     * @return perfilamientoResponse con datos de usuario y lista de permisos y
     *         roles asignados a usuario.
     */
    PerfilamientoResponse getPerfilamientoByUserId(String idUser) throws ServiceException;

    /**
     * Metodo para obtener permisos no asignados a una pagina.
     * 
     * @param idPage id de pagina.
     * @return List con los permisos no asignados a una pagina.
     */
    List<PermisoResponse> getNombrePermisosNoAsignadosPagina(Long idPage);

    /**
     * Metodo para obtener todos los permisos no asignados a un usuario.
     * 
     * @param idUsuario id de usuario para buscar sus permisos no asignados.
     * @return List de permisos no asignados a un usuario.
     */
    List<PermisoResponse> permisosNoAsignadosUsuario(String idUsuario);

    /**
     * Metodo para obtener todos los roles no asignados a un usuario.
     * 
     * @param idUsuario id de usuario para realizar el filtro.
     * @return List de roles no asignados al usuario.
     */
    List<RolResponse> rolesNoAsignadosUsuario(String idUsuario);

    /**
     * metodo para obtener permisos asignados a una pagina.
     * 
     * @param idPage id de pagina.
     * @return List para obtener permisos por pagina.
     */
    List<PermisoResponse> getPermisosPagina(Long idPage);

}