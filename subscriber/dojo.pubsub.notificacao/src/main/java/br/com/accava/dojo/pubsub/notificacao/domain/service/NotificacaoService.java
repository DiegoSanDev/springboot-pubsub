package br.com.accava.dojo.pubsub.notificacao.domain.service;


import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import br.com.accava.dojo.pubsub.notificacao.domain.port.SendNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NotificacaoService {

    private final SendNotificationService sendNotificationService;

    public void send(Notification notificaco) {
        log.info("Send notification {}", notificaco);
        sendNotificationService.send(notificaco);
    }

}
