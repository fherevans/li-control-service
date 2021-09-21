package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**  
  * Santander Mexico<br>  
  * <br><b>Project:</b> li-perfilamiento-service  
  * <br><b>Class:</b> PageRolPK.java  
  * <br><b>Description:</b> llave compuesta para PageRol.
  *  
  * @author Eduardo Castillo Mendoza  
  * @company Praxis  
  * @created 1 ago. 2019  
  * @since JDK1.8  
  *  
  * @version Control de cambios:  
  * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor:   
  * Descripcion breve del cambio  
  *  
  * @category Incluir si la clase es un Modelo, Service, etc.  
  *     
  */
@Getter
@Setter
@EqualsAndHashCode
public class PaginaRolPK implements Serializable {

    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id rol para crear llave.
     */
    private Long idRol;

    /**
     * IdPage para crear llave.
     */
    private Long idPage;
    
    /**
     * Id usuario.
     */
    private String usuarioUltimaModificacion;

    
}
