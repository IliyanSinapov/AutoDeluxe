package com.iliyan.autodeluxe.repository;

import com.iliyan.autodeluxe.models.entities.SoldCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldCarsRepository extends JpaRepository<SoldCars, Long> {
}
