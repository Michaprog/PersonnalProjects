package com.yourcompany.mygas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "gas_station")
public class GasStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Link to location
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalTime openingHours;
    private LocalTime closingHours;
    private String phoneNumber;
    private String email;
    private String website;
    @Lob
    private String photo;

    // One gas station can have many fuels available
    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL)
    private List<GasStationFuel> fuels;

    // One gas station can have many reviews
    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Constructors, getters, and setters...
}
