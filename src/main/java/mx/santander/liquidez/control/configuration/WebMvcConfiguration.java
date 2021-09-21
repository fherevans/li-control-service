/**
 * 
 */
package mx.santander.liquidez.control.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-procesamiento-service
 * <br><b>Class:</b> WebMvcConfig.java
 * <br><b>Description:</b>
 * Habilita la configuracion Web MVC.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 8 ago. 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 8 ago. 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Configuration
 *
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * Configura los dominios para CORS.
     * @param registry instancia para configurar CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(false)
                .allowedHeaders("Accept", "Content-Type", "Origin");
    }
    
    /**
     * Habilita la configuracion de Swagger2
     * @param registry es una instancia de tipo {@link ResourceHandlerRegistry}
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");
     
        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
}
