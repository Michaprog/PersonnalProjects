package com.yourcompany.mygas.repository;

import com.yourcompany.mygas.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
