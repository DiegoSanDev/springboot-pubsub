package br.com.accava.dojo.pubsub.notificacao.application.pubsub;

import br.com.accava.dojo.pubsub.notificacao.application.presentation.representation.NotificationRepresentation;
import br.com.accava.dojo.pubsub.notificacao.domain.service.NotificacaoService;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static br.com.accava.dojo.pubsub.notificacao.application.mapper.NotificationMapper.toDomain;


@Component
@RequiredArgsConstructor
public class NotificacaoListener {

    private final NotificacaoService notificacaoService;

    @ServiceActivator(inputChannel = "notificacaoInputChannel")
    public void save(NotificationRepresentation notification, @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
        notificacaoService.send(toDomain(notification));
        message.ack();
    }

}
