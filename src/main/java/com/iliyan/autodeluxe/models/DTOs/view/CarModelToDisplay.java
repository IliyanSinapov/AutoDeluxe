package com.iliyan.autodeluxe.models.DTOs.view;

import com.iliyan.autodeluxe.models.enums.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarModelToDisplay {
    private Long id;
    private String make;
    private String model;
    private String series;
    private BigDecimal price;
    private String image;
    private String year;
    private Condition condition;
    private Integer mileage;
    private String description;

}
