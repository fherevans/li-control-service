package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> BalanceBitacora.java
* <br><b>Description:</b> Clase bean para devolver los datos del balance diario.
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
public class BalanceBitacora implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 7980838677059673371L;
    
    /**
     * Variable id de tipo Integer
     */
    private Long id;
    
    /**
     * Variable sistema de tipo String
     */
    private String sistema;
    
    /**
     * Variable saldo de tipo Saldo
     */
    private InfoSaldo infoSaldo;
    
    /**
     * Variable tipoOperaciones de tipo TipoOperaciones
     */
    private TipoOperaciones tipoOperaciones;
    
    /**
     * Variable tiempoFecha de tipo TiempoFecha
     */
    private TiempoFecha tiempoFecha;

    /**
     * Metodo get para obtener el valor de la propiedad id
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo set para asignar valor a la propiedad id
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo get para obtener el valor de la propiedad sistema
     * @return the sistema
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * Metodo set para asignar valor a la propiedad sistema
     * @param sistema the sistema to set
     */
    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    /**
     * Metodo get para obtener el valor de la propiedad tipoOperaciones
     * @return the tipoOperaciones
     */
    public TipoOperaciones getTipoOperaciones() {
        return tipoOperaciones;
    }

    /**
     * Metodo set para asignar valor a la propiedad tipoOperaciones
     * @param tipoOperaciones the tipoOperaciones to set
     */
    public void setTipoOperaciones(TipoOperaciones tipoOperaciones) {
        this.tipoOperaciones = tipoOperaciones;
    }

    /**
     * Metodo get para obtener el valor de la propiedad saldo
     * @return the saldo
     */
    public InfoSaldo getInfoSaldo() {
        return infoSaldo;
    }

    /**
     * Metodo set para asignar valor a la propiedad saldo
     * @param saldo the saldo to set
     */
    public void setInfoSaldo(InfoSaldo infoSaldo) {
        this.infoSaldo = infoSaldo;
    }

    /**
     * Metodo get para obtener el valor de la propiedad tiempoFecha
     * @return the tiempoFecha
     */
    public TiempoFecha getTiempoFecha() {
        return tiempoFecha;
    }

    /**
     * Metodo set para asignar valor a la propiedad tiempoFecha
     * @param tiempoFecha the tiempoFecha to set
     */
    public void setTiempoFecha(TiempoFecha tiempoFecha) {
        this.tiempoFecha = tiempoFecha;
    }

}
