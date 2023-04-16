package br.com.accava.dojo.pubsub.application.config;

import br.com.accava.dojo.pubsub.domain.camel.router.NotificationRouter;
import br.com.accava.dojo.pubsub.domain.camel.router.UserRouter;
import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import br.com.accava.dojo.pubsub.domain.port.UserRepository;
import br.com.accava.dojo.pubsub.domain.service.UserService;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @SneakyThrows
    @Bean
    public CamelContext camelContext(RouteBuilder... routes) {
        var defaultCamelContext = new DefaultCamelContext();
        for(RouteBuilder routeBuilder : routes) {
            defaultCamelContext.addRoutes(routeBuilder);
        }
        defaultCamelContext.start();
        return defaultCamelContext;
    }

    @Bean
    public UserRouter userRouter(UserRepository notificationRepository) {
        return new UserRouter(notificationRepository);
    }

    @Bean
    public NotificationRouter notificationRouter(NotificationRepository repository) {
        return new NotificationRouter(repository);
    }

    @Bean
    public UserService userService(CamelContext camelContext) {
        return new UserService(camelContext);
    }

}
