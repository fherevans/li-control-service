package mx.santander.liquidez.control.perfilamiento.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para mostrar las preferencias que se tienen para el usuario que
 * ingresa.
 *
 */
@Getter
@Setter
public class Preferencias implements Serializable {

    /**
     * UID serializable.
     */
    private static final long serialVersionUID = 1134566363630205100L;

    /**
     * Id de preferencia.
     */
    private Long idPreferencia;

    /**
     * Nombre de la pagina a la que aplica la preferencia
     */
    private String pagina;

    /**
     * Nombre de preferencia.
     */
    private String nombre;

    /**
     * Valor para saber si la preferencia esta activa o inactiva
     */
    private boolean activa;

}
