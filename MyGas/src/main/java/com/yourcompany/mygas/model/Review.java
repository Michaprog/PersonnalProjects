package com.yourcompany.mygas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many reviews from one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Many reviews for one gas station
    @ManyToOne
    @JoinColumn(name = "gas_station_id")
    private GasStation gasStation;

    private short rating;
    @Lob
    private String comment;
    private LocalDate date = LocalDate.now();

    // Constructors, getters, and setters...
}
