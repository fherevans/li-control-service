package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**  
  * Santander Mexico<br>  
  * <br><b>Project:</b> li-control-service  
  * <br><b>Class:</b> PagePermPK.java  
  * <br><b>Description:</b> llave compuesta Permiso de pagina.  
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
public class PaginaPermisoPK implements Serializable {

    /**
     * serial id para llave de permiso de pagina.
     */
    private static final long serialVersionUID = 1L;

    /**
     * id de pagina.
     */
    private Long idPage;

    /**
     * Id de permiso.
     */
    private Long idPerm;
    
    /**
     * Id de usuario.
     */
    private String usuarioUltimaModificacion;

    

}
