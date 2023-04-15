package br.com.accava.dojo.pubsub.cadastro.usuario.application.presentation;

import br.com.accava.dojo.pubsub.cadastro.usuario.application.mapper.UserMapper;
import br.com.accava.dojo.pubsub.cadastro.usuario.application.presentation.api.UserApi;
import br.com.accava.dojo.pubsub.cadastro.usuario.application.presentation.representation.UserRepresentation;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.accava.dojo.pubsub.cadastro.usuario.application.mapper.UserMapper.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "USERS")
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<?> save(UserRepresentation body) {
        userService.save(toDomain(body));
        return ResponseEntity.status(CREATED).build();
    }


}
