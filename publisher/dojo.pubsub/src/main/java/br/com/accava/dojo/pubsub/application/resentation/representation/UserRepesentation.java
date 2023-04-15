package br.com.accava.dojo.pubsub.application.resentation.representation;

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
public class UserRepesentation {

    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private PhoneRepresentation phone;

}
