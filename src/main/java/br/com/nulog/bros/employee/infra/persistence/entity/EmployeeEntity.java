package br.com.nulog.bros.employee.infra.persistence.entity;


import br.com.nulog.bros.employee.domain.model.EmployeeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EmployeeEntityId.class)
public class EmployeeEntity {
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

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpfcnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EmployeeType type;

    @Column(name = "driver_license", unique = true)
    private String driverLicense;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "entrance_at", nullable = false)
    private LocalDate entranceAt;

    @Column(name = "exit_at", nullable = true)
    private LocalDate exitAt;
}
