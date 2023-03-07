package com.iliyan.autodeluxe.models.entities;

import com.iliyan.autodeluxe.models.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Date createdOn;
    @OneToMany
    private List<Car> boughtCars;
    @OneToMany
    private List<Car> soldCars;
    @OneToMany
    private List<Car> carsForSale;
}
