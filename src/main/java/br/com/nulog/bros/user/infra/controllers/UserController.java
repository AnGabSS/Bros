package br.com.nulog.bros.user.infra.controllers;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.application.usecases.CreateUserUseCase;
import br.com.nulog.bros.user.application.usecases.ListUsersUseCase;
import br.com.nulog.bros.user.domain.dto.request.CreateUserRequest;
import br.com.nulog.bros.user.domain.dto.response.CreateUserResponse;
import br.com.nulog.bros.user.domain.dto.response.ListUserResponse;
import br.com.nulog.bros.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;

    public UserController(CreateUserUseCase createUserUseCase, ListUsersUseCase listUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User userBusinessObj = CreateUserRequest.toUser(request);
        User user = createUserUseCase.execute(userBusinessObj);
        return CreateUserResponse.fromUser(user);
    }

    @GetMapping
    public ResponseEntity<Page<ListUserResponse>> list(
            @RequestParam(value = "search", defaultValue = "") String search,

            @RequestParam(value = "page", defaultValue = "0") int page,

            @RequestParam(value = "size", defaultValue = "10") int size,

            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,

            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){
        Page<User> users = listUsersUseCase.execute(new PageParams(search, page, size, orderBy, direction));
        return ResponseEntity.ok(users.map(ListUserResponse::fromUser));
    }
}