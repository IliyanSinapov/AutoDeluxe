package com.iliyan.autodeluxe.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String series;
    @Column
    private BigDecimal price;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String condition;
    @Column
    private String mileage;
}
