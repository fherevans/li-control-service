package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Usuario;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRol;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioRolPK;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IUsuarioRolService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 3 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 3 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 *
 * @category Service.
 *
 */
public interface IUsuarioRolService {

    /**
     * Crea un nuevo rol para un usuario.
     * 
     * @param userRol con atributos necesarios para asignar un rol a un usuario.
     */
    void createUserRol(UsuarioRol userRol);

    /**
     * Regresa los roles asignados a usuarios.
     * 
     * @return list de roles.
     */
    List<UsuarioRol> getAllUserRol();

    /**
     * Metodo para buscar roles asignados a un usuario por Id.
     * 
     * @param idUser para buscar roles asignados a un usuario.
     * @return list de roles asignados a un usuario.
     */
    List<UsuarioRol> findByIdUser(String idUser);

    /**
     * elimina un rola asignado a un usario.
     * 
     * @param userRolId de userRol a eliminar.
     */
    void deleteUserRol(UsuarioRolPK userRolId);

    /**
     * actualiza un rol asignado a un usario.
     * 
     * @param userRol con atributos nuevos para actualizar rol.
     */
    void updateUserRol(UsuarioRol userRol);

    /**
     * Obtiene lista de usuarios que tienen un rol asignado al idRol.
     * 
     * @param idRol id ROl para obtener lista de usuarios.
     * @return List de usuarios.
     */
    List<Usuario> getUsersByIdRol(Long idRol);

}
