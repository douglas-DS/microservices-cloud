//package br.com.ds.core.userconfig.util;
//
//import br.com.ds.core.userconfig.model.Account;
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
//@AllArgsConstructor
//@NoArgsConstructor
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull(message = "Primary is required")
//    private String primary;
//
//    @NotNull(message = "Secondary is required")
//    private String secondary;
//
//    @NotNull(message = "City is required")
//    private String city;
//
//    @NotNull(message = "State is required")
//    private String state;
//
//    @NotNull(message = "Country is required")
////    @Max(2)
////    @Size(min = 2, max = 2)
//    private String country;
//
//    @NotNull(message = "Postal code is required")
////    @Size(min = 8, max = 8)
//    private String postalCode;
//
//    private Long latitude;
//    private Long longitude;
//
//}
