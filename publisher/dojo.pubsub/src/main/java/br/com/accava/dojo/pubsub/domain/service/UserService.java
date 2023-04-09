package br.com.accava.dojo.pubsub.domain.service;

import br.com.accava.dojo.pubsub.domain.camel.router.UserRouter;
import br.com.accava.dojo.pubsub.domain.domain.User;
import br.com.accava.dojo.pubsub.domain.exception.MessageError;
import br.com.accava.dojo.pubsub.domain.exception.UserInvalidException;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;

@RequiredArgsConstructor
public class UserService {

    private final CamelContext camelContext;

    public void save(User user) {
        if(user.isValid()) {
            this.camelContext.createProducerTemplate().sendBody(UserRouter.SAVE_ROUTER, user);
        }else {
            throw new UserInvalidException(new MessageError("User invalid", "Email or Password invalid."));
        }
    }

}
