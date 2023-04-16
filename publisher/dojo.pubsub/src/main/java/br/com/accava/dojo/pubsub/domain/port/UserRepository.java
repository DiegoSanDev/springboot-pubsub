package br.com.accava.dojo.pubsub.domain.port;

import br.com.accava.dojo.pubsub.domain.domain.User;

public interface UserRepository {

    void save(User user);

}
