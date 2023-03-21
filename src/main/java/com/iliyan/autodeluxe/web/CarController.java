package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.view.AddCarModel;
import com.iliyan.autodeluxe.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

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
                          @RequestPart("imageFile")MultipartFile imageFile,
                          @RequestParam("mileageValue")Integer mileage,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) throws IOException{

        if (!imageFile.isEmpty()) {
            byte[] imageData = imageFile.getBytes();
            addCarModel.setImage(imageData);
            addCarModel.setMileage(mileage);
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addCarModel", addCarModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addCarModel", bindingResult);
        }

        carService.addCar(addCarModel);

        return "redirect:/";
    }


    //Model attributes

    @ModelAttribute(name = "addCarModel")
    public AddCarModel addCarModel() {
        return new AddCarModel();
    }
}
