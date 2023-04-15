package br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private static final String REGEX_EMAIL = "^(.+)@(.+)$";
    private static final int MAX_SIZE_PASSWORD = 8;

    private Phone phone;
    private String email;
    private boolean enabled;
    private String password;
    private String lastName;
    private String firstName;

    public boolean isValid() {
        return isEmailValid() && isPasswordValid();
    }

    public boolean isPhoneNonNull() {
        return nonNull(this.getPhone());
    }

    public boolean isEmailValid() {
        return isFieldValid(this.email) && Pattern.compile(REGEX_EMAIL).matcher(this.email).matches();
    }

    public boolean isPasswordValid() {
        return isFieldValid(this.password) && this.password.length() == MAX_SIZE_PASSWORD;
    }

    private boolean isFieldValid(String field) {
        return hasText(field);
    }

}
