package com.yourcompany.mygas.repository;

import com.yourcompany.mygas.model.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GasStationRepository extends JpaRepository<GasStation, Long> {

    public List<GasStation> findAll();

    public Optional<GasStation> findById(Long id);

    public GasStation save(GasStation gasStation);

    public void deleteById(Long id);

}
