package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;

public class LoadUserByNicknameUseCase {

    private final IUserGateway gateway;

    public LoadUserByNicknameUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public User execute(String nickname){
        return gateway.findByNickname(nickname);
    }
}
