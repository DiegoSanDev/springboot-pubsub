package br.com.accava.dojo.pubsub.application.resentation;

import br.com.accava.dojo.pubsub.application.mapper.UserMapper;
import br.com.accava.dojo.pubsub.application.resentation.api.UserApi;
import br.com.accava.dojo.pubsub.application.resentation.representation.UserRepesentation;
import br.com.accava.dojo.pubsub.domain.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.accava.dojo.pubsub.application.mapper.UserMapper.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "USER")
@RequiredArgsConstructor
public class UsuarioController implements UserApi {

    private final UserService service;

    @Override
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(UserRepesentation body) {
        this.service.save(toDomain(body));
        return status(CREATED).build();
    }

}
