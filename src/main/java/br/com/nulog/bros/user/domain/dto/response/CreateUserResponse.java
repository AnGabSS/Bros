package br.com.nulog.bros.user.domain.dto.response;

import br.com.nulog.bros.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserResponse(
         int organizationGroup,
         int company,
         int branch,
         int unit,
         UUID id,
         String name,
         String email,
         LocalDateTime createdAt,
         String cpfcnpj,
         String nickname
) {
    public static CreateUserResponse fromUser(User user){
        return new CreateUserResponse(
                user.organizationGroup(),
                user.company(),
                user.branch(),
                user.unit(),
                user.id(),
                user.name(),
                user.email(),
                user.createdAt(),
                user.cpfcnpj(),
                user.cpfcnpj()
        );
    }
}
