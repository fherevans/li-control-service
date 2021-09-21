/**
 * 
 */
package mx.santander.liquidez.control.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Santander Mexico<br>
 * <br><b>Project:</b> li-control-service
 * <br><b>Class:</b> MessageBrokerConfigurer.java
 * <br><b>Description:</b>
 * Habilita la configuracion para un agente de mensajeria para enviar
 * actualizaciones de balances y toasts via web socket.
 *
 * @author FSW Lacertus Ricardo Camacho Montoya
 * @company Praxis
 * @created July 29, 2019
 * @since JDK1.8
 *
 * @version Control de cambios:
 * @version 1.0 July 29, 2019 FSW Lacertus RCAM: Creacion de la clase
 *
 * @category Configuration
 * @see WebSocketMessageBrokerConfigurer
 */
@Configuration
@EnableWebSocketMessageBroker
public class MessageBrokerConfigurer 
    implements WebSocketMessageBrokerConfigurer {
    
    /**
     * Registra el mapeo de endpoints STOMP hacia URL especificas y,
     * opcionalmente, habilita y configura opciones SockJS alternas.
     * @param registry una instancia de {@link StompEndpointRegistry}
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/brokers").setAllowedOrigins("*");
        registry.addEndpoint("/brokers").setAllowedOrigins("*")
                .withSockJS();
    }

    /**
     * Configura las opciones del agente de mensajeria.
     * @param registry una instancia de {@link MessageBrokerRegistry}
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }

}
