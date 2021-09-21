package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;



/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> CustomPageImpl.java
* <br><b>Description:</b> Reemplazar con una descripcion acorde a la
* funcionalidad de la clase.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 5 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 5 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
* @param <T> clase con objetos paginados.
*/
@Getter
@Setter
public class CustomPageImpl<T extends Serializable> implements Serializable {

    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 597499927905311860L;

    /**
     * Variable number de tipo int
     */
    private int number;
    
    /**
     * Variable size de tipo int
     */
    private int size;
    
    /**
     * Variable totalPages de tipo int
     */
    private int totalPages;
    
    /**
     * Variable numberOfElements de tipo int
     */
    private int numberOfElements;
    
    /**
     * Variable totalElements de tipo long
     */
    private long totalElements;
    
    /**
     * Variable previousPage de tipo boolean
     */
    private boolean previousPage;
    
    /**
     * Variable firstPage de tipo boolean
     */
    private boolean firstPage;
    
    /**
     * Variable nextPage de tipo boolean
     */
    private boolean nextPage;
    
    /**
     * Variable lastPage de tipo boolean
     */
    private boolean lastPage;
    
    /**
     * Variable content de tipo List<T>
     */
    private List<T> content;

}