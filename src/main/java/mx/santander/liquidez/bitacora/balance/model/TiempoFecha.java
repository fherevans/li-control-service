package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> TiempoFecha.java
* <br><b>Description:</b> Clase bean para informacion de fecha y tiempo de operacion de saldo.
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
public class TiempoFecha implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 833272512772943978L;

    /**
     * Variable fechaOperacion de tipo String
     */
    private String fechaOperacion;
    
    /**
     * Variable tiempoRegistro de tipo Date
     */
    private String tiempoRegistro;
    
    /**
     * Metodo get para obtener el valor de la propiedad fechaOperacion
     * @return the fechaOperacion
     */
    public String getFechaOperacion() {
        return fechaOperacion;
    }

    /**
     * Metodo set para asignar valor a la propiedad fechaOperacion
     * @param fechaOperacion the fechaOperacion to set
     */
    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
    /**
     * Metodo get para obtener el valor de la propiedad tiempoRegistro
     * @return the tiempoRegistro
     */
    public String getTiempoRegistro() {
        return tiempoRegistro;
    }

    /**
     * Metodo set para asignar valor a la propiedad tiempoRegistro
     * @param tiempoRegistro the tiempoRegistro to set
     */
    public void setTiempoRegistro(String tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }
}
