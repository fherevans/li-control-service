/**
 * 
 */
package mx.santander.liquidez.control;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * Santander Mexico<br>
 * <b>Project:</b> li-control-service <br>
 * <b>Class:</b> ControlApplication.java <br>
 * <b>Description:</b>
 * Clase principal de la aplicacion que se ejecuta con Spring Boot.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Application
 *
 */
@SpringBootApplication(scanBasePackages = {
        "mx.santander.liquidez.control",
        "mx.santander.liquidez.procesamiento" })
public class ControlApplication {

    /**
     * Ejecuta la aplicacion.
     * @param args argumentos de linea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }
    
    /**
     * Crea un instancia de Rest template
     * @param builder es la referencia al constructor para REST template
     * @return una instancia de tipo {@link RestTemplate}
     */
    @Primary
    @Bean(name = "restTemplatePrimary")
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        Duration timeout = Duration.ofMillis(3000);
        builder.setConnectTimeout(timeout);
        builder.setReadTimeout(timeout);
        return builder.build();
    }

}
