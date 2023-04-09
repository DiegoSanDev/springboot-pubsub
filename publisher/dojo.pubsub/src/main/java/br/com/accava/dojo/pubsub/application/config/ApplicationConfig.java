package br.com.accava.dojo.pubsub.application.config;

import br.com.accava.dojo.pubsub.domain.camel.router.UserRouter;
import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import br.com.accava.dojo.pubsub.domain.service.UserService;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

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
    public UserRouter userRouter(NotificationRepository notificationRepository) {
        return new UserRouter(notificationRepository);
    }

    @Bean
    public UserService userService(CamelContext camelContext) {
        return new UserService(camelContext);
    }

}
