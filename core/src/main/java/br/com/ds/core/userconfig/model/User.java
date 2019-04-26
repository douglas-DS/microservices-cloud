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
