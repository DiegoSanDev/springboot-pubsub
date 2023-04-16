package br.com.accava.dojo.pubsub.domain.camel.router;

import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class NotificationRouter extends RouteBuilder {

    public static final String NOTIFICATION_ROUTER = "direct:notificationFLow";

    private NotificationRepository notificationRepository;

    @Override
    public void configure() throws Exception {

        from(NOTIFICATION_ROUTER)
            .bean(notificationRepository, "send(${body})")
        .end();

    }
}
