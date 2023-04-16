package br.com.accava.dojo.pubsub.domain.camel.router;

import br.com.accava.dojo.pubsub.domain.camel.processor.NotificationProcessor;
import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import br.com.accava.dojo.pubsub.domain.port.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class UserRouter extends RouteBuilder {

    public static final String SAVE_ROUTER = "direct:saveFlow";

    private UserRepository repository;

    @Override
    public void configure() throws Exception {
        from(SAVE_ROUTER)
            .bean(repository, "save")
            .process(new NotificationProcessor())
        .end();

    }


}
