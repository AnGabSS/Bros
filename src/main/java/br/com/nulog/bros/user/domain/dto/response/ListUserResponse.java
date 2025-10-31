package br.com.nulog.bros.user.domain.dto.response;

import br.com.nulog.bros.user.domain.model.User;

import java.time.LocalDateTime;

public record ListUserResponse (
        int organizationGroup,
        int company,
        int branch,
        int unit,
        String name,
        String email,
        LocalDateTime createdAt,
        String cpfcnpj,
        String nickname
) {
public static ListUserResponse fromUser(User user){
    return new ListUserResponse(
            user.organizationGroup(),
            user.company(),
            user.branch(),
            user.unit(),
            user.name(),
            user.email(),
            user.createdAt(),
            user.cpfcnpj(),
            user.cpfcnpj()
    );
}
}
