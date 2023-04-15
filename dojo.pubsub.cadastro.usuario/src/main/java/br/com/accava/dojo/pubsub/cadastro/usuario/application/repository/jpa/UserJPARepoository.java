package br.com.accava.dojo.pubsub.cadastro.usuario.application.repository.jpa;

import br.com.accava.dojo.pubsub.cadastro.usuario.application.repository.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepoository extends JpaRepository<UserEntity, Long> {
}
