package br.com.nulog.bros.employee.application.gateway;

import br.com.nulog.bros.employee.domain.model.Employee;

public interface IEmployeeGateway {
    Employee create(Employee employee);
}
