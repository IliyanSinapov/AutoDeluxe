package com.iliyan.autodeluxe.models.DTOs.view;

import com.iliyan.autodeluxe.models.DTOs.models.CarImageModel;
import com.iliyan.autodeluxe.models.entities.CarImage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class AddCarModel {

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
