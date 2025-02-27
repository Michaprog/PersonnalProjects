package com.yourcompany.mygas.controller;

import com.yourcompany.mygas.model.GasStation;
import com.yourcompany.mygas.service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gasstations")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping
    public List<GasStation> getAllGasStations() {
        return gasStationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GasStation> getGasStationById(@PathVariable Long id) {
        return gasStationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GasStation createGasStation(@RequestBody GasStation gasStation) {
        return gasStationService.save(gasStation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GasStation> updateGasStation(@PathVariable Long id, @RequestBody GasStation updatedGasStation) {
        return gasStationService.findById(id)
                .map(gasStation -> {
                    gasStation.setName(updatedGasStation.getName());
                    gasStation.setLocation(updatedGasStation.getLocation());
                    gasStation.setOpeningHours(updatedGasStation.getOpeningHours());
                    gasStation.setClosingHours(updatedGasStation.getClosingHours());
                    gasStation.setPhoneNumber(updatedGasStation.getPhoneNumber());
                    gasStation.setEmail(updatedGasStation.getEmail());
                    gasStation.setWebsite(updatedGasStation.getWebsite());
                    gasStation.setPhoto(updatedGasStation.getPhoto());
                    return ResponseEntity.ok(gasStationService.save(gasStation));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasStation(@PathVariable Long id) {
        gasStationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
