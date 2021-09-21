package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Usuario;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IUsuarioService.java <br>
 * <b>Description:</b> Reemplazar con una descripcion acorde a la funcionalidad
 * de la clase.
 *
 * @author Eduardo Castillo Mendoza
 * @version Control de cambios:
 * @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * @since JDK1.8
 * @company Praxis
 * @created 2 sep. 2019
 * @category Service.
 */
public interface IUsuarioService {

    /**
     * metodo para crear un nuevo usuario.
     * 
     * @param usuario con los atributos necesarios para crear un nuevo usuario.
     * 
     * @return usuario creado.
     */
    Usuario crearUsuario(Usuario usuario);

    /**
     * Regresa todos los usuarios del catalogo.
     * 
     * @param nombre parametro como filtro de busqueda.
     * @param apePat parametro como filtro de busqueda.
     * @param apeMat parametro como filtro de busqueda.
     * @param correo parametro como filtro de busqueda.
     * @return list de catalogo de usuarios.
     */
    List<Usuario> getAllUsuarios(String nombre, String apePat, String apeMat, String correo);

    /**
     * Elimina un usuario por id.
     *
     * @param idUsuario para eliminar usuario.
     * @param idUsuari the id usuari
     * @return id de usuario eliminado.
     */
    String deleteUsuario(String idUsuario, String idUsuari);

    /**
     * Actualiza un usuario.
     * 
     * @param usuario con nuevos atributos.
     * @return usuario acualizado.
     */
    Usuario updateUsuario(Usuario usuario);

    /**
     * Busca un usuario por id.
     * 
     * @param idUsr id de usuario a buscar.
     * @return usuario con id solicitado.
     */
    Usuario getUsuarioById(String idUsr);


}
