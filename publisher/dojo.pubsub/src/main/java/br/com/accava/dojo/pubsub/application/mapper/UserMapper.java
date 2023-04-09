package br.com.accava.dojo.pubsub.application.mapper;

import br.com.accava.dojo.pubsub.application.resentation.representation.UserRepesentation;
import br.com.accava.dojo.pubsub.domain.domain.User;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.function.Supplier;

@UtilityClass
public class UserMapper {

    private Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;

    public User toDomain(UserRepesentation repesentation) {
        return getModelMapper().map(repesentation, User.class);
    }

    private ModelMapper getModelMapper() {
        return modelMapperSupplier.get();
    }

}
