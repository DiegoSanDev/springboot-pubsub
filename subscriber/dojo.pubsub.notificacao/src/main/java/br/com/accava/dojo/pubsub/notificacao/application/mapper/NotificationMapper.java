package br.com.accava.dojo.pubsub.notificacao.application.mapper;

import br.com.accava.dojo.pubsub.notificacao.application.presentation.representation.NotificationRepresentation;
import br.com.accava.dojo.pubsub.notificacao.application.presentation.representation.NotificationTypeRepresentation;
import br.com.accava.dojo.pubsub.notificacao.domain.domain.Notification;
import br.com.accava.dojo.pubsub.notificacao.domain.domain.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@UtilityClass
public class NotificationMapper {

    private final Supplier<ModelMapper> mapperSupplier = ModelMapper::new;

    public static Notification toDomain(NotificationRepresentation representation) {
        return get().map(representation, Notification.class);
    }

    private static Set<NotificationType> getNotificationTypes(Set<NotificationTypeRepresentation> representations) {
        return representations.stream()
            .map(NotificationMapper::getNotificationType)
            .collect(Collectors.toSet());
    }

    private static NotificationType getNotificationType(NotificationTypeRepresentation representation) {
        return get().map(representation, NotificationType.class);
    }

    private static ModelMapper get() {
        return mapperSupplier.get();
    }
}
