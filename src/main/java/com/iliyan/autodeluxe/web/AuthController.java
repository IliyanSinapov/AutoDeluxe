package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.view.ChangeImage;
import com.iliyan.autodeluxe.models.DTOs.view.ChangeUsername;
import com.iliyan.autodeluxe.models.DTOs.view.UserLoginModel;
import com.iliyan.autodeluxe.models.DTOs.view.UserRegisterModel;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final AuthService authService;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterForm")UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userRegisterForm", userRegisterModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:register";
        }

        this.authService.registerUser(userRegisterModel);


        return "redirect:login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginModel") UserLoginModel userLoginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes
                    .addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userLoginModel", bindingResult);


            return "redirect:login";
        }

        this.authService.loginUser(userLoginModel);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String postMapping(){
        if (loggedUser == null)
            return "index";
        this.authService.logoutUser();
        return "redirect:/";
    }


    @GetMapping("/account")
    public String getAccount() {
        if (loggedUser == null)
            return "index";
        return "account";
    }

    @PostMapping("/change-username")
    public String postChangeUsername(@Valid @ModelAttribute(name = "changeUsername") ChangeUsername changeUsername,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()){

            redirectAttributes
                    .addFlashAttribute("changeUsername", changeUsername)
                    .addFlashAttribute(BINDING_RESULT_PATH + "changeUsername", bindingResult);

            return "account";
        }

        this.authService.changeUsername(changeUsername);

        return "redirect:account";
    }

    @PostMapping("/change-image")
    public String postChangeImage(@RequestPart("imageFile") MultipartFile imageFile) throws IOException {

        if (imageFile.isEmpty())
            return "account";


        byte[] imageData = imageFile.getBytes();
        this.authService.changeUserImage(imageData);

        return "redirect:account";
    }

    //Model attributes

    @ModelAttribute(name = "changeUsername")
    public ChangeUsername changeUsername() {
        return new ChangeUsername();
    }

    @ModelAttribute(name = "changeImage")
    public ChangeImage changeImage() {
        return new ChangeImage();
    }

    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel() {
        return new UserRegisterModel();
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel() {
        return new UserLoginModel();
    }
}
