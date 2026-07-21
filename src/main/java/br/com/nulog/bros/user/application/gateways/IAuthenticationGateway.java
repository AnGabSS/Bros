package br.com.nulog.bros.user.application.gateways;

import org.springframework.security.core.Authentication;

public interface IAuthenticationGateway {
    Authentication authenticate(String email, String password);
}
