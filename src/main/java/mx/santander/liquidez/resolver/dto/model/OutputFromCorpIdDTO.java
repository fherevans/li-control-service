package mx.santander.liquidez.resolver.dto.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> OutputFromCorpIdDTO.java
* <br><b>Description:</b> Clase bean para transportar la informacion de respuesta de WS Resolver.
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
public class OutputFromCorpIdDTO implements Serializable{

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 2350846980092661752L;

    /**
     * Variable codigoError de tipo String
     */
    private String codigoError;
    
    /**
     * Variable mensajeError de tipo String
     */
    private String mensajeError;
    
    /**
     * Variable resultado de tipo String
     */
    private String resultado;

    /**
     * Metodo get para obtener el valor de la propiedad codigoError
     * @return the codigoError
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Metodo set para asignar valor a la propiedad codigoError
     * @param codigoError the codigoError to set
     */
    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * Metodo get para obtener el valor de la propiedad mensajeError
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Metodo set para asignar valor a la propiedad mensajeError
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    /**
     * Metodo get para obtener el valor de la propiedad resultado
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Metodo set para asignar valor a la propiedad resultado
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
