package br.com.accava.dojo.pubsub.notificacao.application.presentation.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRepresentation implements Serializable {

    private String message;
    private Set<NotificationTypeRepresentation> types;

}
