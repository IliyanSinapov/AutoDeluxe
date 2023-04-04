package com.iliyan.autodeluxe.repository;

import com.iliyan.autodeluxe.models.entities.Car;
import com.iliyan.autodeluxe.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
