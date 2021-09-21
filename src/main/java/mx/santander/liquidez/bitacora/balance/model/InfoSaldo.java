package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> InfoSaldo.java
* <br><b>Description:</b> Clase bean para informacion de saldo.
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
* @category Bean.
*
*/
public class InfoSaldo implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -7062091125549645208L;

    /**
     * Variable saldo de tipo Integer
     */
    private Integer saldo;
    
    /**
     * Variable divisaOrigen de tipo String
     */
    private String divisaOrigen;
    
    /**
     * Variable linea de tipo String
     */
    private String linea;
    
    /**
     * Metodo get para obtener el valor de la propiedad saldo
     * @return the saldos
     */
    public Integer getSaldo() {
        return saldo;
    }

    /**
     * Metodo set para asignar valor a la propiedad saldos
     * @param saldos the saldos to set
     */
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo get para obtener el valor de la propiedad divisaOrigen
     * @return the divisaOrigen
     */
    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    /**
     * Metodo set para asignar valor a la propiedad divisaOrigen
     * @param divisaOrigen the divisaOrigen to set
     */
    public void setDivisaOrigen(String divisaOrigen) {
        this.divisaOrigen = divisaOrigen;
    }

    /**
     * Metodo get para obtener el valor de la propiedad linea
     * @return the linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Metodo set para asignar valor a la propiedad linea
     * @param linea the linea to set
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }
}
