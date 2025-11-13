package br.com.nulog.bros.employee.application.usecases;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.domain.model.Employee;

public class CreateEmployeeUseCase {

    private final IEmployeeGateway gateway;

    public CreateEmployeeUseCase(IEmployeeGateway gateway){
        this.gateway = gateway;
    }

    public Employee execute(Employee employee){
        return gateway.create(employee);
    }
}
