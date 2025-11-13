package br.com.nulog.bros.employee.domain.dto.response;

import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.employee.domain.model.EmployeeType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateEmployeeResponse(
        int organizationGroup,
        int company,
        int branch,
        int unit,
        String cpfcnpj,
        EmployeeType type,
        String driverLicense,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDate entranceAt
){
    public static CreateEmployeeResponse fromEmployee(Employee employee){
        return new CreateEmployeeResponse(
                employee.organizationGroup(),
                employee.company(),
                employee.branch(),
                employee.unit(),
                employee.cpfcnpj(),
                employee.type(),
                employee.driverLicense(),
                employee.name(),
                employee.email(),
                employee.createdAt(),
                employee.entranceAt()
        );
    }
}
