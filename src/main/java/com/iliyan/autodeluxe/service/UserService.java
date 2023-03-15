package com.iliyan.autodeluxe.service;

import com.iliyan.autodeluxe.models.DTOs.models.UserModel;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loggedUser = loggedUser;
    }

    public boolean checkUserPassword(String password, UserModel userModel){
        return bCryptPasswordEncoder.matches(password, userModel.getPassword());
    }
}
