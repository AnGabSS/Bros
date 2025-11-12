package br.com.nulog.bros.employee.infra.gateways;

import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntity;

public class EmployeeEntityMapper {
    EmployeeEntity toEntity(Employee employeeDomainObj){
        return EmployeeEntity.builder()
                .organizationGroup(employeeDomainObj.organizationGroup())
                .company(employeeDomainObj.company())
                .branch(employeeDomainObj.branch())
                .unit(employeeDomainObj.unit())
                .id(employeeDomainObj.id())
                .name(employeeDomainObj.name())
                .email(employeeDomainObj.email())
                .driverLicense(employeeDomainObj.driverLicense())
                .cpfcnpj(employeeDomainObj.cpfcnpj())
                .type(employeeDomainObj.type())
                .createdAt(employeeDomainObj.createdAt())
                .entranceAt(employeeDomainObj.entranceAt())
                .exitAt(employeeDomainObj.exitAt())
                .build();
    }

    Employee toDomainObj(EmployeeEntity entity){
        return new Employee(
                entity.getOrganizationGroup(),
                entity.getCompany(),
                entity.getBranch(),
                entity.getUnit(),
                entity.getId(),
                entity.getCpfcnpj(),
                entity.getType(),
                entity.getDriverLicense(),
                entity.getName(),
                entity.getEmail(),
                entity.getCreatedAt(),
                entity.getEntranceAt(),
                entity.getExitAt()
        );
    }
}
