package br.com.accava.dojo.pubsub.cadastro.usuario.domain.service;

import br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain.Phone;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain.User;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.exception.MessageError;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.exception.UserInvalidException;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void save(User user) {
        if(user.isValid()) {
            repository.save(user);
        }else {
            throw new UserInvalidException(new MessageError("Invalid User", "Error in save user"));
        }
    }

}
