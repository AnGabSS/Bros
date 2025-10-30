package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.application.gateways.UserGateway;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.infra.persistence.entity.UserEntity;
import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedEntity);
    }

    @Override
    public Page<User> listUsers(PageParams params) {
        PageRequest pageRequest = PageRequest.of(params.page(), params.size(), Sort.Direction.valueOf(params.direction()), params.orderBy());
        Page<UserEntity> pageEntity = userRepository.findAllByNameContainingIgnoreCase(pageRequest, params.search());


        return pageEntity.map(userEntityMapper::toDomainObj);
    }

}