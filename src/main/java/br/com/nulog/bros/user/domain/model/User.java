package br.com.nulog.bros.user.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record User (
        int organizationGroup,
        int company,
        int branch,
        int unit,
        UUID id,
        String name,
        String email,
        String password,
        LocalDateTime createdAt,
        String cpfcnpj,
        String nickname
){
}
