package br.com.accava.dojo.pubsub.domain.camel.router;

import br.com.accava.dojo.pubsub.domain.camel.processor.NotificationProcessor;
import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class UserRouter extends RouteBuilder {

    public static final String SAVE_ROUTER = "direct:saveFlow";

    private NotificationRepository notificationRepository;

    @Override
    public void configure() throws Exception {
        from(SAVE_ROUTER)
            .log(LoggingLevel.INFO, log, "chama serviço para salvar o usuário")
            .process(new NotificationProcessor())
            .bean(notificationRepository, "send(${body})")
        .end();

    }


}
