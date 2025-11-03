package br.com.nulog.bros.user.infra.service;

// 1. Corrigido para "LoadUserByNicknameUseCase"
import br.com.nulog.bros.user.application.usecases.LoadUserByNicknameUseCase;
import br.com.nulog.bros.user.domain.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoadUserByNicknameUseCase loadUserUseCase;

    public CustomUserDetailsService(LoadUserByNicknameUseCase loadUserUseCase) {
        this.loadUserUseCase = loadUserUseCase;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        User userDomain = loadUserUseCase.execute(nickname);

        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();


        return new org.springframework.security.core.userdetails.User(
                userDomain.nickname(),
                userDomain.password(),
                authorities
        );
    }
}