package br.com.accava.dojo.pubsub.cadastro.usuario.domain.port;

import br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain.User;

public interface UserRepository {
    void save(User user);

}
