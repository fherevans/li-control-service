package mx.santander.liquidez.control.util;

import com.google.gson.Gson;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-modelo-utilidad
* <br><b>Class:</b> UtilParseGson.java
* <br><b>Description:</b> Clase utileria para parsear objeto a cadenas con formato
* JSON y cadenas con formato JSON a un objeto en especifico.
*
* @author Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 22 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 22 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Incluir si la clase es un Modelo, Service, etc.
*
*/
public final class UtilParseGson {
    
    /**
     * Constructor de la clase UtilParseGson
     */
    protected UtilParseGson() {
         throw new UnsupportedOperationException("Unsupported UtilParseGson .... ");
    }
    
    /**
     * Metodo para convertir una cadena en formato JSON a un objeto en especifico
     * @param json cadena con formato JSON a convertir en objeto
     * @param objeto tipo de objeto a convervir la cadena JSON
     * @return objeto inicializado con la cadena JSON
     */
    public static Object jsonToObject(String json, Object objeto) {
        Gson gson = new Gson();    
        return gson.fromJson(json, objeto.getClass());
    }
    
    /**
     * Metodo para convertir un objeto a una cadena con formato JSON con GSON
     * @param objeto objeto a convertir en cadena con formato JSON
     * @return cadena con formato JSON
     */
    public static String objectToJson(Object objeto) {
        Gson gson = new Gson();    
        return gson.toJson(objeto);
    }

}