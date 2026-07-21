package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.domain.model.UserId;

public class InactivateUserUseCase {
    private final IUserGateway gateway;

    public InactivateUserUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public String execute(UserId id){
        User actualUser = gateway.findById(id);

        User inactivatedUser = new User(
                actualUser.organizationGroup(),
                actualUser.company(),
                actualUser.branch(),
                actualUser.unit(),
                actualUser.id(),
                actualUser.name(),
                actualUser.email(),
                actualUser.password(),
                actualUser.createdAt(),
                actualUser.cpfcnpj(),
                actualUser.nickname(),
                false
        );

        gateway.updateUser(inactivatedUser);

        return "User " + actualUser.nickname() + " inactivated.";
    }
}
