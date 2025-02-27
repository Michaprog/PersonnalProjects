package com.yourcompany.mygas.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Getters and setters
    // (Or use Lombok @Data to reduce boilerplate)

    // Constructors, getters, and setters...
}
