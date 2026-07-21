package br.com.nulog.bros.user.application.usecases;

import br.com.nulog.bros.user.application.gateways.IAuthenticationGateway;
import br.com.nulog.bros.user.application.gateways.ITokenGateway;
import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.dto.request.AuthUserDTO;
import br.com.nulog.bros.user.domain.dto.response.RecoveryJwtTokenDTO;
import br.com.nulog.bros.user.domain.model.User;

public class LoginUseCase {

    private final IAuthenticationGateway authGateway;
    private final IUserGateway userGateway;
    private final ITokenGateway tokenGateway;

    public LoginUseCase(IAuthenticationGateway authGateway, IUserGateway userGateway, ITokenGateway tokenGateway){
        this.authGateway = authGateway;
        this.userGateway = userGateway;
        this.tokenGateway = tokenGateway;
    }

    public RecoveryJwtTokenDTO execute(AuthUserDTO dto){
        authGateway.authenticate(dto.nickname(), dto.password());

        User user = userGateway.findByNickname(dto.nickname());

        return new RecoveryJwtTokenDTO(tokenGateway.generateToken(user));
    }
}
