package br.com.ds.core.user.model;

import br.com.ds.core.account.model.Account;
import br.com.ds.core.user.role.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "\"user\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Nickname is required")
    private String nickname;

    @Temporal(TIMESTAMP)
    @CreationTimestamp
    @DateTimeFormat
    private Date creationDate;

    @Temporal(TIMESTAMP)
    @DateTimeFormat
    private Date lastLogin;

    @ManyToOne
    private Account account;

    private String contactNumber;

    @ManyToOne(cascade = ALL)
    private UserRole userRole;

    public User(@NotNull User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.creationDate = user.getCreationDate();
        this.lastLogin = user.getLastLogin();
        this.account = user.getAccount();
        this.contactNumber = user.getContactNumber();
        this.userRole = user.getUserRole();
    }
}
