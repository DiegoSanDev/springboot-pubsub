package br.com.accava.dojo.pubsub.notificacao.domain.enums;

import java.util.Arrays;

public enum SendNotificationType {

    EMAIL, PHONE;

    public SendNotificationType get(String type) {
        return Arrays.stream(SendNotificationType.values())
            .filter(t -> t.name().equalsIgnoreCase(type))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Unsupported type"));
    }

}