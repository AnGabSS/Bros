package br.com.nulog.bros.employee.domain.dto.response;

import br.com.nulog.bros.employee.domain.model.EmployeeType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateEmployeeResponse(
        int organizationGroup,
        int company,
        int branch,
        int unit,
        UUID id,
        String cpfcnpj,
        EmployeeType type,
        String driverLicense,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDate entranceAt,
        LocalDate exitAt
){

}
