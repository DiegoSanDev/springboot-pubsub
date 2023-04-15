package br.com.accava.dojo.pubsub.cadastro.usuario.application.repository;

import br.com.accava.dojo.pubsub.cadastro.usuario.application.mapper.UserMapper;
import br.com.accava.dojo.pubsub.cadastro.usuario.application.repository.jpa.UserJPARepoository;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain.User;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepoository repoository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        try {
            var userEntity = UserMapper.domainToEntity(user);
            if (nonNull(user.getPhone())) {
                var phoneEntity = userEntity.getPhone();
                phoneEntity.setUser(userEntity);
                userEntity.setPhone(phoneEntity);
            }
            userEntity.setEnabled(true);
            repoository.save(userEntity);
        } catch (Exception e) {
            log.error("Error in save user.", e);
            throw e;
        }
    }

}
