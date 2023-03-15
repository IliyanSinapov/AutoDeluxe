package com.iliyan.autodeluxe.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bought_cars")
public class BoughtCars{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "bought_cars_cars",
            joinColumns = @JoinColumn(name = "bought_cars_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;
}
