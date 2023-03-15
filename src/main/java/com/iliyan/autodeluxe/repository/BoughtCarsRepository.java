package com.iliyan.autodeluxe.repository;

import com.iliyan.autodeluxe.models.entities.BoughtCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtCarsRepository extends JpaRepository<BoughtCars, Long> {
}
