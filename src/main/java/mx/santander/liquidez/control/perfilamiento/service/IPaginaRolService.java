package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.PaginaRol;
import mx.santander.liquidez.control.perfilamiento.model.PaginaRolPK;
import mx.santander.liquidez.control.perfilamiento.response.model.PaginaRolResponse;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IPaginaRolService.java <br>
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
 * @category Incluir si la clase es un Modelo, Service, etc.
 *
 */
public interface IPaginaRolService {

    /**
     * Crea un nuevo rol para una pagina.
     * 
     * @param pageRol datos para asignar un rol a una pagina.
     */
    void createPageRol(PaginaRol pageRol);

    /**
     * Regresa todos los roles asignados a una pagina
     * 
     * @return list de paginas y roles
     */
    List<PaginaRol> getAllPageRol();

    /**
     * elimina un rol asignado a una pagina
     * 
     * @param pageRolId para eliminar rol de pagina.
     */
    void deletePageRol(PaginaRolPK pageRolId);

    /**
     * Actualiza un rol de una pagina
     * 
     * @param pageRol objeto para actualizar rol de pagina.
     */
    void updatePageRol(PaginaRol pageRol);

    /**
     * Metodo para encontrar las las paginas asignadas a un rol por el idRol.
     * 
     * @param idRol id de rol a buscar paginas.
     * @return List de paginas asignadas a un rol.
     */
    List<PaginaRol> findByIdRol(Long idRol);

    /**
     * Metodo para encontrar las paginas asignadas a un por por el idPage
     * 
     * @param idPage para buscar paginas.
     * @return List de paginas asignadas a un rol.
     */
    List<PaginaRol> findByIdPage(Long idPage);

    /**
     * Metodo para obtener paginas asginadas a un rol.
     * 
     * @param idRol id de rol de quien se quiere buscar las paginas.
     * @return List de PaginaRolResponse con los datos de las paginas asignadas a un
     *         rol.
     */
    List<PaginaRolResponse> getPaginasAsignadasRol(Long idRol);

    /**
     * Metodo para obtener las paginas no asignadas a un rol.
     * 
     * @param idRol id de rol de quien se quieren obtener las paginas sin rol.
     * @return List de ids de paginas no asignadas.
     */
    List<PaginaRolResponse> paginasNoAsignadasRol(Long idRol);

}
