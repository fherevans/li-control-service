package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-modelo-utilidad <br>
 * <b>Class:</b> TiempoEspecifico.java <br>
 * <b>Description:</b> Clase entity para obtener los datos de la tabla
 * LIQ_MX_MAE_CAT_TIME_ESPEC.
 *
 * @author FSW Jose Manuel Gonzalez Quillo
 * @company Praxis
 * @created 1 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez
 *          Quillo Creacion de clase
 *
 * @category Entity
 *
 */
@Getter
@Setter
public class TiempoEspecifico implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -1728593062374282883L;

    /**
     * Variable id de tipo String
     */
    private Long id;
    
    /**
     * Variable idOper de tipo Long
     */
    private Long idOper;
    
    /**
     * Variable operacion de tipo OperacionesLiq
     */
    private OperacionesLiq operacion;
    
    /**
     * Variable descipcion de tipo String
     */
    private String descripcion;
    
    /**
     * Variable horaMaxLiq de tipo String
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @JsonProperty("horaMaxLiq")
    private Date horaMaxLiq;

    /**
     * Variable idUser de tipo String
     */
    private String idUserMod;
    
    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchUltMod;

    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchCarga;


}