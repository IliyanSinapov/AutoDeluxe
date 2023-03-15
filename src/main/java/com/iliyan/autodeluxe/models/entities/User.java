package com.iliyan.autodeluxe.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iliyan.autodeluxe.models.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BoughtCars boughtCars;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SoldCars soldCars;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CarsForSale carsForSale;
}
