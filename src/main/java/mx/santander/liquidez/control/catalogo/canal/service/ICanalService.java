package mx.santander.liquidez.control.catalogo.canal.service;

import mx.santander.liquidez.control.parametria.model.Canal;
import mx.santander.liquidez.control.util.ServiceException;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> ICanalService.java
* <br><b>Description:</b> Interface que expone los metodos de negocio de los canales
* de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 21 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 21 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service.
*
*/
public interface ICanalService {

    /**
     * Metodo para consultar todos los canales de liquidez haciendo una peticion http
     * al servicio de parametria
     * @return arreglo del objeto Canal con todos los canales
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Canal[] obtenerCanales() throws ServiceException;
    
}
