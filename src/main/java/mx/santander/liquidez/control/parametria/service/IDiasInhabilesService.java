package mx.santander.liquidez.control.parametria.service;

import java.util.List;
import mx.santander.liquidez.control.parametria.model.DiasInhabiles;
import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ISistemaService.java <br>
 * <b>Description:</b> Clase Interface que expone los metodos de negocio de los
 * sistemas de liquidez.
 *
 * @author Jose Manuel Gonzalez Quillo
 * @version Control de cambios:
 * @version 1.0, 18 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez
 *          Quillo Creacion de clase
 * @since JDK1.8
 * @company Praxis
 * @created 18 sep. 2019
 * @category Interface Service
 */
public interface IDiasInhabilesService {

    
    /**
     * Metodo para consultar los dias inhabiles
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link DiasInhabiles} con la informacion de los dias inhabiles
     * @throws ServiceException excepcion de negocio de liquidez
     */
    List<DiasInhabiles> consultaDiasInhabiles(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar un Dia Inhabil por id.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    DiasInhabiles consultaDiasInhabilesById(Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para guardar un Dia Inhabil.
     * @param diasInhabiles the dias inhabiles
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    DiasInhabiles saveDiasInhabiles(DiasInhabiles diasInhabiles, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar un Dia Inhabil
     * @param id the id
     * @param diasInhabiles the dias inhabiles
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the diasInhabiles
     * @throws ServiceException the service exception
     */
    DiasInhabiles updateDiasInhabiles(Long id,DiasInhabiles diasInhabiles, String audit) throws ServiceException;
    
    /**
     *  Metodo para Borrar un Dia Inhabil.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the String
     * @throws ServiceException the service exception
     */
    String deleteDiasInhabiles(Long id, String audit) throws ServiceException;
}
