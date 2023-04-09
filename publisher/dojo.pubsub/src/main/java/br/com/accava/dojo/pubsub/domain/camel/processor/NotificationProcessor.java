package br.com.accava.dojo.pubsub.domain.camel.processor;

import br.com.accava.dojo.pubsub.domain.domain.Notification;
import br.com.accava.dojo.pubsub.domain.domain.NotificationType;
import br.com.accava.dojo.pubsub.domain.domain.User;
import br.com.accava.dojo.pubsub.domain.enums.SendNotificationType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static br.com.accava.dojo.pubsub.domain.enums.SendNotificationType.*;
import static java.util.Objects.*;

public class NotificationProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        var user = exchange.getIn().getBody(User.class);
        Set<NotificationType> types = new HashSet<>();

        var typeEmail = new NotificationType();
        typeEmail.setValue(user.getEmail());
        typeEmail.setSendType(EMAIL);
        if(nonNull(user.getPhone())) {
            var typePhone = new NotificationType();
            typePhone.setSendType(PHONE);
            typePhone.setValue(user.getPhone().getCode().concat(" ")
                .concat(user.getPhone().getNumber()));
            types.add(typePhone);
        }
        types.add(typeEmail);

        var notification = Notification.builder()
            .message("User save with success.")
            .types(types)
            .build();
        exchange.getIn().setBody(notification, Notification.class);
    }

}
