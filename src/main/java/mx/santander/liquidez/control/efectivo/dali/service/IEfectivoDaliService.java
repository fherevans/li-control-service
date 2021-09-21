package mx.santander.liquidez.control.efectivo.dali.service;

import mx.santander.liquidez.control.efectivo.dali.model.BusinessException;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Interface:</b> IEfectivoDali.java
 * <br><b>Description:</b>
 * Interfase asociada al servicio de EfectivoDali.
 *
 * @author FSW Gustavo Adolfo Arellano Sandoval
 * @company CECoaching
 * @created 10 sep. 2021
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 0 sep. 2021: Creacion de la clase
 *
 * @category Service (interface)
 * 
 */
public interface IEfectivoDaliService {
    /**
     * Retorna una cadena con la respuesta del endpoint asociado que es invocado en el
     * interior de este método.
     * 
     * @param idInst parámetro con el id de la institución
     * @param numFolioInst parámetro con el folio de la institución
     * @param fecha parámetro que contiene la fecha en formato dd-mm-yyyy
     * @param endpoint ruta base del endpoint a consultar
     * 
     * @return Cadena con la respuesta del endpoint asociado
     * @throws BusinessException disparada cuando ocurre alguna excepción de negocio
     */
    String getEfectivoDali(String idInst, String numFolioInst, String fecha, String endpoint) throws BusinessException;
}
