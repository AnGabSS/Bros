package br.com.nulog.bros.employee.infra.persistence.repository;

import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntity;
import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeeEntityId> {
}
