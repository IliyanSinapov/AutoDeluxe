package com.iliyan.autodeluxe.models.DTOs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.iliyan.autodeluxe.models.DTOs.models.SoldCarsModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoughtCarsModel {

    private UserModel user;
    private List<CarModel> cars;

}
