/**
 * 
 */
package mx.santander.liquidez.control.util;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> CodigoError.java
 * <br><b>Description:</b>
 * Define la catalogacion generica de errores de la aplicacion.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 6 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Util 
 * 
 */
public enum CodigoError {
    
    /**
     * WSRV - {@code 001 Error en cliente REST}.
     */
    CLIENTE_REST("WSRV", "001", "Error en cliente REST", Nivel.WARNING),
    
    /**
     * WSRV - {@code 002 Error en cliente WebSocket}.
     */
    CLIENTE_SOCKET("WSRV", "002", "Error en cliente WebSocket", Nivel.WARNING),
    
    /**
     * WSRV - {@code 003 Error en cliente de RabbitMQ}. 
     */
    CLIENTE_RABBIT("WSRV", "003", "Error en cliente de RabbitMQ", Nivel.CRITICAL),
    
    /**
     * WSRV - {@code 004 Error en implementacion de tipos}. 
     */
    TIPOS("WSRV", "004", "Error en implementacion de tipos", Nivel.CRITICAL),
    
    /**
     * DIVI - {@code 001 Divisa equivalente inexistente}. 
     */
    DIVISA_SIN_EQUIV("DIVI", "001", "Divisa equivalente inexistente", Nivel.CRITICAL),
    
    /**
     * VECP - {@code 001 Vector de precio inexistente}. 
     */
    VECTOR_INEXISTENTE("VECP", "001", "Vector de precio inexistente", Nivel.CRITICAL),
    
    /**
     * CNTA - {@code 001 No existe informacion de cuentas}. 
     */
    SIN_CUENTAS("CNTA", "001", "No existe informacion de cuentas", Nivel.CRITICAL),
    
    /**
     * REPO - {@code 001 Error en repositorio Oracle}.
     */
    REPOSITORY_ORACLE("REPO", "001", "Error en repositorio Oracle", Nivel.CRITICAL),
    
    /**
     * REPO - {@code 002 Error en repositorio Redis}.
     */
    REPOSITORY_REDIS("REPO", "002", "Error en repositorio Redis", Nivel.CRITICAL),
    
    /**
     * REPO - {@code 003 Error en conexion con Redis}.
     */
    CONEXION_REDIS("REPO", "003", "Error en conexion con Redis", Nivel.CRITICAL),
    
    /**
     * GENE - {@code 001 Error no especificado}.
     */
    NO_ESPECIFICADO("GENE", "001", "Error no especificado", Nivel.UNKNOWN),
    
    /**
     * GENE - {@code 002 Conflicto en la aplicacion}.
     */
    CONFLICTO("GENE", "002", "Conflicto en la aplicacion", Nivel.CRITICAL);
    
    /**
     * Define el codigo de error.
     */
    private final String codigo;
    
    /**
     * Define la razon por la que occurre el error.
     */
    private final String razon;
    
    /**
     * Define el nivel o clasificacion del error.
     */
    private final Nivel nivel;
    
    /**
     * Crea un elemento de la enumeracion.
     * @param dominio es el dominio o el contexto en el que ocurre el error
     * @param codigo es un valor numerico que define el codigo de error 
     * @param razon la razon por la que occurre el error
     * @param nivel define el nivel o clasificacion del error
     */
    CodigoError(String dominio, String codigo, String razon, Nivel nivel) {
        this.codigo = StringUtil.concat(dominio, ".", codigo);
        this.razon = razon;
        this.nivel = nivel;
    }
    
    /**
     * Retorna el valor del codigo de error.
     * @return el codigo de error
     */
    public String valor() {
        return this.codigo;
    }
    
    /**
     * Retorna la razon por la que occurre el error.
     * @return la razon del error
     */
    public String razon() {
        return this.razon;
    }
    
    /**
     * Retorna el nivel del error.
     * @return el nivel del error
     */
    public Nivel nivel() {
        return this.nivel;
    }
    
    /**
     * Santander Mexico<br>
     * <br><b>Project:</b> li-procesamiento-service
     * <br><b>Class:</b> Nivel.java
     * <br><b>Description:</b>
     * Define un conjunto de valores que sirven para especificar
     * la clasificacion o los niveles de un error.
     *
     * @author FSW Lacertus Ricardo Camacho Montoya
     * @company Praxis
     * @created 6 ago. 2019
     * @since JDK1.8
     *
     * @version Control de cambios:
     * @version 1.0 6 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
     *
     * @category Util
     *
     */
    public enum Nivel {
        
        /**
         * Nivel blocker.
         */
        BLOCKER("blocker"),
        
        /**
         * Nivel critico.
         */
        CRITICAL("critical"),
        
        /**
         * Nivel warning.
         */
        WARNING("warning"),
        
        /**
         * Nivel unknown.
         */
        UNKNOWN("unknown");
        
        /**
         * Valor del nivel.
         */
        private final String valor;
        
        /**
         * Constructor que inicializa un nivel con el valor dado.
         * @param valor el valor a establecer
         */
        Nivel(String valor) {
            this.valor = valor;
        }
        
        /**
         * Retorna el valor del nivel.
         * @return el valor del nivel
         */
        public String valor() {
            return this.valor;
        }
        
    }

}
