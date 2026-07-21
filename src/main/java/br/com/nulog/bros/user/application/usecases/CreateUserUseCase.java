package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;

public class CreateUserUseCase {

    private final IUserGateway gateway;

    public CreateUserUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public User execute(User user){
        return gateway.createUser(user);
    }
}
