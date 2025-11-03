package br.com.nulog.bros.user.infra.controllers;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.application.usecases.CreateUserUseCase;
import br.com.nulog.bros.user.application.usecases.ListUsersUseCase;
import br.com.nulog.bros.user.application.usecases.LoginUseCase;
import br.com.nulog.bros.user.domain.dto.request.AuthUserDTO;
import br.com.nulog.bros.user.domain.dto.request.CreateUserRequest;
import br.com.nulog.bros.user.domain.dto.response.CreateUserResponse;
import br.com.nulog.bros.user.domain.dto.response.ListUserResponse;
import br.com.nulog.bros.user.domain.dto.response.RecoveryJwtTokenDTO;
import br.com.nulog.bros.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody AuthUserDTO dto) {
        try{
            RecoveryJwtTokenDTO token = loginUseCase.execute(dto);
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException | InternalAuthenticationServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nickname or password is incorrect");
        }
    }

}