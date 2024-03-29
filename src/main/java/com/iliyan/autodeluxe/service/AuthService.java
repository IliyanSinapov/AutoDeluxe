package com.iliyan.autodeluxe.service;

import com.iliyan.autodeluxe.models.DTOs.models.BoughtCarsModel;
import com.iliyan.autodeluxe.models.DTOs.models.CarsForSaleModel;
import com.iliyan.autodeluxe.models.DTOs.models.SoldCarsModel;
import com.iliyan.autodeluxe.models.DTOs.models.UserModel;
import com.iliyan.autodeluxe.models.DTOs.view.ChangeImage;
import com.iliyan.autodeluxe.models.DTOs.view.ChangeUsername;
import com.iliyan.autodeluxe.models.DTOs.view.UserLoginModel;
import com.iliyan.autodeluxe.models.DTOs.view.UserRegisterModel;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.models.entities.User;
import com.iliyan.autodeluxe.models.enums.RoleType;
import com.iliyan.autodeluxe.repository.BoughtCarsRepository;
import com.iliyan.autodeluxe.repository.CarsForSaleRepository;
import com.iliyan.autodeluxe.repository.SoldCarsRepository;
import com.iliyan.autodeluxe.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AuthService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BoughtCarsRepository boughtCarsRepository;
    private final SoldCarsRepository soldCarsRepository;
    private final CarsForSaleRepository carsForSaleRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoggedUser loggedUser;


    @Autowired
    public AuthService(UserService userService, UserRepository userRepository, BoughtCarsRepository boughtCarsRepository, SoldCarsRepository soldCarsRepository, CarsForSaleRepository carsForSaleRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, LoggedUser loggedUser) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.boughtCarsRepository = boughtCarsRepository;
        this.soldCarsRepository = soldCarsRepository;
        this.carsForSaleRepository = carsForSaleRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegister) throws IOException {

        UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        BoughtCarsModel boughtCarsModel = new BoughtCarsModel();
        boughtCarsModel.setCars(new ArrayList<>());
        SoldCarsModel soldCarsModel = new SoldCarsModel();
        soldCarsModel.setCars(new ArrayList<>());
        CarsForSaleModel carsForSaleModel = new CarsForSaleModel();
        carsForSaleModel.setCars(new ArrayList<>());

        Path imagePath = Path.of("src/main/resources/static/images/no_user_image.jpg");
        byte[] imageData = Files.readAllBytes(imagePath);

        userModel.setCreatedOn(new Date());
        userModel.setBoughtCars(boughtCarsModel);
        userModel.setCarsForSale(carsForSaleModel);
        userModel.setSoldCars(soldCarsModel);
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userModel.setRole(RoleType.USER);
        userModel.setUserImage(imageData);

        boughtCarsModel.setUser(userModel);
        soldCarsModel.setUser(userModel);
        carsForSaleModel.setUser(userModel);

        User userToSave = this.modelMapper.map(userModel, User.class);
        this.userRepository.saveAndFlush(userToSave);
    }

    public void loginUser(UserLoginModel userLogin) {
        User userToGet = this.userRepository.findByUsername(userLogin.getUsername()).get();

        UserModel loginCandidate = this.modelMapper.map(userToGet, UserModel.class);
        boolean passMatch = userService.checkUserPassword(userLogin.getPassword(), loginCandidate);

        if (loginCandidate.isValid() && passMatch) {
            this.loggedUser
                    .setId(loginCandidate.getId());
            this.loggedUser
                    .setUsername(loginCandidate.getUsername());
            this.loggedUser
                    .setEmail(loginCandidate.getEmail());
            this.loggedUser
                    .setImage(loginCandidate.getUserImage());
        }
    }

    public void logoutUser() {
        loggedUser.clearUser();
    }

    public void changeUsername(ChangeUsername changeUsername) {
        if (!(this.userRepository.findByUsername(changeUsername.getUsername()).isPresent())) {
            User currentUser = this.userRepository.findById(loggedUser.getId()).get();
            currentUser.setUsername(changeUsername.getUsername());
            this.userRepository.save(currentUser);

            this.loggedUser.setUsername(changeUsername.getUsername());
        }
    }

    public void changeUserImage(byte[] changeImage) {
        User currentUser = this.userRepository.findById(loggedUser.getId()).get();
        currentUser.setUserImage(changeImage);
        userRepository.save(currentUser);
        this.loggedUser.setImage(changeImage);
    }
}
