package br.com.nulog.bros.user.infra.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntityId implements Serializable {

    private int organizationGroup;
    private int company;
    private int branch;
    private int unit;
    private UUID id;

}