package br.com.accava.dojo.pubsub.cadastro.usuario.application.presentation.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRepresentation {

    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private PhoneRepresentation phone;

}
