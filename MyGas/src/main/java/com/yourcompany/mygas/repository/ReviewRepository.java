package com.yourcompany.mygas.repository;

import com.yourcompany.mygas.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public void deleteById(Long id);

    public List<Review> findAll();

    public Optional<Review> findById(Long id);

    public Review save(Review review);

}
