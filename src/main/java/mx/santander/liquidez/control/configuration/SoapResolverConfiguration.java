package mx.santander.liquidez.control.configuration;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import mx.santander.liquidez.control.util.SOAPConnector;

/**
* Santander Mexico<br>
* <br><b>Project:</b> li-control-service
* <br><b>Class:</b> SoapResolverConfiguration.java
* <br><b>Description:</b> Clase de configuracion para consumir WS Soap Resolver.
*
* @author FSW Jose Manuel Gonzalez Quillo
* @company Praxis
* @created 1 ago. 2019
* @since JDK1.8
*
* @version Control de cambios:
* @version 1.0, 1 ago. 2019 FSW Praxis, Nombre del autor: Jose Manuel Gonzalez Quillo
* Creacion de clase
*
* @category Config
*
*/
@Configuration
public class SoapResolverConfiguration {
    
    /**
     * Contiene el endpoint hace el web service del resolver.
     */
    @Value("${resolver.endpoint}")
    private String resolverEndpoint;
    
    /**
     * Paquete base donde se encuentran los componentes del cliente web service.
     */
    private static final String BASE_PACKAGE 
            = "mx.santander.liquidez.control.resolver.ws";
    
    
    /**
     * Metodo para sobre escribir el bean por default Jaxb2Marshaller para inyectar el contexto del WS Resolver
     * @return Objeto Jaxb2Marshaller inicializado con WS Resolver
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in pom.xml
        marshaller.setContextPath(BASE_PACKAGE);
        return marshaller;
    }
 
    /**
     * Metodo para sobre escribir el objeto SOAPConnector para realizar la invocacion de WS Soap
     * @param marshaller Jaxb2Marshaller objeto con el contexto del WS Resolver
     * @return {@link SOAPConnector} objeto inicialziado con el contexto del WS Resolver
     */
    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(resolverEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}