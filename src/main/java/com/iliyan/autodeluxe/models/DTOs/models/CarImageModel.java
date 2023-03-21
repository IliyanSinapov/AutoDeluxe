package com.iliyan.autodeluxe.models.DTOs.models;

import com.iliyan.autodeluxe.models.entities.Car;
import com.iliyan.autodeluxe.models.entities.CarImage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
public class CarImageModel {

    private Long id;
    private Car car;
    private Blob imageData;
}
