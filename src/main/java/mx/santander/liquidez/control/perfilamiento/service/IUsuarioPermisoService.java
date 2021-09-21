package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermiso;
import mx.santander.liquidez.control.perfilamiento.model.UsuarioPermisoPK;



/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> IUsuarioPermisoService.java
* <br><b>Description:</b> Usuario permiso service.
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
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
public interface IUsuarioPermisoService {
    
    /**
     * Crea un nuevo permiso para un usuario.
     * 
     * @param userPerm object con atributos para insertar un permiso de usuario.
     */
    void createUserPerm(UsuarioPermiso userPerm);

    /**
     * Regresa todos los permisos asignados para usuarios.
     * 
     * @return list de permisos.
     */
    List<UsuarioPermiso> getAllUserPerm();
    
    /**
     * Regresa todos los permisos asignados a un usuario.
     * @param idUser filtro para obtener permisos.
     * @return list de permisos asignados a un usuario.
     */
    List<UsuarioPermiso> getAllUserPermByIdUser(String idUser);

    /**
     * Elimina un permiso asignado a un usuario.
     * 
     * @param userPermId para eliminar permiso de usuario.
     */
    void deleteUserPerm(UsuarioPermisoPK userPermId);

    /**
     * Actualiza un permiso de un usuario.
     * 
     * @param userPerm datos para actualizar permiso de usuario
     */
    void updateUserPerm(UsuarioPermiso userPerm);

}
