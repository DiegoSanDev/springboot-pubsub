package br.com.accava.dojo.pubsub.cadastro.usuario.application.mapper;


import br.com.accava.dojo.pubsub.cadastro.usuario.application.presentation.representation.UserRepresentation;
import br.com.accava.dojo.pubsub.cadastro.usuario.application.repository.jpa.entity.UserEntity;
import br.com.accava.dojo.pubsub.cadastro.usuario.domain.domain.User;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.function.Supplier;

@UtilityClass
public class UserMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public User toDomain(UserRepresentation repesentation) {
        return getModelMapper().map(repesentation, User.class);
    }

    public UserEntity domainToEntity(User user) {
        return getModelMapper().map(user, UserEntity.class);
    }

    public User entityToDomain(UserEntity userEntity) {
        return getModelMapper().map(userEntity, User.class);
    }

    private ModelMapper getModelMapper() {
        return modelMapperSupplier.get();
    }

}
