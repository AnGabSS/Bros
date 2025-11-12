package br.com.nulog.bros.employee.domain.dto;


import java.util.UUID;

public record EmployeeID (
        int organizationGroup,
        int company,
        int branch,
        int unit, UUID id
){
}
