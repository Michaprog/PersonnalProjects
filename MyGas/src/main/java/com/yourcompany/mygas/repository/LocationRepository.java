package com.yourcompany.mygas.repository;


import com.yourcompany.mygas.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    public List<Location> findAll();

    public Optional<Location> findById(Long id);

    public Location save(Location location);

    public void deleteById(Long id);

}
