  /**
 * 
 */
package mx.santander.liquidez.procesamiento.balance.model;

import java.io.Serializable;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> CobrosDTO.java
 * <br><b>Description:</b>
 * Clase de transporte que contiene un conjunto de datos referentes a cobros.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 8 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 26, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category DTO
 *
 */
public class CobrosDTO implements Serializable {
    
    /**
     * La serial version.
     */
    private static final long serialVersionUID = 7937014864681934393L;
    
    /**
     * Es el dato de los cobros reales.
     */
    protected double cobrosReal;
    
    /**
     * Son los cobros programados.
     */
    protected double cobrosProgramados;
    
    /**
     * Constructor por defecto.
     */
    public CobrosDTO() {
        super();
    }
    
    /** 
     * Regresa el valor del atributo cobrosReal
     * @return el atributo cobrosReal
     */
    public double getCobrosReal() {
        return cobrosReal;
    }

    /**
     * Establece el valor del atributo cobrosReal
     * @param cobrosReal el valor de cobrosReal a establecer
     */
    public void setCobrosReal(double cobrosReal) {
        this.cobrosReal = cobrosReal;
    }

    /** 
     * Regresa el valor del atributo cobrosProgramados
     * @return el atributo cobrosProgramados
     */
    public double getCobrosProgramados() {
        return cobrosProgramados;
    }

    /**
     * Establece el valor del atributo cobrosProgramados
     * @param cobrosProgramados el valor de cobrosProgramados a establecer
     */
    public void setCobrosProgramados(double cobrosProgramados) {
        this.cobrosProgramados = cobrosProgramados;
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cobros [cobrosReal=");
        builder.append(cobrosReal);
        builder.append(", cobrosProgramados=");
        builder.append(cobrosProgramados);
        builder.append("]");
        return builder.toString();
    }
    
}
