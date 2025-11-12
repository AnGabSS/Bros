package br.com.nulog.bros.employee.infra.controllers;

import br.com.nulog.bros.employee.application.usecases.CreateEmployeeUseCase;
import br.com.nulog.bros.employee.domain.dto.request.CreateEmployeeRequest;
import br.com.nulog.bros.employee.domain.dto.response.CreateEmployeeResponse;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.user.application.usecases.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final CreateEmployeeUseCase createEmployeeUseCase;

    public EmployeeController(CreateEmployeeUseCase createEmployeeUseCase){
        this.createEmployeeUseCase = createEmployeeUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> create(@RequestBody CreateEmployeeRequest request){
        Employee employeeCreated = createEmployeeUseCase.execute(CreateEmployeeRequest.toEmployee(request));
        return ResponseEntity.status(201).body(CreateEmployeeResponse.fromEmployee(employeeCreated));
    }
}
