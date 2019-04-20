//package br.com.ds.core.userconfig.model;
//
//import br.com.ds.core.userconfig.util.Address;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.validator.constraints.br.CNPJ;
//import org.hibernate.validator.constraints.br.CPF;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Email
//    @NotBlank(message = "Email is required")
//    private String email;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date createdOn;
//
//    @NotNull(message = "Name is required")
//    private String name;
//
//    @NotNull(message = "Nickname is required")
//    private String nickName;
//
//    @CPF
//    @CNPJ
//    @NotNull(message = "Identification is required")
//    private String identification;
//
//    private String cellPhone;
//    private String phone;
//
//    @OneToOne
//    @JoinColumn(unique = true)
//    private Address address;
//
////    @OneToMany
////    private List<User> user;
////
////    @OneToMany
////    @JoinColumn
////    private List<Role> role;
//}
