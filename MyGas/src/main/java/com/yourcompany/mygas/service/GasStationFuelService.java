package com.yourcompany.mygas.service;

import com.yourcompany.mygas.model.GasStationFuelId;
import org.springframework.stereotype.Service;
import com.yourcompany.mygas.model.GasStationFuel;
import com.yourcompany.mygas.repository.GasStationFuelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GasStationFuelService {

    public final GasStationFuelRepository gasStationFuelRepository;

    public GasStationFuelService(GasStationFuelRepository gasStationFuelRepository) {
        this.gasStationFuelRepository = gasStationFuelRepository;
    }

    public void deleteById(Long id) {
        gasStationFuelRepository.deleteById(id);
    }

    public List<GasStationFuel> findAll() {
        return gasStationFuelRepository.findAll();
    }

    public Optional<GasStationFuel> findById(GasStationFuelId id) {
        return gasStationFuelRepository.findById(id);
    }

    public GasStationFuel save(GasStationFuel gasStationFuel) {
        return gasStationFuelRepository.save(gasStationFuel);
    }

}
