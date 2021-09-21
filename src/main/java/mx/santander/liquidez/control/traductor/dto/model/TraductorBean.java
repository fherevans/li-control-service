package mx.santander.liquidez.control.traductor.dto.model;

import java.io.Serializable;

import lombok.Data;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> VectorPrecioBean.java
* <br><b>Description:</b> Bean para almacenar los datos del Vector Precios
*
* @author FSW Marcos Magana Hernandez
* @company Praxis
* @created 17 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Marcos Magana Hernandez
* Creacion de clase
*
* @category BEAN.
*
*/
@Data
public class TraductorBean implements Serializable {
    
    /** Variable serialVersionUID de tipo long */
    private static final long serialVersionUID = 2718590609286076379L;
    
    /** Variable fechaCarga de tipo String. */
    protected String fechaCarga;
    
    /** Variable tipoCarga de tipo String. */
    protected String tipoCarga;
    
    /** Variable nombreArchivo de tipo String. */
    protected String nombreArchivo;
    
    /** Variable data de tipo String. */
    protected String data;

}
