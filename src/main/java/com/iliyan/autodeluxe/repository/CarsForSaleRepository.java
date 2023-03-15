package com.iliyan.autodeluxe.repository;

import com.iliyan.autodeluxe.models.entities.CarsForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsForSaleRepository extends JpaRepository<CarsForSale, Long> {
}
