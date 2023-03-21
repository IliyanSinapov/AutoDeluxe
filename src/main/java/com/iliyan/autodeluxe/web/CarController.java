package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.view.AddCarModel;
import com.iliyan.autodeluxe.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/add")
    public String getAdd() {
        return "add-car";
    }

    @PostMapping("/add")
    public String postAdd(@Valid @ModelAttribute(name = "addCarModel") AddCarModel addCarModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addCarModel", addCarModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addCarModel", bindingResult);
        }


        return "redirect:/";
    }


    //Model attributes

    @ModelAttribute(name = "addCarModel")
    public AddCarModel addCarModel() {
        return new AddCarModel();
    }
}
