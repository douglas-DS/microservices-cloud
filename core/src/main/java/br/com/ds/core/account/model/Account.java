package br.com.ds.core.account.model;

import br.com.ds.core.address.model.Address;
import br.com.ds.core.role.model.Role;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "account")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "account_account_id_seq", sequenceName = "account_account_id_seq", allocationSize = 1)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_account_id_seq")
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_email")
    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @Column(name = "account_created_on")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @DateTimeFormat
    private Date createdOn;

    @Column(name = "account_name")
    @NotNull(message = "Name is required")
    private String name;

    @Column(name = "account_nickname")
    @NotNull(message = "Nickname is required")
    private String nickName;

    @Column(name = "account_identification")
    @CPF
    @CNPJ
    @NotNull(message = "Identification is required")
    private String identification;

    @Column(name = "account_cellphone")
    private String cellPhone;

    @Column(name = "account_phone")
    private String phone;


    @OneToOne
    @JoinColumn(name = "account_address_id")
    private Address accountAddress;

    @ManyToMany
    @JoinTable(
            name = "account_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Role> role;
}
