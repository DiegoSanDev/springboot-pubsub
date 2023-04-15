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
public class PhoneRepresentation {
    private String code;
    private String number;


}
