package br.com.nulog.bros.user.application.gateways;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.domain.model.UserId;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IUserGateway {
    User createUser(User userDomainObj);
    Page<User> listUsers(PageParams params);
    User findByNickname(String nickname);
    User findById(UserId id);
    User findById(UUID id);
    User updateUser(User user);
}
