package br.com.accava.dojo.pubsub.notificacao.application.strategy;

import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import br.com.accava.dojo.pubsub.notificacao.domain.domain.NotificationType;
import br.com.accava.dojo.pubsub.notificacao.domain.enums.SendNotificationType;

import java.util.Set;

public interface NotificationStrategy {

    void send(Notification notification);

    default NotificationType extractType(Set<NotificationType> notificationTypes, SendNotificationType type) {
        return notificationTypes.stream()
            .filter(n -> n.getSendType().equals(type))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("unsupported type"));
    }

}
