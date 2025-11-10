package br.com.nulog.bros.user.infra.persistence.repository;

import br.com.nulog.bros.user.infra.persistence.entity.UserEntity;
import br.com.nulog.bros.user.infra.persistence.entity.UserEntityId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UserEntityId> {

    Page<UserEntity> findAllByNameContainingIgnoreCaseAndIsActive(Pageable pageable , String nameSearch, boolean isActive);
    Optional<UserEntity> findByNickname(String email);
    Optional<UserEntity> findById(UUID id);

}
