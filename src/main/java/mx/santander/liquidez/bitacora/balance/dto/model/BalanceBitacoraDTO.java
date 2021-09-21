package mx.santander.liquidez.bitacora.balance.dto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.santander.liquidez.bitacora.balance.model.BalanceBitacora;
import mx.santander.liquidez.bitacora.balance.model.BalanceBitacoraHistorico;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> BalanceBitacoraDTO.java
* <br><b>Description:</b> DTO para almacenar los datos del balance de bitacora.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category DTO.
*
*/
public class BalanceBitacoraDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7980838677059673371L;
    
    /**
     * Variable balanceBitacora de tipo BalanceBitacoraBean
     */
    private List<BalanceBitacora> balanceBitacora;
    
    /**
     * Variable balanceBitacoraHistoricoModel de tipo List<BalanceBitacoraHistoricoBean>
     */
    private List<BalanceBitacoraHistorico> balanceBitacoraHistorico;

    /**
     * Metodo get para obtener el valor de la propiedad balanceBitacora
     * @return the balanceBitacora
     */
    public List<BalanceBitacora> getBalanceBitacora() {
        return new ArrayList<BalanceBitacora>(balanceBitacora);
    }

    /**
     * Metodo set para asignar valor a la propiedad balanceBitacora
     * @param balanceBitacora the balanceBitacora to set
     */
    public void setBalanceBitacora(List<BalanceBitacora> balanceBitacora) {
        List<BalanceBitacora> balanceBitacoraCopy = new ArrayList<BalanceBitacora>();
        balanceBitacoraCopy.addAll(balanceBitacora);
        this.balanceBitacora = balanceBitacoraCopy;
    }

    /**
     * Metodo get para obtener el valor de la propiedad balanceBitacoraHistoricoModel
     * @return the balanceBitacoraHistoricoModel
     */
    public List<BalanceBitacoraHistorico> getBalanceBitacoraHistorico() {
        return new ArrayList<BalanceBitacoraHistorico> (balanceBitacoraHistorico);
    }

    /**
     * Metodo set para asignar valor a la propiedad balanceBitacoraHistoricoModel
     * @param balanceBitacoraHistorico the balanceBitacoraHistoricoModel to set
     */
    public void setBalanceBitacoraHistorico(List<BalanceBitacoraHistorico> balanceBitacoraHistorico) {
        List<BalanceBitacoraHistorico> balanceBitacoraHistoricoCopy = new ArrayList<BalanceBitacoraHistorico>();
        balanceBitacoraHistoricoCopy.addAll(balanceBitacoraHistorico);
        this.balanceBitacoraHistorico = balanceBitacoraHistoricoCopy;
    }

}
