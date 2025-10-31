package br.com.nulog.bros.shared.config.security.service;

import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        return (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}