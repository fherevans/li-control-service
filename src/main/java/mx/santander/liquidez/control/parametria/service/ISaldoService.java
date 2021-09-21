package mx.santander.liquidez.control.parametria.service;

import mx.santander.liquidez.control.util.ServiceException;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> SaldoService.java <br>
 * <b>Description:</b> Clase Service. 
 * que sera la encargada de consultar el servicio 
 * de parametria que es el encargado de obtener los saldos
 * historicos de los sistemas SPEI, SIAC y DALI 
 * en la pantalla de seguimiento valores historicos
 *
 * @author FSW Christian Ivan Miranda Paulin
 * @version Control de cambios:
 * @version 1.0, 26 nov. 2020 FSW Praxis, Nombre del autor:    IVPA
 * @since JDK1.8
 * @company Praxis
 * @created  26 nov. 2020
 * @category Service
 */
public interface ISaldoService {
    
    /**
     * Obtener saldos
     * 
     * Metodo que se encargara
     * de obtener los saldos
     * de los sistemas SIAC, SPEI, DALI de acuerdo a la fecha seleccionada
     * para ser mostrados en la pantalla de seguimento de dali, para casa de bolsa santander
     * o banco santander de acuerdo a la bandera
     * @param fecha con la que se realizara la consulta T y T-1 a T-30
     * @param  bandera parametro que indica si consultara los saldos C= Casa de bolsa o B= Banco Santander
     * @return lista de saldos obtenidos en la consulta
     * @throws ServiceException error en la ejecucion de la consulta
     */
     Object obtenerSaldos(String fecha, String bandera) throws ServiceException;
}