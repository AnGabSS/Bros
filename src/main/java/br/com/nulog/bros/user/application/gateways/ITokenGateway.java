package br.com.nulog.bros.user.application.gateways;

import br.com.nulog.bros.user.domain.model.User;

public interface ITokenGateway {
    String generateToken(User user);
    String getSubjectFromToken(String token);
}
