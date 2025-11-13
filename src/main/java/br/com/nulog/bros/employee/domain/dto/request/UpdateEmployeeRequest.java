package br.com.nulog.bros.employee.domain.dto.request;

import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.employee.domain.model.EmployeeType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateEmployeeRequest(
        int organizationGroup,
        int company,
        int branch,
        int unit,
        String cpfcnpj,
        EmployeeType type,
        String driverLicense,
        String name,
        String email,
        LocalDate entranceAt) {
    public static Employee toEmployee(UpdateEmployeeRequest request){
        return new Employee(
                request.organizationGroup(),
                request.company(),
                request.branch(),
                request.unit(),
                UUID.randomUUID(),
                request.cpfcnpj(),
                request.type(),
                request.driverLicense(),
                request.name(),
                request.email(),
                LocalDateTime.now(),
                request.entranceAt(),
                null
        );
    }

}
