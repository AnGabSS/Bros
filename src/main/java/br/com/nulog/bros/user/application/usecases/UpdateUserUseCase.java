package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.dto.request.UpdateUserRequest;
import br.com.nulog.bros.user.domain.model.User;

import java.util.Objects;
import java.util.UUID;

public class UpdateUserUseCase {
    private final IUserGateway gateway;

    public UpdateUserUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public User execute(UUID id, UpdateUserRequest userRequest){
        User actualUser = gateway.findById(id);

        User updatedUser = new User(
                actualUser.organizationGroup(),
                actualUser.company(),
                actualUser.branch(),
                actualUser.unit(),

                actualUser.id(),

                Objects.requireNonNullElse(userRequest.name(), actualUser.name()),
                Objects.requireNonNullElse(userRequest.email(), actualUser.email()),

                actualUser.password(),
                actualUser.createdAt(),

                Objects.requireNonNullElse(userRequest.cpfcnpj(), actualUser.cpfcnpj()),
                Objects.requireNonNullElse(userRequest.nickname(), actualUser.nickname()),

                actualUser.isActive()
        );

        return gateway.updateUser(updatedUser);
    }
}
