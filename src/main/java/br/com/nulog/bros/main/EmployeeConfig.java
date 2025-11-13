package br.com.nulog.bros.main;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.application.usecases.CreateEmployeeUseCase;
import br.com.nulog.bros.employee.application.usecases.ListEmployeesUseCase;
import br.com.nulog.bros.employee.infra.gateways.EmployeeEntityMapper;
import br.com.nulog.bros.employee.infra.gateways.EmployeeGatewayImpl;
import br.com.nulog.bros.employee.infra.persistence.repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    CreateEmployeeUseCase createEmployeeUseCase(IEmployeeGateway gateway){
        return new CreateEmployeeUseCase(gateway);
    }

    @Bean
    ListEmployeesUseCase listEmployeesUseCase(IEmployeeGateway gateway){ return new ListEmployeesUseCase(gateway); }
    @Bean
    IEmployeeGateway employeeGateway(EmployeeRepository repository, EmployeeEntityMapper entityMapper){
        return new EmployeeGatewayImpl(repository, entityMapper);
    }

    @Bean
    EmployeeEntityMapper employeeEntityMapper(){
        return new EmployeeEntityMapper();
    }
}
