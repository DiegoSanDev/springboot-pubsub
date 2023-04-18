package br.com.accava.dojo.pubsub.notificacao.application.strategy;

import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationContextStrategy {

    private NotificationStrategy notificationStrategy;

    public void send(Notification notification) {
        notificationStrategy.send(notification);
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

}
