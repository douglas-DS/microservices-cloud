package br.com.ds.core.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @Temporal(TIMESTAMP)
    @CreationTimestamp
    @DateTimeFormat
    private Date creationDate;

    @NotNull(message = "Name is required")
    private String name;

    @CPF
    @NotNull(message = "Identification is required")
    private String identification;

    @Column(name = "account_phone")
    private String contactNumber;
}
