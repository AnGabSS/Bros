package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;

import java.util.UUID;

public class FindUserByIdUseCase {

    private final IUserGateway gateway;

    public FindUserByIdUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public User execute(UUID id){
        return gateway.findById(id);
    }
}
