package br.com.accava.dojo.pubsub.notificacao.application.presentation.representation;

import br.com.accava.dojo.pubsub.notificacao.application.presentation.representation.enums.SendNotificationTypeRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationTypeRepresentation implements Serializable {

    private String value;
    private SendNotificationTypeRepresentation sendType;

}
