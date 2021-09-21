package mx.santander.liquidez.bitacora.balance.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> BalanceBitacoraHistorico.java
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
* @category Bean.
*
*/
public class BalanceBitacoraHistorico implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 4774500701554761422L;
    
    /**
     * Variable id de tipo String
     */
    private Long id;
    
    /**
     * Variable sistema de tipo String
     */
    private String sistema;
    
    /**
     * Variable datos de tipo BalanceBitacoraValoresModelBean
     */
    private SaldoHistorico datos;

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
     * Metodo get para obtener el valor de la propiedad datos
     * @return the datos
     */
    public SaldoHistorico getDatos() {
        return datos;
    }

    /**
     * Metodo set para asignar valor a la propiedad datos
     * @param datos the datos to set
     */
    public void setDatos(SaldoHistorico datos) {
        this.datos = datos;
    }
    
}
