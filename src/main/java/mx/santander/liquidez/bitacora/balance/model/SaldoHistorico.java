package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;
import java.util.Date;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> SaldoHistorico.java
* <br><b>Description:</b> Clase Bean Auxiliar para almacenar los valores de balance bitacora.
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
public class SaldoHistorico implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 4006045455943881680L;
    
    /**
     * Variable valor de tipo Integer
     */
    private Integer valor;
    
    /**
     * Variable fecha de tipo Date
     */
    private Date fecha;

    /**
     * Metodo get para obtener el valor de la propiedad valor
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * Metodo set para asignar valor a la propiedad valor
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    /**
     * Metodo get para obtener el valor de la propiedad fecha
     * @return the fecha
     */
    public Date getFecha() {
        return (Date) fecha.clone();
    }

    /**
     * Metodo set para asignar valor a la propiedad fecha
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = (Date) fecha.clone();
    }

}
