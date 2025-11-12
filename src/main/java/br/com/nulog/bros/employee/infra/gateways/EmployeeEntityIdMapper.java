package br.com.nulog.bros.employee.infra.gateways;

import br.com.nulog.bros.employee.domain.model.EmployeeID;
import br.com.nulog.bros.employee.infra.persistence.entity.EmployeeEntityId;

public class EmployeeEntityIdMapper {
    EmployeeEntityId toEntity(EmployeeID id){
        return new EmployeeEntityId(id.organizationGroup(), id.company(), id.branch(), id.unit(), id.id());
    }
}
