package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.models.CarModel;
import com.iliyan.autodeluxe.models.DTOs.view.CarModelToDisplay;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestfulController {

    private final LoggedUser loggedUser;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RestfulController(LoggedUser loggedUser, CarRepository carRepository, ModelMapper modelMapper) {
        this.loggedUser = loggedUser;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/logged-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    @GetMapping("/")
    public List<CarModelToDisplay> getCars() {

        if (loggedUser.isLoggedIn()) {

            List<CarModelToDisplay> carsToDisplay = new ArrayList<>();

            List<CarModel>cars = carRepository.findAll()
                    .stream()
                    .map(car -> this.modelMapper.map(car, CarModel.class))
                    .collect(Collectors.toList());

            for (int i = 0; i < cars.size(); i++) {
                CarModelToDisplay car = new CarModelToDisplay();

                car.setId(cars.get(i).getId());
                car.setMake(cars.get(i).getMake());
                car.setSeries(cars.get(i).getSeries());
                car.setMileage(cars.get(i).getMileage());
            }
        }
        return null;
    }
}
