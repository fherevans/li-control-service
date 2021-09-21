package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Rol;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IRolService.java <br>
 * <b>Description:</b> Roles service.
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
public interface IRolService {

    /**
     * Crea un nuevo rol.
     * 
     * @param rol datos para crear un nuevo rol.
     * @throws ServiceException service exception.
     * @return rol creado.
     */
    Rol createRol(Rol rol) throws ServiceException;

    /**
     * Regresa una lista con todos los roles.
     * 
     * @param nombre atributo como filtro.
     * @param pagina atributo como filtro.
     * @return List de roles
     */
    List<Rol> getAllRol(String nombre, String pagina);

    /**
     * Elimina un rol por su Id.
     *
     * @param id de rol a eliminar.
     * @param idUsuario the id usuario
     * @throws ServiceException service exception.
     */
    void deleteRol(Long id, String idUsuario) throws ServiceException;

    /**
     * Actualiza un rol.
     * 
     * @param rol a actualizar.
     * @return Rol actualizado.
     * @throws ServiceException service exception.
     */
    Rol updateRol(Rol rol) throws ServiceException;

    /**
     * Busca rol por id.
     * 
     * @param idRol id de rol.
     * @return Rol encontrado por id.
     */
    Rol findByIdRol(Long idRol);


}
