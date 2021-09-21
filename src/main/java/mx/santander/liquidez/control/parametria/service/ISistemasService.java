package mx.santander.liquidez.control.parametria.service;

import java.util.List;
import mx.santander.liquidez.control.parametria.model.Sistema;
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
public interface ISistemasService {

    
    /**
     * Metodo para consultar los sistemas de liquidez.
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return lista del objeto {@link Sistema} con la informacion de los sistemas
     * @throws ServiceException excepcion de negocio de liquidez
     */
    List<Sistema> consultaSistemas(String audit) throws ServiceException;
    
    /**
     * Metodo para consultar un Sistema por id.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion.
     * @return the sistema
     * @throws ServiceException the service exception
     */
    Sistema consultaSistemasById(Long id, String audit) throws ServiceException;
    
    /**
     * Metodo para guardar un Sistema.
     * @param sistema the sistema
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    Sistema saveSistema(Sistema sistema, String audit) throws ServiceException;
    
    /**
     * Metodo para actualizar un Sistema.
     * @param id the id
     * @param sistema the sistema
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    Sistema updateSistema(Long id,Sistema sistema, String audit) throws ServiceException;
    
    /**
     * Metodo para Borrar un Sistema.
     * @param id the id
     * @param audit parametro que guarda la pista como n de la aplicacion
     * @return the sistema
     * @throws ServiceException the service exception
     */
    String deleteSistema(Long id, String audit) throws ServiceException;
}
