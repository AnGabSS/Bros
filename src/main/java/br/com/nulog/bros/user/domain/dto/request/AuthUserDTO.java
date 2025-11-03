package br.com.nulog.bros.user.domain.dto.request;


public record AuthUserDTO(
        String nickname,
        String password
) {
}
