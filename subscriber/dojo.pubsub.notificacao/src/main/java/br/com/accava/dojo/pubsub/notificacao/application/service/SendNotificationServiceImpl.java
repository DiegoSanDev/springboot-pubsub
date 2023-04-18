package br.com.accava.dojo.pubsub.notificacao.application.service;

import br.com.accava.dojo.pubsub.notificacao.application.strategy.NotificationContextStrategy;
import br.com.accava.dojo.pubsub.notificacao.application.strategy.NotificationEmail;
import br.com.accava.dojo.pubsub.notificacao.application.strategy.NotificationPhone;
import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import br.com.accava.dojo.pubsub.notificacao.domain.port.SendNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendNotificationServiceImpl implements SendNotificationService {

    private final NotificationContextStrategy contextStrategy;
    private final NotificationEmail notificationEmail;
    private final NotificationPhone notificationPhone;

    @Override
    public void send(Notification notification) {

        notification.getTypes().forEach(type -> {
            switch (type.getSendType()) {
                case EMAIL -> contextStrategy.setNotificationStrategy(notificationEmail);
                case PHONE -> contextStrategy.setNotificationStrategy(notificationPhone);
            }
            contextStrategy.send(notification);
        });

    }

}
