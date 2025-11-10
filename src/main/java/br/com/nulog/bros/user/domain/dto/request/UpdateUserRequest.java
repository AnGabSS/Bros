package br.com.nulog.bros.user.domain.dto.request;

public record UpdateUserRequest (
        int organizationGroup,
        int company,
        int branch,
        int unit,
        String name,
        String email,
        String cpfcnpj,
        String nickname
) {
}
