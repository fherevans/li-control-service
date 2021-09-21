package mx.santander.liquidez.control.kiwi.service;

import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br> 
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> IReporteProgramadoService.java
 * <br><b>Description:</b>
 * Clase creada para 
 *
 * @author FSW Lacertus Herwin Toral Rios
 * @company Praxis
 * @created 2 dic 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0  2 dic 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 */
public interface IReporteProgramadoService {

    /**
     * metodo para realizar la validacion y consulta de las operaciones progrmada
     * para saber cuanto nos deben y debemos 
     * 
     * @param fechaLiquidacion -  fecha a la cual se realiza la consulta
     * @return retorna el objeto con la informacion consultada.
     * @throws ServiceException - lanza una exception requerida
     */
    Object obtenerProgramadosByFecha(String fechaLiquidacion) throws ServiceException;

}