package com.iliyan.autodeluxe.models.entities;

import com.iliyan.autodeluxe.models.enums.Condition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
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
    @Lob
    @Column(length = 10 * 3880 * 2160)
    private byte[] image;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Condition condition;
    @Column
    private Integer mileage;
}
