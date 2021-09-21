package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Pagina;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IPaginaService.java <br>
 * <b>Description:</b> Servicios para crear pagina.
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
public interface IPaginaService {

    /**
     * metodo para crear una pagina nueva.
     * 
     * @param page pagina a crear.
     * @throws ServiceException service exception.
     */
    void crearPage(Pagina page) throws ServiceException;

    /**
     * Metodo para obtener todas las paginas.
     * 
     * @param nombre  filtro.
     * @param nivPrio filtro.
     * @param permiso filtro.
     * @return List de paginas encontradas.
     */
    List<Pagina> getAllPages(String nombre, String nivPrio, String permiso);

    /**
     * Metodo para actualizar una pagina.
     * 
     * @param page pagina actualizida.
     * @throws ServiceException service exception.
     */
    void updatePage(Pagina page) throws ServiceException;

    /**
     * Metodo para eliminar una pagina.
     *
     * @param idPage id de pagina a eliminar.
     * @param idUsuario the id usuario
     * @throws ServiceException service exception.
     */
    void deletePage(Long idPage, String idUsuario) throws ServiceException;

    /**
     * busca una pagina por id.
     * 
     * @param idPage id de pagina.
     * @return Pagina encontrada.
     */
    Pagina findByIdPagina(Long idPage);

}
