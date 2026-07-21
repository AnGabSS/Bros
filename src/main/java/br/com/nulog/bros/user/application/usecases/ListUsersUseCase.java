package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.shared.dto.PageParams;
import org.springframework.data.domain.Page;

public class ListUsersUseCase {

    private final IUserGateway gateway;

    public ListUsersUseCase(IUserGateway gateway){
        this.gateway = gateway;
    }

    public Page<User> execute(PageParams params){
        return gateway.listUsers(params);
    }
}
