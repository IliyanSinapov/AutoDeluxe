package com.iliyan.autodeluxe.models.DTOs.models;

import com.iliyan.autodeluxe.models.entities.BoughtCars;
import com.iliyan.autodeluxe.models.entities.CarsForSale;
import com.iliyan.autodeluxe.models.entities.SoldCars;
import com.iliyan.autodeluxe.models.enums.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;
    private String username;
    private String email;
    private RoleType role;
    private String password;
    private Date createdOn;
    private BoughtCarsModel boughtCars;
    private SoldCarsModel soldCars;
    private CarsForSaleModel carsForSale;

    public boolean isValid() {
        return this.id != null;
    }
}
