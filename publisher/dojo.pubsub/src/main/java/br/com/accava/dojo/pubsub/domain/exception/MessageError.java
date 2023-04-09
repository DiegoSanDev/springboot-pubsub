package br.com.accava.dojo.pubsub.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageError {

    private String error;
    private String detail;
}
