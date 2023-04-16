package br.com.accava.dojo.pubsub.application.mapper;

import br.com.accava.dojo.pubsub.application.resentation.representation.UserRepesentation;
import br.com.accava.dojo.pubsub.domain.domain.User;
import java.util.function.Supplier;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UserMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public User toDomain(UserRepesentation repesentation) {
        return getModelMapper().map(repesentation, User.class);
    }

    public UserRepesentation toRepresentation(User user) {
        return getModelMapper().map(user, UserRepesentation.class);
    }

    private ModelMapper getModelMapper() {
        return modelMapperSupplier.get();
    }

}
