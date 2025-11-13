package br.com.nulog.bros.employee.application.usecases;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.shared.dto.PageParams;
import org.springframework.data.domain.Page;

public class ListEmployeesUseCase {

    private final IEmployeeGateway gateway;

    public ListEmployeesUseCase(IEmployeeGateway gateway){
        this.gateway = gateway;
    }

    public Page<Employee> execute(PageParams params){
        return gateway.listEmployees(params);
    }
}
