package com.iliyan.autodeluxe.models.DTOs.view;

import com.iliyan.autodeluxe.models.enums.Condition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCarModel {
    @NotBlank
    @NotNull
    private String make;
    @NotBlank
    @NotNull
    private String model;
    @NotBlank
    @NotNull
    private String series;
    @Positive
    @NotNull
    private BigDecimal price;
    private byte[] image;
    @NotBlank
    @NotNull
    private String year;
    @NotNull
    private Condition condition;
//    @NotNull
//    @Positive
    private Integer mileage;
}
