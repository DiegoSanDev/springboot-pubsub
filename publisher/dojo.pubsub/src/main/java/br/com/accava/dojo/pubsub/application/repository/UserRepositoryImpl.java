package br.com.accava.dojo.pubsub.application.repository;

import br.com.accava.dojo.pubsub.application.mapper.UserMapper;
import br.com.accava.dojo.pubsub.application.resentation.representation.UserRepesentation;
import br.com.accava.dojo.pubsub.domain.domain.User;
import br.com.accava.dojo.pubsub.domain.port.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import static br.com.accava.dojo.pubsub.application.mapper.UserMapper.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    @Value("${service.cadastro-usuario.url}")
    private String url;

    private final RestTemplate restTemplate;

    @Override
    public void save(User user) {

        try {
            HttpEntity<?> httpEntity = new HttpEntity<>(toRepresentation(user), createHeader());
            restTemplate.exchange(url, POST, httpEntity, Void.class);
        } catch (RestClientResponseException e) {
            log.error("Error in save user. ", e);
            throw e;
        } catch (Exception ex) {
            log.error("Error critical in save user. ", ex);
            throw ex;
        }

    }

    private HttpHeaders createHeader() {
        var headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));
        return headers;
    }

}
