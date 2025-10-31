package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.infra.persistence.entity.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomainObj) {
        return UserEntity.builder()
                .id(userDomainObj.id())
                .name(userDomainObj.name())
                .email(userDomainObj.email())
                .unit(userDomainObj.unit())
                .branch(userDomainObj.branch())
                .company(userDomainObj.company())
                .cpfcnpj(userDomainObj.cpfcnpj())
                .createdAt(userDomainObj.createdAt())
                .nickname(userDomainObj.nickname())
                .organizationGroup(userDomainObj.organizationGroup())
                .password(userDomainObj.password())
                .isActive(userDomainObj.isActive())
                .build();
    }

    User toDomainObj(UserEntity entity){
            return new User(
                    entity.getOrganizationGroup(),
                    entity.getCompany(),
                    entity.getBranch(),
                    entity.getUnit(),
                    entity.getId(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getPassword(),
                    entity.getCreatedAt(),
                    entity.getCpfcnpj(),
                    entity.getNickname(),
                    entity.isActive()
            );
    }

}
