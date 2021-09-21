package mx.santander.liquidez.control.parametria.service;

import java.util.List;

import mx.santander.liquidez.control.parametria.model.Aprovisionamiento;
import mx.santander.liquidez.control.parametria.model.CustomPageImpl;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-equivalencias-service <br>
 * <b>Class:</b> IAprovisionamientoService.java <br>
 * <b>Description:</b> Service para crear, actualizar, eliminar y leer operacion
 * aprovisionamiento service.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Service
 * 
 */
public interface IAprovisionamientoService {

    /**
     * Metodo para crear un nuevo aprovisionamiento.
     * 
     * @param aprovisionamiento atributos.
     * @return aprovisionamiento creado.
     */
    Aprovisionamiento crearAprovisionamiento(Aprovisionamiento aprovisionamiento);

    /**
     * Metodo para obtener todos los aprovisionamientos con filtros.
     *
     * @param claveAprov clave de aprovisionamiento, atributo como filtro para busqueda.
     * @param nombreCanal nombre del canal, atributo como filtro para busqueda.
     * @param nombreSistema nombre del sistama, atributo como filtro de busqueda.
     * @param size cantidad de paginas a devolver para paginacion.
     * @param page numero de pagina a devolver de paginacion.
     * 
     * @return List de aprovisionamientos paginados.
     */
    CustomPageImpl<Aprovisionamiento> obtenerTodosAprovisionamientos(String claveAprov, String nombreSistema, String nombreCanal,
            Integer page, Integer size);

    /**
     * Metodo para obtener aprovisionamiento sin filtros.
     * 
     * @param claveAprov clave de aprovisionadores, atributo como filtro de busqueda.
     * @param nombreSistema nombre de sistema, atributo como filtro de busqueda.
     * @param nombreCanal   nombre de canal, atributo como filtro de busqueda.
     * @return List de aprovisionamiento lista de aprovisionamientos encontrados.
     */
    List<Aprovisionamiento> obtenerTodosAprovisionamientos(String claveAprov, String nombreSistema, String nombreCanal);

}
