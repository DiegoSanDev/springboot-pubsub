package br.com.accava.dojo.pubsub.notificacao.application.strategy;

import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import br.com.accava.dojo.pubsub.notificacao.domain.enums.SendNotificationType;
import org.springframework.stereotype.Component;


@Component
public class NotificationEmail implements NotificationStrategy {

    @Override
    public void send(Notification notification) {
        extractType(notification.getTypes(), SendNotificationType.EMAIL);
    }

}
