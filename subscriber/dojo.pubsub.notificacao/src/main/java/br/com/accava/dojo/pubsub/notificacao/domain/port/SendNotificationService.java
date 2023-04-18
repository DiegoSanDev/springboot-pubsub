package br.com.accava.dojo.pubsub.notificacao.domain.port;

import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;

public interface SendNotificationService {

    void send(Notification notification);

}
