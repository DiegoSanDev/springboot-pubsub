package br.com.accava.dojo.pubsub.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        var server = new Server();
        server.setUrl("http://localhost:8080");

        var contact = new Contact();
        contact.setName("DOJO [PUB/SUB]  - [PUBLISHER]");
        contact.setEmail("pubsub@dojo.com.br");
        contact.setUrl("https://www.dojopubsub.com.br");

        var info = new Info()
            .title("DOJO PUB/BSUB")
            .version("1.0")
            .contact(contact)
            .description("DOJO [PUB/SUB] - [PUBLISHER]");

        return new OpenAPI().info(info).servers(List.of(server));

    }

}
