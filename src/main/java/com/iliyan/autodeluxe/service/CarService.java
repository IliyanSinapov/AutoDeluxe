package com.iliyan.autodeluxe.service;

import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final LoggedUser loggedUser;

    @Autowired
    public CarService(ModelMapper modelMapper, CarRepository carRepository, LoggedUser loggedUser) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.loggedUser = loggedUser;
    }

    public void addCar() {

    }
}
