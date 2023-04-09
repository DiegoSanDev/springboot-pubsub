package br.com.accava.dojo.pubsub.notificacao.domain.domain;

import br.com.accava.dojo.pubsub.notificacao.domain.enums.SendNotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationType {

    private String value;
    private SendNotificationType sendType;

}
