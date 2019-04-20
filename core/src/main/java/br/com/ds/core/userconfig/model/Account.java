package br.com.techis.soscitadel.userconfig.model;

import br.com.techis.soscitadel.userconfig.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_account_id_seq")
    @NotNull(message = "Id is required")
    private Integer id;

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @CreationTimestamp
    @NotNull(message = "Created is required")
    private LocalDateTime createdOn;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Nickname is required")
    private String nickName;

    @CPF
    @CNPJ
    @NotNull(message = "Identification is required")
    private String identification;

    private String cellPhone;
    private String phone;

    @Lazy
    @OneToOne
    private Address address;

    @Lazy
    @ManyToMany
    private List<Role> role;
}
