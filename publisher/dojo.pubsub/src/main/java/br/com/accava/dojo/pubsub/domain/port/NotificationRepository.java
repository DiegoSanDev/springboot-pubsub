package br.com.accava.dojo.pubsub.domain.port;

import br.com.accava.dojo.pubsub.domain.domain.Notification;

public interface NotificationRepository {

    void send(Notification notification);

}
