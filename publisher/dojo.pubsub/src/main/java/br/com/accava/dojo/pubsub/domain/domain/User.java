package br.com.accava.dojo.pubsub.domain.domain;

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
public class User {

    private Phone phone;
    private String email;
    private boolean enabled;
    private String password;
    private String lastName;
    private String firstName;

}
