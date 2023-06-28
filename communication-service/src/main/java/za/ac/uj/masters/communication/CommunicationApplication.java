package za.ac.uj.masters.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommunicationApplication {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.security.oauth2.resource-server.jwt.issuer-uri}")
    private String jwtIssuerUri;

    @Value("${spring.security.oauth2.resource-server.jwt.jwt-set-uri}")
    private String jwtSetUri;


    public static void main(String[] args) {
        SpringApplication.run(CommunicationApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties) {
        logger.info("issuer uri: {}", jwtIssuerUri);
        logger.info("jwt set uri: {}", jwtSetUri);
        return evt -> logger.info("Communication-DS started: http://localhost:{}{}/swagger-ui.html to use Communication-ds",
                        serverProperties.getPort(), serverProperties.getServlet().getContextPath());
    }
}
