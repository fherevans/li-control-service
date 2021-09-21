package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> Pagina.java
* <br><b>Description:</b> Mode de pagina.
*
* @author Eduardo Castillo Mendoza
* @company Praxis
* @created 2 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0 2 sep. 2019 FSW Lacertus Nombre del autor:
* Descripcion breve del cambio
*
* @category Model.
*
*/
@Getter
@Setter
public class Pagina implements Serializable {

    
    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -4088700949863604738L;

    /**
     * id de pagina creada.
     */
    private Long idPage;

    /**
     * Nombre de la pagina creada.
     */
    private String nombre;

    /**
     * Descripcion de la pagina creada.
     */
    private String desc;

    /**
     * nivel de prioridad de la pagina creada.
     */
    private String nivPrio;

    /**
     * fecha de carga de la pagina.
     */
    private Date fechaCarga;
    
    /**
     * Id de usuario logeado.
     */
    private String idUsuario;


    /**
     * metodo para obtener fecha de carga de pagina.
     * 
     * @return fecha de carga de pagina.
     */
    public Date getFechaCarga() {
        if (fechaCarga != null) {
            return new Date(fechaCarga.getTime());
        } else {
            return null;
        }
    }

    /**
     * metodo para asignar fecha de carga de pagina.
     * 
     * @param fechaCarga de pagina.
     */
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = new Date(fechaCarga.getTime());
    }

}