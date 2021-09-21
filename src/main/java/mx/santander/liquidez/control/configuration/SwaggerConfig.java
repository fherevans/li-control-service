/**
 * 
 */
package mx.santander.liquidez.control.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> SwaggerConfig.java
 * <br><b>Description:</b>
 * Habilita la configuracion de Swagger2.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created 22 oct 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 22 oct 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Configuration
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Variable con el titulo de la pantalla de swagger-ui
     */
    private static String titulo = "Control";

    /**
     * Variable con la descripcion de la pantalla de swagger-ui
     */
    private static String descripcion = "Descripcion ";
    
    /**
     * Variable con la version de la pantalla de swagger-ui    
     */
    private static String version = "1.0";
    
    /**
     * Variable con el nombre de la pantalla de swagger-ui
     */
    private static String nombre = "irvin";
    
    /**
     * Variable con el correo de la pantalla de swagger-ui
     */
    private static String correo = "irvin@got.com";
    
    /**
     * Bean para scannear las APIs existentes en el proyecto
     *  y generar el swagger-ui.
     * @return docket con configuracion para scannar APIs.
     */
    @Bean
    public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2)
              .useDefaultResponseMessages(Boolean.FALSE)
              .select()
              .apis(RequestHandlerSelectors
              .basePackage("mx.santander.liquidez.control"))
              .paths(PathSelectors.any())
          .build().apiInfo(apiInfo());
    }

    /**
     * Builder para el ApiInfo.
     * @return apiInfo con la informacion de la construccion del API.
     */
    private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title(titulo)
              .description(descripcion)
              .version(version)
              .contact(new Contact(nombre, " ", correo)).build();
    }

}
