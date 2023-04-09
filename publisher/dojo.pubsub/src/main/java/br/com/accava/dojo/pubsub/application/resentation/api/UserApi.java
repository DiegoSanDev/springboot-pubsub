package br.com.accava.dojo.pubsub.application.resentation.api;

import br.com.accava.dojo.pubsub.application.resentation.representation.UserRepesentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @Operation(summary = "Cria um Usuário", description = "Recurso responsável por criar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Content"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ResponseEntity<?> save(@RequestBody UserRepesentation body);

}
