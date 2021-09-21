package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-parametria-utilidad
* <br><b>Class:</b> Divisas.java
* <br><b>Description:</b> Clase entity para obtener los datos de la tabla LIQ_MX_PRC_CAT_DIV
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 6 sep. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 6 sep. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Entity
*
*/
@Getter
@Setter
public class Divisas implements Serializable {

    /**
     * Variable serialVersionUID de tipo long
     */
    private static final long serialVersionUID = -2631899425503697565L;
    
    /**
     * Variable idDivPk de tipo long
     */
    private long idDivPk;
    
    /**
     * Variable idDiv de tipo int
     */
    private int idDiv;
    
    /**
     * Variable nomDiv de tipo String
     */
    private String nomDiv;
    
    /**
     * Variable desc de tipo String
     */
    private String desc;

    /**
     * Variable codUsrSoliFk de tipo String
     */
    private String idUsuarioMod;
    
    /**
     * Variable txtIdeDiv de tipo String
     */
    private String txtIdeDiv;

    /**
     * Variable numDecim de tipo int
     */
    private int numDecim;
    
    /**
     * Variable fchOper de tipo Date
     */
    private Date fchOper;

    /**
     * Variable fchCarga de tipo Date
     */
    private Date fchCarga;
    
    /**
     * Variable fchUltMod de tipo Date
     */
    private Date fchUltMod;

}
