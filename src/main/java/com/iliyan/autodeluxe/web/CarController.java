package com.iliyan.autodeluxe.web;

import com.iliyan.autodeluxe.models.DTOs.view.AddCarModel;
import com.iliyan.autodeluxe.models.beans.LoggedUser;
import com.iliyan.autodeluxe.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final LoggedUser loggedUser;
    private final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    @Autowired
    public CarController(CarService carService, LoggedUser loggedUser) {
        this.carService = carService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/add")
    public String getAdd() {
        if (loggedUser == null)
            return "index";
        return "add-car";
    }

    @PostMapping("/add")
    public String postAdd(@Valid @ModelAttribute(name = "addCarModel") AddCarModel addCarModel,
                          @RequestPart("imageFile")MultipartFile imageFile,
                          @RequestParam("mileageValue")Integer mileage,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) throws IOException{
        if (loggedUser == null)
            return "index";
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

    @GetMapping("/{id}")
    public String getCarOffer(@PathVariable String id) {
        if (loggedUser == null)
            return "index";
        return "car-offer";
    }

    //Model attributes

    @ModelAttribute(name = "addCarModel")
    public AddCarModel addCarModel() {
        return new AddCarModel();
    }
}
