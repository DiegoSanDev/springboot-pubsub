package br.com.accava.dojo.pubsub.notificacao.domain.service;


import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificacaoService {

    public void send(Notification notificaco) {
        log.info("lógica para realizar a notificação: {}", notificaco);
    }

}
