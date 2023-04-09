package br.com.accava.dojo.pubsub.application.exception;

import br.com.accava.dojo.pubsub.domain.exception.MessageError;
import br.com.accava.dojo.pubsub.domain.exception.UserInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserInvalidException.class)
    public ResponseEntity<MessageError> userInvalidException(UserInvalidException userInvalidException) {
        return ResponseEntity.unprocessableEntity().body(userInvalidException.getMessageError());
    }

}
