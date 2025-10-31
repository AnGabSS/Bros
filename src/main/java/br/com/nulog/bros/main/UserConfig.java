package br.com.nulog.bros.main;
import br.com.nulog.bros.user.application.gateways.UserGateway;
import br.com.nulog.bros.user.application.usecases.CreateUserUseCase;
import br.com.nulog.bros.user.application.usecases.ListUsersUseCase;
import br.com.nulog.bros.user.infra.gateways.UserEntityMapper;
import br.com.nulog.bros.user.infra.gateways.UserRepositoryGateway;
import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    @Bean
    CreateUserUseCase createUserCase(UserGateway userGateway) {
        return new CreateUserUseCase(userGateway);
    }

    @Bean
    ListUsersUseCase listUsersUseCase(UserGateway userGateway){
        return new ListUsersUseCase(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        return new UserRepositoryGateway(userRepository, userEntityMapper, passwordEncoder);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

}