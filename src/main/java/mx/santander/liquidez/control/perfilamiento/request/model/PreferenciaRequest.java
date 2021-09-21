package mx.santander.liquidez.control.perfilamiento.request.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-perfilamiento-service <br>
 * <b>Class:</b> PreferenciaRequest.java <br>
 * <b>Description:</b> Clase para realizar request para crear permiso.
 * 
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 * 
 * @version Control de cambios:
 * @version 1.0 1 ago. 2019 FSW Lacertus Nombre del autor: Descripcion breve del
 *          cambio
 * 
 * @category Incluir si la clase es un Modelo, Service, etc.
 * 
 */
@Getter
@Setter
public class PreferenciaRequest implements Serializable {

    /**
     * UID generado.
     */
    private static final long serialVersionUID = 2704409244054629622L;

    /**
     * id de preferencia.
     */
    private Long idPreferencia;

    /**
     * Id de usuario a asignar preferencia.
     */
    private String idUser;

    /**
     * Id de pagina para asignar preferencia.
     */
    private Long idPage;

    /**
     * Nombre de la preferencia.
     */
    private String tipoPreferencia;

    /**
     * bandera para la propiedad true o false.
     */
    private String flgValor;

    /**
     * bandera para saber si es columna o fila. True para columna. False para fila.
     */
    private String flgCol;

}
