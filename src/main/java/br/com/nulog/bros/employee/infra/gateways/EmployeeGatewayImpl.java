package br.com.nulog.bros.employee.infra.gateways;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntity;
import br.com.nulog.bros.employee.infra.persistence.repository.EmployeeRepository;

import java.util.UUID;

public class EmployeeGatewayImpl implements IEmployeeGateway {
    private final EmployeeRepository repository;
    private final EmployeeEntityMapper entityMapper;

    public EmployeeGatewayImpl(EmployeeRepository repository, EmployeeEntityMapper entityMapper){
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Employee create(Employee employee) {
        EmployeeEntity entity = entityMapper.toEntity(employee);
        EmployeeEntity entitySaved = repository.save(entity);
        return entityMapper.toDomainObj(entitySaved);
    }
}
