package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Permiso;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IPermisoService.java <br>
 * <b>Description:</b> Interface para permiso service.
 *
 * @author Eduardo Castillo Mendoza
 * @version Control de cambios:
 * @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * @since JDK1.8
 * @company Praxis
 * @created 2 sep. 2019
 * @category Incluir si la clase es un Modelo, Service, etc.
 */
public interface IPermisoService {

    /**
     * metodo para crear un permiso.
     * 
     * @param permiso con los atributos necesarios para crear un permiso nuevo.
     * @throws ServiceException service exception.
     * @return permiso creado.
     */
    Permiso createPermiso(Permiso permiso) throws ServiceException;

    /**
     * Regresa los permisos del catalogo, si no pasa parametro de nombre hace
     * regresa permisos si trae algun valor en nombre regresa el permiso con el
     * nombre.
     * 
     * @param nombre de permiso.
     * @return list de catalogo de permisos.
     */
    List<Permiso> getAllPermisos(String nombre);

    /**
     * Elimina un permiso por id.
     *
     * @param idPermiso para eliminar permiso.
     * @param idUsuario the id usuario
     * @return cantidad de permisos eliminados.
     */
    Long deletePermiso(Long idPermiso, String idUsuario);

    /**
     * Actualiza un permiso.
     * 
     * @param permiso con nuevos atributos.
     * @return permiso actualizado.
     * 
     * @throws ServiceException service exception.
     */
    Permiso updatePermiso(Permiso permiso) throws ServiceException;

    /**
     * Busca permiso por id de permiso.
     * 
     * @param idPerm para buscar permiso.
     * @return permiso encontrado de id.
     */
    Permiso getPermisoByIdPerm(Long idPerm);

}
