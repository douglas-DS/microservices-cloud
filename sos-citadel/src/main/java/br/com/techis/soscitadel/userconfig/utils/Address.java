package br.com.techis.soscitadel.userconfig.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_id_seq")
    private Integer id;

    @NotNull(message = "Primary is required")
    private String primary;

    @NotNull(message = "Secondary is required")
    private String secondary;

    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotNull(message = "Country is required")
    @Max(2)
    private String country;

    @NotNull(message = "Postal code is required")
    @Max(8)
    private String postalCode;

    private Double latitude;
    private Double longitude;
}
