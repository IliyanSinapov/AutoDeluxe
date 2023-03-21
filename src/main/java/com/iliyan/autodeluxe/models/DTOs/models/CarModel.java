package com.iliyan.autodeluxe.models.DTOs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private List<CarImageModel> images;
    private String year;
    private String condition;
    private String mileage;
}
