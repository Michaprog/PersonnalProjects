package com.yourcompany.mygas.controller;

import com.yourcompany.mygas.model.GasStationFuel;
import com.yourcompany.mygas.model.GasStationFuelId;
import com.yourcompany.mygas.repository.GasStationFuelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gas-station-fuels")
public class GasStationFuelController {

    private final GasStationFuelRepository fuelRepository;

    public GasStationFuelController(GasStationFuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    @GetMapping
    public List<GasStationFuel> getAllFuelRecords() {
        return fuelRepository.findAll();
    }

    @GetMapping("/{gasStationId}/{fuelType}")
    public ResponseEntity<GasStationFuel> getFuelRecord(@PathVariable Long gasStationId,
                                                        @PathVariable String fuelType) {
        GasStationFuelId id = new GasStationFuelId(gasStationId, fuelType);
        return fuelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GasStationFuel createFuelRecord(@RequestBody GasStationFuel fuel) {
        return fuelRepository.save(fuel);
    }

    @PutMapping("/{gasStationId}/{fuelType}")
    public ResponseEntity<GasStationFuel> updateFuelRecord(@PathVariable Long gasStationId,
                                                           @PathVariable String fuelType,
                                                           @RequestBody GasStationFuel updatedFuel) {
        GasStationFuelId id = new GasStationFuelId(gasStationId, fuelType);
        return fuelRepository.findById(id)
                .map(fuel -> {
                    fuel.setPrice(updatedFuel.getPrice());
                    return ResponseEntity.ok(fuelRepository.save(fuel));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{gasStationId}/{fuelType}")
    public ResponseEntity<Void> deleteFuelRecord(@PathVariable Long gasStationId,
                                                 @PathVariable String fuelType) {
        GasStationFuelId id = new GasStationFuelId(gasStationId, fuelType);
        if (fuelRepository.existsById(id)) {
            fuelRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
