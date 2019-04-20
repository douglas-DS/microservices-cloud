package br.com.ds.core.userconfig.model;

import br.com.ds.core.userconfig.util.RoleEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_gen")
    @SequenceGenerator(name = "user_role_gen", sequenceName = "user_role_id_seq")
    private Long id;

    @NotNull(message = "Role name is required")
    private RoleEnum name;
}
