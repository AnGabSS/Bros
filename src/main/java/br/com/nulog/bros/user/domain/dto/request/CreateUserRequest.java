package br.com.nulog.bros.user.domain.dto.request;


import br.com.nulog.bros.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserRequest(
        int organizationGroup,
        int company,
        int branch,
        int unit,
        String name,
        String email,
        String password,
        String cpfcnpj,
        String nickname
) {
    public static User toUser(CreateUserRequest request){
        return new User(
                request.organizationGroup(),
                request.company(),
                request.branch(),
                request.unit(),
                UUID.randomUUID(),
                request.name(),
                request.email(),
                request.password(),
                LocalDateTime.now(),
                request.cpfcnpj(),
                request.nickname(),
                true
        );
    }
}
