//package br.com.ds.core.userconfig.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull(message = "Role name is required")
//    private String roleName;
//
//    @ManyToOne
//    @JoinColumn(unique = true)
//    private Account account;
//}
