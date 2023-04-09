package br.com.accava.dojo.pubsub.application.repository;

import br.com.accava.dojo.pubsub.domain.domain.Notification;
import br.com.accava.dojo.pubsub.domain.port.NotificationRepository;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final PubSubTemplate pubSubTemplate;

    @Override
    public void send(Notification notification) {
        pubSubTemplate.publish("my_test_topic", notification);
    }

}
