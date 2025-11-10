package br.com.nulog.bros.main;

import br.com.nulog.bros.shared.config.BrosConfiguration;
import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.application.usecases.*;
import br.com.nulog.bros.user.infra.config.SecurityConfiguration;
import br.com.nulog.bros.user.infra.gateways.*;
import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import br.com.nulog.bros.user.application.gateways.IAuthenticationGateway;
import br.com.nulog.bros.user.application.gateways.ITokenGateway;
import br.com.nulog.bros.user.infra.service.JwtTokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {


    @Bean
    CreateUserUseCase createUserCase(IUserGateway userGateway) {
        return new CreateUserUseCase(userGateway);
    }

    @Bean
    ListUsersUseCase listUsersUseCase(IUserGateway userGateway){
        return new ListUsersUseCase(userGateway);
    }

    @Bean
    IUserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder, UserEntityIdMapper userEntityIdMapper) {
        return new UserGatewayImpl(userRepository, userEntityMapper,userEntityIdMapper, passwordEncoder);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserEntityIdMapper userEntityIdMapper(){
        return new UserEntityIdMapper();
    }

    @Bean
    LoginUseCase loginUseCase(
            IAuthenticationGateway authGateway,
            IUserGateway userGateway,
            ITokenGateway tokenGateway) {
        return new LoginUseCase(authGateway, userGateway, tokenGateway);
    }

    @Bean
    LoadUserByNicknameUseCase loadUserByEmailUseCase(IUserGateway userGateway) {
        return new LoadUserByNicknameUseCase(userGateway);
    }

    @Bean
    UpdateUserUseCase updateUserUseCase(IUserGateway userGateway){
        return new UpdateUserUseCase(userGateway);
    }

    @Bean
    InactivateUserUseCase deleteUserUseCase(IUserGateway userGateway){
        return new InactivateUserUseCase(userGateway);
    }

    @Bean
    FindUserByIdUseCase findUserByIdUseCase(IUserGateway userGateway){
        return new FindUserByIdUseCase(userGateway);
    }

    @Bean
    IAuthenticationGateway authenticationGateway(AuthenticationManager authenticationManager) {

        return new AuthenticationGatewayImpl(authenticationManager);
    }

    @Bean
    ITokenGateway tokenGateway(BrosConfiguration brosConfiguration) {
        return new TokenGatewayImpl(brosConfiguration);
    }

    @Bean
    SecurityConfiguration securityConfiguration(JwtTokenService jwtTokenService, UserRepository userRepository, BrosConfiguration configuration){
        return new SecurityConfiguration(jwtTokenService, userRepository, configuration);
    }
    @Bean
    JwtTokenService jwtTokenService(BrosConfiguration configuration){
        return new JwtTokenService(configuration);
    }

}