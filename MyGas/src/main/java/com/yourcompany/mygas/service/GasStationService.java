package com.yourcompany.mygas.service;

import com.yourcompany.mygas.model.GasStation;
import com.yourcompany.mygas.repository.GasStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public List<GasStation> findAll() {
        return gasStationRepository.findAll();
    }

    public Optional<GasStation> findById(Long id) {
        return gasStationRepository.findById(id);
    }

    public GasStation save(GasStation gasStation) {
        return gasStationRepository.save(gasStation);
    }

    public void deleteById(Long id) {
        gasStationRepository.deleteById(id);
    }
}
