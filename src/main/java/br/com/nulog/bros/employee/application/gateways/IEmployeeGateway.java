package br.com.nulog.bros.employee.application.gateways;

import br.com.nulog.bros.employee.domain.dto.request.UpdateEmployeeRequest;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.shared.dto.PageParams;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IEmployeeGateway {
    Employee create(Employee employee);
    Page<Employee> listEmployees(PageParams params);
    Employee update(Employee employee);
    Employee findById(UUID id);

}
