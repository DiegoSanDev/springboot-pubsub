package br.com.accava.dojo.pubsub.cadastro.usuario.application.config;

import br.com.accava.dojo.pubsub.cadastro.usuario.domain.port.UserRepository;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
