package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.view.UserLoginModel;
import com.iliyan.autodeluxe.models.DTOs.view.UserRegisterModel;
import com.iliyan.autodeluxe.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
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

    //Model attributes

    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel() {
        return new UserRegisterModel();
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel() {
        return new UserLoginModel();
    }
}
