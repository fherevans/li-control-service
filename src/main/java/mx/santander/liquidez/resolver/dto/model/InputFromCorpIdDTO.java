package mx.santander.liquidez.resolver.dto.model;

import java.io.Serializable;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> InputFromCorpIdDTO.java
* <br><b>Description:</b> Clase para transportar la informacion de entrada para lo metodos del WS Resolver.
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
* @category DTO
*
*/
public class InputFromCorpIdDTO implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = 253324862684223979L;
    
    /**
     * Variable identificadorCorporativo de tipo String
     */
    private String identificadorCorporativo;
    
    /**
     * Variable usuarioAplicativo de tipo String
     */
    private String usuarioAplicativo;
    
    /**
     * Variable claveAplicativo de tipo String
     */
    private String claveAplicativo;
    
    /**
     * Variable identificadorLocal de tipo String
     */
    private String identificadorLocal;

    /**
     * Metodo get para obtener el valor de la propiedad identificadorCorporativo
     * @return the identificadorCorporativo
     */
    public String getIdentificadorCorporativo() {
        return identificadorCorporativo;
    }

    /**
     * Metodo set para asignar valor a la propiedad identificadorCorporativo
     * @param identificadorCorporativo the identificadorCorporativo to set
     */
    public void setIdentificadorCorporativo(String identificadorCorporativo) {
        this.identificadorCorporativo = identificadorCorporativo;
    }

    /**
     * Metodo get para obtener el valor de la propiedad usuarioAplicativo
     * @return the usuarioAplicativo
     */
    public String getUsuarioAplicativo() {
        return usuarioAplicativo;
    }

    /**
     * Metodo set para asignar valor a la propiedad usuarioAplicativo
     * @param usuarioAplicativo the usuarioAplicativo to set
     */
    public void setUsuarioAplicativo(String usuarioAplicativo) {
        this.usuarioAplicativo = usuarioAplicativo;
    }

    /**
     * Metodo get para obtener el valor de la propiedad claveAplicativo
     * @return the claveAplicativo
     */
    public String getClaveAplicativo() {
        return claveAplicativo;
    }

    /**
     * Metodo set para asignar valor a la propiedad claveAplicativo
     * @param claveAplicativo the claveAplicativo to set
     */
    public void setClaveAplicativo(String claveAplicativo) {
        this.claveAplicativo = claveAplicativo;
    }

    /**
     * Metodo get para obtener el valor de la propiedad identificadorLocal
     * @return the identificadorLocal
     */
    public String getIdentificadorLocal() {
        return identificadorLocal;
    }

    /**
     * Metodo set para asignar valor a la propiedad identificadorLocal
     * @param identificadorLocal the identificadorLocal to set
     */
    public void setIdentificadorLocal(String identificadorLocal) {
        this.identificadorLocal = identificadorLocal;
    }

}
