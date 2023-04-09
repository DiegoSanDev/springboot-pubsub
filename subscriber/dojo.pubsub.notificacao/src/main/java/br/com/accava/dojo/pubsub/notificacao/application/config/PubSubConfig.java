package br.com.accava.dojo.pubsub.notificacao.application.config;

import br.com.accava.dojo.pubsub.notificacao.application.presentation.representation.NotificationRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PubSubConfig {

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
        return new JacksonPubSubMessageConverter(new ObjectMapper());
    }

    @Bean
    public MessageChannel notificacaoInputChannel() {
        return new DirectChannel();
    }

   @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter(@Qualifier("notificacaoInputChannel") MessageChannel inputChannel,
                                                             PubSubTemplate pubSubTemplate) {

        var adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "my_test_sub");
        adapter.setOutputChannel(inputChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(NotificationRepresentation.class);

        return adapter;
    }

}
