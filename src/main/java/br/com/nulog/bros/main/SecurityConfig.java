package br.com.nulog.bros.main;

import br.com.nulog.bros.shared.config.BrosConfiguration;
import br.com.nulog.bros.shared.config.security.JwtTokenService;
import br.com.nulog.bros.shared.config.security.SecurityConfiguration;
import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityConfiguration securityConfiguration(JwtTokenService jwtTokenService, UserRepository userRepository, BrosConfiguration configuration){
        return new SecurityConfiguration(jwtTokenService, userRepository, configuration);
    }
    @Bean
    JwtTokenService jwtTokenService(BrosConfiguration configuration){
        return new JwtTokenService(configuration);
    }

}
