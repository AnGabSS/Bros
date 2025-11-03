package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.user.application.gateways.IAuthenticationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RequiredArgsConstructor
public class AuthenticationGatewayImpl implements IAuthenticationGateway {

    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication authenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(email, password);

        return authenticationManager.authenticate(authToken);
    }
}