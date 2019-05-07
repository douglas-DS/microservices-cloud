<<<<<<< HEAD:core/src/main/java/br/com/ds/core/userrole/model/UserRole.java
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
=======
package br.com.ds.core.userconfig.model;

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
    @SequenceGenerator(name = "user_role_gen", sequenceName = "user_role_id_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "Role name is required")
    private UserRoleName name;
}
>>>>>>> ed0afcd1793d0207eabebbdbd882d1a71ffa5098:core/src/main/java/br/com/ds/core/userconfig/model/UserRole.java
