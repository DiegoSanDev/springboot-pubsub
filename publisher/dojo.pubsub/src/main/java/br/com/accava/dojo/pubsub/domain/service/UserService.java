package br.com.accava.dojo.pubsub.domain.service;

import br.com.accava.dojo.pubsub.domain.camel.router.UserRouter;
import br.com.accava.dojo.pubsub.domain.domain.User;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;

@RequiredArgsConstructor
public class UserService {

    private final CamelContext camelContext;

    public void save(User user) {
        this.camelContext.createProducerTemplate().sendBody(UserRouter.SAVE_ROUTER, user);
    }

}
