package com.iliyan.autodeluxe.models.DTOs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldCarsModel {
    private UserModel user;
    private List<CarModel> cars;
}
