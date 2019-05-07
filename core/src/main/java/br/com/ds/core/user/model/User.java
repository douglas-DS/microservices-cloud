<<<<<<< HEAD:core/src/main/java/br/com/ds/core/user/model/User.java
package br.com.ds.core.user.model;

import br.com.ds.core.account.model.Account;
import br.com.ds.core.userrole.model.UserRole;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "user")
@Table(name = "\"user\"")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "user_user_id_seq", sequenceName = "user_user_id_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_user_id_seq")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email")
    @Email
    @NotBlank
    @NotNull(message = "Email is required")
    private String email;

    @Column(name = "user_password")
    @NotBlank
    @NotNull(message = "Password is required")
    private String password;

    @Column(name = "user_nickname")
    @NotNull(message = "Nickname is required")
    private String nickname;

    @Column(name = "user_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @DateTimeFormat
    private Date createDate;

    @Column(name = "user_last_login")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat
    private Date lastLogin;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private Account account;

    @Column(name = "user_cellphone")
    private String cellPhone;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
}
=======
package br.com.ds.core.userconfig.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @Email
    @NotEmpty
    @NotNull(message = "Email is required")
    private String email;

    @NotEmpty
    @NotNull(message = "Password is required")
    private String password;

    @JsonIgnore
//    @NotNull
    private String nickname;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @DateTimeFormat
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat
    private Date lastLogin;

//    @ManyToOne
//    @JoinColumn(unique = true)
//    private Account account;

    private String cellPhone;

    @ManyToOne
    private UserRole userRole;
}
>>>>>>> ed0afcd1793d0207eabebbdbd882d1a71ffa5098:core/src/main/java/br/com/ds/core/userconfig/model/User.java
