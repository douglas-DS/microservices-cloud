package br.com.ds.core.address.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address_primary")
    @NotNull(message = "Primary is required")
    private String primary;

    @Column(name = "address_secondary")
    @NotNull(message = "Secondary is required")
    private String secondary;

    @Column(name = "address_city")
    @NotNull(message = "City is required")
    private String city;

    @Column(name = "address_state")
    @NotNull(message = "State is required")
    private String state;

    @Column(name = "address_country")
    @NotNull(message = "Country is required")
    @Size(min = 2, max = 2)
    private String country;

    @Column(name = "address_latitude")
    private Double latitude;

    @Column(name = "address_longitude")
    private Double longitude;

    @Column(name = "address_postalcode")
    @NotNull(message = "Postal code is required")
    @Size(min = 8, max = 8)
    private String postalCode;
}
