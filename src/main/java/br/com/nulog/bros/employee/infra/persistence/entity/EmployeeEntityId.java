package br.com.nulog.bros.employee.infra.persistence.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeEntityId {
    private int organizationGroup;
    private int company;
    private int branch;
    private int unit;
    private UUID id;

}
