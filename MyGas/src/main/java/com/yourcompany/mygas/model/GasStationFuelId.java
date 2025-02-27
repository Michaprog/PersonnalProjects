package com.yourcompany.mygas.model;

import java.io.Serializable;
import java.util.Objects;

public class GasStationFuelId implements Serializable {
    private Long gasStation;
    private String fuelType;

    public GasStationFuelId() {}

    public GasStationFuelId(Long gasStation, String fuelType) {
        this.gasStation = gasStation;
        this.fuelType = fuelType;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GasStationFuelId)) return false;
        GasStationFuelId that = (GasStationFuelId) o;
        return Objects.equals(gasStation, that.gasStation) &&
                Objects.equals(fuelType, that.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasStation, fuelType);
    }
}
