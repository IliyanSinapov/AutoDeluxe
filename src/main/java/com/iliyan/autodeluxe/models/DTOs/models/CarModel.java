package com.iliyan.autodeluxe.models.DTOs.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

    private String make;
    private String model;
    private String series;
    private String year;
    private String condition;
    private String mileage;
}
