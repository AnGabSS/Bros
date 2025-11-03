package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.shared.dto.PageParams;
import br.com.nulog.bros.user.application.gateways.IUserGateway;
import br.com.nulog.bros.user.domain.model.User;
import br.com.nulog.bros.user.infra.persistence.entity.UserEntity;
import br.com.nulog.bros.user.infra.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserGatewayImpl implements IUserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        userEntity.setPassword(passwordEncoder.encode(userDomainObj.password()));
        UserEntity savedEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedEntity);
    }

    @Override
    public Page<User> listUsers(PageParams params) {
        PageRequest pageRequest = PageRequest.of(params.page(), params.size(), Sort.Direction.valueOf(params.direction()), params.orderBy());
        Page<UserEntity> pageEntity = userRepository.findAllByNameContainingIgnoreCase(pageRequest, params.search());


        return pageEntity.map(userEntityMapper::toDomainObj);
    }

    @Override
    public User findByNickname(String nickname) {
        UserEntity user = userRepository.findByNickname(nickname).orElseThrow(
                () -> new RuntimeException("User with nickname " + nickname + " not found")
        );
        return userEntityMapper.toDomainObj(user);
    }

}