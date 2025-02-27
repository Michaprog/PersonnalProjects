package com.yourcompany.mygas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;

    // One user can have many reviews
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private java.util.List<Review> reviews;

    // Constructors, getters, and setters...
}
