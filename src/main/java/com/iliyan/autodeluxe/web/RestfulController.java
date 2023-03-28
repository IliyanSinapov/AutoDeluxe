package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.models.CarModel;
import com.iliyan.autodeluxe.models.DTOs.models.UserModel;
import com.iliyan.autodeluxe.models.DTOs.view.CarModelToDisplay;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.repository.CarRepository;
import com.iliyan.autodeluxe.service.UserService;
import org.apache.tika.Tika;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestfulController {

    private final LoggedUser loggedUser;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Tika tika;
    private final UserService userService;

    @Autowired
    public RestfulController(LoggedUser loggedUser, CarRepository carRepository, ModelMapper modelMapper, Tika tika, UserService userService) {
        this.loggedUser = loggedUser;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.tika = tika;
        this.userService = userService;
    }

    @GetMapping(value = "/logged-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoggedUser getLoggedUser() {
        return loggedUser;
    }


    //region sendCarsToFrontEndToShow region
    @GetMapping("/cars")
    public List<CarModelToDisplay> getCars() {

        if (loggedUser.isLoggedIn()) {

            List<CarModelToDisplay> carsToDisplay = new ArrayList<>();
            UserModel currentUser = this.modelMapper.map(userService.findById(loggedUser.getId()), UserModel.class);

            List<CarModel>cars = carRepository.findAll()
                    .stream()
                    .map(car -> this.modelMapper.map(car, CarModel.class))
                    .collect(Collectors.toList());

            for (int i = 0; i < cars.size(); i++) {

                CarModelToDisplay car = new CarModelToDisplay();

                if (!currentUserOwnsCar(currentUser, cars.get(i))) {
                    String imageData = Base64.getEncoder().encodeToString(cars.get(i).getImage());
                    String imageType = this.tika.detect(cars.get(i).getImage());

                    car.setId(cars.get(i).getId());
                    car.setMake(cars.get(i).getMake());
                    car.setModel(cars.get(i).getModel());
                    car.setSeries(cars.get(i).getSeries());
                    car.setMileage(cars.get(i).getMileage());
                    car.setCondition(cars.get(i).getCondition());
                    car.setDescription(cars.get(i).getDescription());
                    car.setImage(imageData);
                    car.setPrice(cars.get(i).getPrice());
                    car.setYear(cars.get(i).getYear());
                    car.setImageType(imageType);

                    carsToDisplay.add(car);
                }
            }

            return carsToDisplay;
        }
        return null;
    }
    //endregion

    private boolean currentUserOwnsCar(UserModel currentUser, CarModel car) {
        return currentUser.getCarsForSale().getCars().contains(car)
                || currentUser.getSoldCars().getCars().contains(car)
                || currentUser.getBoughtCars().getCars().contains(car);
    }
}
