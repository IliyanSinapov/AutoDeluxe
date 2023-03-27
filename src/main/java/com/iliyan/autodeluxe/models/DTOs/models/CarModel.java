package com.iliyan.autodeluxe.models.DTOs.models;

import com.iliyan.autodeluxe.models.enums.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

    private Long id;
    private String make;
    private String model;
    private String series;
    private BigDecimal price;
    private byte[] image;
    private String imageType;
    private String year;
    private Condition condition;
    private Integer mileage;
    private String description;
}
