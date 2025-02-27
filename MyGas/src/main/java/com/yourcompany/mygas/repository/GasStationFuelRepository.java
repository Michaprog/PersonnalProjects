package com.yourcompany.mygas.repository;

import com.yourcompany.mygas.model.GasStationFuel;
import com.yourcompany.mygas.model.GasStationFuelId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GasStationFuelRepository extends JpaRepository<GasStationFuel, GasStationFuelId> {

    public void deleteById(Long id);

    public List<GasStationFuel> findAll();

    public Optional<GasStationFuel> findById(GasStationFuelId id);

    public GasStationFuel save(GasStationFuel gasStationFuel);

}
