package br.com.nulog.bros.user.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserEntityId.class)
public class UserEntity {

    @Id
    @Column(name = "organization_group", nullable = false, updatable = false)
    private int organizationGroup;

    @Id
    @Column(name = "company", nullable = false, updatable = false)
    private int company;

    @Id
    @Column(name = "branch", nullable = false, updatable = false)
    private int branch;

    @Id
    @Column(name = "unit", nullable = false, updatable = false)
    private int unit;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "cpf_cnpj", unique = true)
    private String cpfcnpj;

    @Column(name = "nickname")
    private String nickname;
}