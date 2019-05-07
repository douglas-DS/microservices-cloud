package br.com.ds.core.role.model;

import br.com.ds.core.account.model.Account;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "role")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "role_role_id_seq", sequenceName = "role_role_id_seq", allocationSize = 1)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_role_id_seq")
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    @NotNull(message = "Role name is required")
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Account> account;
}
