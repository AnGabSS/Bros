package br.com.nulog.bros.employee.application.usecases;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.domain.dto.request.UpdateEmployeeRequest;
import br.com.nulog.bros.employee.domain.model.Employee;

import java.util.Objects;
import java.util.UUID;

public class UpdateEmployeeUseCase {
    private final IEmployeeGateway gateway;

    public UpdateEmployeeUseCase(IEmployeeGateway gateway){
        this.gateway = gateway;
    }

    public Employee execute(UUID id, UpdateEmployeeRequest employeeRequest){
        Employee actualEmployee = gateway.findById(id);

        Employee updatedEmployee = new Employee(
                Objects.requireNonNullElse(employeeRequest.organizationGroup(), actualEmployee.organizationGroup()),
                Objects.requireNonNullElse(employeeRequest.company(), actualEmployee.company()),
                Objects.requireNonNullElse(employeeRequest.branch(), actualEmployee.branch()),
                Objects.requireNonNullElse(employeeRequest.unit(), actualEmployee.unit()),

                actualEmployee.id(),

                Objects.requireNonNullElse(employeeRequest.cpfcnpj(), actualEmployee.cpfcnpj()),
                Objects.requireNonNullElse(employeeRequest.type(), actualEmployee.type()),
                Objects.requireNonNullElse(employeeRequest.driverLicense(), actualEmployee.driverLicense()),
                Objects.requireNonNullElse(employeeRequest.name(), actualEmployee.name()),
                Objects.requireNonNullElse(employeeRequest.email(), actualEmployee.email()),

                actualEmployee.createdAt(),

                Objects.requireNonNullElse(employeeRequest.entranceAt(), actualEmployee.entranceAt()),
                Objects.requireNonNullElse(employeeRequest.exitAt(), actualEmployee.exitAt())
        );

        return gateway.update(updatedEmployee);
    }
}