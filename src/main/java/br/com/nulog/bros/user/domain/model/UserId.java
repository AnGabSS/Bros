package br.com.nulog.bros.user.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserId(
        int organizationGroup,
        int company,
        int branch,
        int unit,
        UUID id
){
}
