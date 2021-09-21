package mx.santander.liquidez.control.traductor.dto.model;

import java.io.Serializable;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-ctrl-monitor-service
* <br><b>Class:</b> ComboBean.java
* <br><b>Description:</b> Clase service de implementacion del negocio de los 
* comboBean.
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 17 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category Bean
*
*/
public class ComboBean implements Serializable {
    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = -8034066684958808051L;
        
    /** Variable key de tipo String. */
    private String key;
    
    /** Variable value de tipo String. */
    private String value;
    
    /**
     *  Contructor ComboBean
     */
    public ComboBean() {
        super();        
    }

    /**
     * Metodo get para obtener el valor de la propiedad key
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Metodo set para asignar valor a la propiedad key
     * @param key the new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Metodo get para obtener el valor de la propiedad value
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Metodo set para asignar valor a la propiedad value
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    

}
