package br.com.nulog.bros.user.infra.controllers;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.application.usecases.CreateUserUseCase;
import br.com.nulog.bros.user.application.usecases.InactivateUserUseCase;
import br.com.nulog.bros.user.application.usecases.ListUsersUseCase;
import br.com.nulog.bros.user.application.usecases.UpdateUserUseCase;
import br.com.nulog.bros.user.domain.dto.request.CreateUserRequest;
import br.com.nulog.bros.user.domain.dto.request.UpdateUserRequest;
import br.com.nulog.bros.user.domain.dto.response.CreateUserResponse;
import br.com.nulog.bros.user.domain.dto.response.ListUserResponse;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.domain.model.UserId;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final InactivateUserUseCase inactivateUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, ListUsersUseCase listUsersUseCase, InactivateUserUseCase inactivateUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.inactivateUserUseCase = inactivateUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        User userBusinessObj = CreateUserRequest.toUser(request);
        User user = createUserUseCase.execute(userBusinessObj);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(CreateUserResponse.fromUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<ListUserResponse>> list(
            @RequestParam(value = "search", defaultValue = "") String search,

            @RequestParam(value = "page", defaultValue = "0") int page,

            @RequestParam(value = "size", defaultValue = "10") int size,

            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,

            @RequestParam(value = "direction", defaultValue = "ASC") String direction,

            @RequestParam(value = "isActive", defaultValue = "true") boolean isActive
    ){
        Page<User> users = listUsersUseCase.execute(new PageParams(search, page, size, orderBy, direction, isActive));
        return ResponseEntity.ok(users.map(ListUserResponse::fromUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateUserResponse> updateUser(@PathVariable("id") UUID id, @RequestBody UpdateUserRequest request){
        User userUpdate = updateUserUseCase.execute(id, request);
        return ResponseEntity.ok(CreateUserResponse.fromUser(userUpdate));
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(UserId id){
        return ResponseEntity.ok(inactivateUserUseCase.execute(id));
    }
}