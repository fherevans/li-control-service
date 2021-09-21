package mx.santander.liquidez.control.semaforo.service;

import mx.santander.liquidez.control.util.ServiceException;
import mx.santander.liquidez.notificacion.toast.model.SemaforoBalanceDTO;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-notificacion-service
* <br><b>Class:</b> IKiwiSemaforoService.java
* <br><b>Description:</b> Interface Service que parametriza el rango de activacion
* de los semaforos de los sistemas de liquidez.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 16 oct. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 16 oct. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Interface Service
*
*/
public interface IKiwiSemaforoService {

    /**
     * Metodo que consulta los semaforos del rol solicitado en liquidez
     * @param rol identificador unico de rol del usuario que consulta los semaforos
     * @param flagDia - bandera para identificar si se consulta los kiwis actuales o T + 1
     * @return lista del objeto SemaforoBalanceDTO con los datos de los semaforos obtenidos
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object consultaSemaforos(String rol, int flagDia) throws ServiceException;
    
    /**
     * Metodo para actualizar el semaforo solicitado del rol asignado
     * @param semaforo datos del semaforo a configurar en liquidez
     * @return objeto SemaforoBalanceDTO con los datos de la configuracion del semaforo
     * @throws ServiceException excepcion de negocio de liquidez
     */
    Object actualizarSemaforo(SemaforoBalanceDTO semaforo) throws ServiceException;
}
