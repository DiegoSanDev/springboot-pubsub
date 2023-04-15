package br.com.accava.dojo.pubsub.cadastro.usuario.domain.exception;

import lombok.Getter;

public class UserInvalidException extends RuntimeException{

    @Getter
    private MessageError messageError;

    public UserInvalidException(MessageError messageError) {
        this.messageError = messageError;
    }
}
