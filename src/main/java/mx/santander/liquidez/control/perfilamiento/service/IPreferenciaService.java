package mx.santander.liquidez.control.perfilamiento.service;

import java.util.List;

import mx.santander.liquidez.control.perfilamiento.model.Preferencia;
import mx.santander.liquidez.control.perfilamiento.request.model.PreferenciaRequest;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> IPreferenciaService.java <br>
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
public interface IPreferenciaService {

    /**
     * Buscar columnas por id de usuario.
     * 
     * @param idUser ide de usuario.
     * @return List de columnas asignadas a un usuario.
     */
    List<Preferencia> findByIdUserColumnas(String idUser);

    /**
     * Actualizar preferencias.
     * 
     * @param preferencias lista de preferencias a actualizar.
     * @return List lista de preferencias actualizadas.
     */
    List<Preferencia> updatePreferencias(List<PreferenciaRequest> preferencias);

}
