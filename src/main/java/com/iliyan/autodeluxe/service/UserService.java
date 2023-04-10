package com.iliyan.autodeluxe.service;

import com.iliyan.autodeluxe.models.DTOs.models.UserModel;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.models.entities.User;
import com.iliyan.autodeluxe.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoggedUser loggedUser;
    private final UserModel currentUser;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loggedUser = loggedUser;

        if (loggedUser.isLoggedIn())
            this.currentUser = this.modelMapper.map(this.userRepository.findById(loggedUser.getId()).get(), UserModel.class);
        else
            this.currentUser = null;
    }

    public boolean checkUserPassword(String password, UserModel userModel){
        return bCryptPasswordEncoder.matches(password, userModel.getPassword());
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<UserModel> findAll() {

        List<UserModel> users = new ArrayList<>();

        for (int i = 0; i < this.userRepository.count(); i++) {
            UserModel userModel = this.modelMapper.map(this.userRepository.findById(Long.parseLong((i + 2) + "")).get(), UserModel.class);
            users.add(userModel);
        }


        return users;
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }
}
