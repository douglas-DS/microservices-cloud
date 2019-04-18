package br.com.techis.soscitadel.userconfig.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_user_id_seq")
    @NotNull(message = "Id is required")
    private Integer id;

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Nickname is required")
    private String nickname;

    @CreationTimestamp
    @DateTimeFormat
    private LocalDateTime createdDate;

    @DateTimeFormat
    private LocalDateTime lastLogin;

    @ManyToOne
    private Account account;

    private String cellPhone;

    @ManyToOne
    private UserRole userRole;
}
