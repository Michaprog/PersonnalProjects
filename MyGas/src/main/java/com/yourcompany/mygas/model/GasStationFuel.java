package com.yourcompany.mygas.model;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "gas_station_fuel")
@IdClass(GasStationFuelId.class)
public class GasStationFuel {

    @Id
    @ManyToOne
    @JoinColumn(name = "gas_station_id")
    private GasStation gasStation;

    @Id
    private String fuelType;

    private BigDecimal price;

    // Constructors, getters, and setters...
}
