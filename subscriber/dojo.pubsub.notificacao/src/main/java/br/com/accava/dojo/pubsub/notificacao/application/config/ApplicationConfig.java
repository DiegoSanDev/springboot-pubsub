package br.com.accava.dojo.pubsub.notificacao.application.config;

import br.com.accava.dojo.pubsub.notificacao.domain.service.NotificacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public NotificacaoService notificacaoService() {
        return new NotificacaoService();
    }

}
