/**
 * 
 */
package mx.santander.liquidez.notificacion.toast.model;

import java.io.Serializable;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-modelo-utilidad
 * <br><b>Class:</b> TipoToast.java
 * <br><b>Description:</b>
 * Define un objeto para el tipo de notificacion toast.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 9 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 9 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category DTO
 * 
 */
public class TipoToast implements Serializable {

    /**
     * La serial version.
     */
    private static final long serialVersionUID = 624525478968890776L;
    
    /**
     * Identificador del tipo de notificacion.
     */
    protected long id;
    
    /**
     * Contiene la descripcion del tipo de notificacion.
     */
    protected String descripcion;

    /**
     * Constructor por defecto.
     */
    public TipoToast() {
        super();
    }

    /** 
     * Regresa el valor del atributo id
     * @return el atributo id
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id
     * @param id el valor de id a establecer
     */
    public void setId(long id) {
        this.id = id;
    }

    /** 
     * Regresa el valor del atributo descripcion
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el valor del atributo descripcion
     * @param descripcion el valor de descripcion a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la representacion del objeto en <code>string</code>.
     * @return un <code>string</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TipoToast [id=");
        builder.append(id);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append("]");
        return builder.toString();
    }

}
