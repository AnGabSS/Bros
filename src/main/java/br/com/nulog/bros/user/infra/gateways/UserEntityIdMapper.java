package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.user.domain.model.UserId;
import br.com.nulog.bros.user.infra.persistence.entity.UserEntityId;

public class UserEntityIdMapper {
    UserEntityId toEntity(UserId id){
        return new UserEntityId(id.organizationGroup(), id.company(), id.branch(), id.unit(), id.id());
    }
}
