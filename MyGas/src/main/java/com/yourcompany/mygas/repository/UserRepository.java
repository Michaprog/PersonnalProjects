package com.yourcompany.mygas.repository;


import com.yourcompany.mygas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
