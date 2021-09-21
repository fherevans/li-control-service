package mx.santander.liquidez.control.parametria.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Santander Mexico<br>
 * <br>
 * <b>Project:</b> li-parametria-service <br>
 * <b>Class:</b> DetalleOperacion.java <br>
 * <b>Description:</b> clase para detalle de operacion de seguimiento.
 *
 * @author Eduardo Castillo Mendoza
 * @company Praxis
 * @created 19 sep. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 19 sep. 2019 FSW Lacertus Nombre del autor: Descripcion breve
 *          del cambio
 *
 * @category Model.
 *
 */
@Getter
@Setter
public class DetalleOperacion implements Serializable {

    /**
     * Serial version uid generado.
     */
    private static final long serialVersionUID = -7424321383804137466L;

    /**
     * Compra venta.
     */
    private String compraVenta;

    /**
     * titulos de operacion.
     */
    private int titulos;

    /**
     * Importe.
     */
    private int importe;

    /**
     * Cuenta.
     */
    private int cuenta;

    /**
     * Contraparte.
     */
    private int contraparte;

    /**
     * Cuenta contraparte.
     */
    private int cuentaContraparte;

    /**
     * Tipo operacion.
     */
    private String tipoOperacion;
}