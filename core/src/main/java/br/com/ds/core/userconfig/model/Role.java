package br.com.techis.soscitadel.userconfig.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_role_id_seq")
    private Integer id;

    @NotNull(message = "Role name is required")
    private String roleName;

    @Lazy
    @ManyToMany
    private List<Account> account;
}
