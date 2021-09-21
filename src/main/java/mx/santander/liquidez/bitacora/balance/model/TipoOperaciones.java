package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TipoOperaciones.java
* <br><b>Description:</b> Clase bean de tipo de operaciones.
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
* @category Bean
*
*/
public class TipoOperaciones implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 5251497474736923615L;
    
    /**
     * Variable operacionesRealesCobros de tipo Integer
     */
    private Integer operacionesRealesCobros;
    
    /**
     * Variable operacionesRealesPagos de tipo Integer
     */
    private Integer operacionesRealesPagos;
    
    /**
     * Variable operacionesProgramadasCobros de tipo Integer
     */
    private Integer operacionesProgramadasCobros;
    
    /**
     * Variable operacionesProgramadasPagos de tipo Integer
     */
    private Integer operacionesProgramadasPagos;
    
    /**
     * Metodo get para obtener el valor de la propiedad operacionesRealesCobros
     * @return the operacionesRealesCobros
     */
    public Integer getOperacionesRealesCobros() {
        return operacionesRealesCobros;
    }

    /**
     * Metodo set para asignar valor a la propiedad operacionesRealesCobros
     * @param operacionesRealesCobros the operacionesRealesCobros to set
     */
    public void setOperacionesRealesCobros(Integer operacionesRealesCobros) {
        this.operacionesRealesCobros = operacionesRealesCobros;
    }

    /**
     * Metodo get para obtener el valor de la propiedad operacionesRealesPagos
     * @return the operacionesRealesPagos
     */
    public Integer getOperacionesRealesPagos() {
        return operacionesRealesPagos;
    }

    /**
     * Metodo set para asignar valor a la propiedad operacionesRealesPagos
     * @param operacionesRealesPagos the operacionesRealesPagos to set
     */
    public void setOperacionesRealesPagos(Integer operacionesRealesPagos) {
        this.operacionesRealesPagos = operacionesRealesPagos;
    }

    /**
     * Metodo get para obtener el valor de la propiedad operacionesProgramadasCobros
     * @return the operacionesProgramadasCobros
     */
    public Integer getOperacionesProgramadasCobros() {
        return operacionesProgramadasCobros;
    }

    /**
     * Metodo set para asignar valor a la propiedad operacionesProgramadasCobros
     * @param operacionesProgramadasCobros the operacionesProgramadasCobros to set
     */
    public void setOperacionesProgramadasCobros(Integer operacionesProgramadasCobros) {
        this.operacionesProgramadasCobros = operacionesProgramadasCobros;
    }

    /**
     * Metodo get para obtener el valor de la propiedad operacionesProgramadasPagos
     * @return the operacionesProgramadasPagos
     */
    public Integer getOperacionesProgramadasPagos() {
        return operacionesProgramadasPagos;
    }

    /**
     * Metodo set para asignar valor a la propiedad operacionesProgramadasPagos
     * @param operacionesProgramadasPagos the operacionesProgramadasPagos to set
     */
    public void setOperacionesProgramadasPagos(Integer operacionesProgramadasPagos) {
        this.operacionesProgramadasPagos = operacionesProgramadasPagos;
    }

}
