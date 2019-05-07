package br.com.ds.core.userrole.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "user_role")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "user_role_user_role_id_seq", sequenceName = "user_role_user_role_id_seq", allocationSize = 1)
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_user_role_id_seq")
    @Column(name = "user_role_id")
    private Long id;

    @Column(name = "user_role_name")
    @NotNull(message = "Role name is required")
    private String name;
}
