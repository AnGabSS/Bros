package br.com.nulog.bros.employee.infra.gateways;

import br.com.nulog.bros.employee.application.gateways.IEmployeeGateway;
import br.com.nulog.bros.employee.domain.dto.request.UpdateEmployeeRequest;
import br.com.nulog.bros.employee.domain.model.Employee;
import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntity;
import br.com.nulog.bros.employee.infra.persistence.repository.EmployeeRepository;
import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.shared.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;
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

    @Override
    public Page<Employee> listEmployees(PageParams params) {
        PageRequest pageRequest = PageRequest.of(params.page(), params.size(), Sort.Direction.valueOf(params.direction()), params.orderBy());
        Page<EmployeeEntity> pageEntity = repository.findAllByNameContainingIgnoreCase(pageRequest, params.search());

        return pageEntity.map(entityMapper::toDomainObj);
    }

    @Override
    public Employee update(Employee employee) {
        EmployeeEntity entityToUpdate = repository.findById(employee.id())
                .orElseThrow(() -> new NotFoundException("Employee with id " + employee.id() + " not found"));

        entityToUpdate.setOrganizationGroup(employee.organizationGroup());
        entityToUpdate.setCompany(employee.company());
        entityToUpdate.setBranch(employee.branch());
        entityToUpdate.setUnit(employee.unit());

        entityToUpdate.setCpfcnpj(employee.cpfcnpj());
        entityToUpdate.setType(employee.type());
        entityToUpdate.setDriverLicense(employee.driverLicense());
        entityToUpdate.setName(employee.name());
        entityToUpdate.setEmail(employee.email());
        entityToUpdate.setEntranceAt(employee.entranceAt());
        entityToUpdate.setExitAt(employee.exitAt());


        EmployeeEntity savedEntity = repository.save(entityToUpdate);
        return entityMapper.toDomainObj(savedEntity);
    }

    @Override
    public Employee findById(UUID id) {
        EmployeeEntity entiy = repository.findById(id).orElseThrow(() -> new NotFoundException("Employee with id " + id + " not found"));
        return entityMapper.toDomainObj(entiy);
    }

}
