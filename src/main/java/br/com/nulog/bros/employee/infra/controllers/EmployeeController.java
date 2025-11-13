package br.com.nulog.bros.employee.infra.controllers;

import br.com.nulog.bros.employee.application.usecases.CreateEmployeeUseCase;
import br.com.nulog.bros.employee.application.usecases.ListEmployeesUseCase;
import br.com.nulog.bros.employee.application.usecases.UpdateEmployeeUseCase;
import br.com.nulog.bros.employee.domain.dto.request.CreateEmployeeRequest;
import br.com.nulog.bros.employee.domain.dto.request.UpdateEmployeeRequest;
import br.com.nulog.bros.employee.domain.dto.response.CreateEmployeeResponse;
import br.com.nulog.bros.employee.domain.dto.response.ListEmployeeResponse;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.domain.dto.response.ListUserResponse;
import br.com.nulog.bros.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final ListEmployeesUseCase listEmployeesUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;

    public EmployeeController(CreateEmployeeUseCase createEmployeeUseCase, ListEmployeesUseCase listEmployeesUseCase, UpdateEmployeeUseCase updateEmployeeUseCase){
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.listEmployeesUseCase = listEmployeesUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;

    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> create(@RequestBody CreateEmployeeRequest request){
        Employee employeeCreated = createEmployeeUseCase.execute(CreateEmployeeRequest.toEmployee(request));
        return ResponseEntity.status(201).body(CreateEmployeeResponse.fromEmployee(employeeCreated));
    }

    @GetMapping
    public ResponseEntity<Page<ListEmployeeResponse>> list(
            @RequestParam(value = "search", defaultValue = "") String search,

            @RequestParam(value = "page", defaultValue = "0") int page,

            @RequestParam(value = "size", defaultValue = "10") int size,

            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,

            @RequestParam(value = "direction", defaultValue = "ASC") String direction
            ){
        Page<Employee> employee = listEmployeesUseCase.execute(new PageParams(search, page, size, orderBy, direction, true));
        return ResponseEntity.ok(employee.map(ListEmployeeResponse::fromEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateEmployeeResponse> update(
            @PathVariable("id")UUID id,
            @RequestBody UpdateEmployeeRequest request
            ){
        Employee employeeUpdated = updateEmployeeUseCase.execute(id, request);
        return ResponseEntity.ok(CreateEmployeeResponse.fromEmployee(employeeUpdated));
    }
}
