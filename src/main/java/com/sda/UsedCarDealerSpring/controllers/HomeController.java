package com.sda.UsedCarDealerSpring.controllers;

import com.sda.UsedCarDealerSpring.model.Car;
import com.sda.UsedCarDealerSpring.model.CreateCarRequest;
import com.sda.UsedCarDealerSpring.model.EditCarRequest;
import com.sda.UsedCarDealerSpring.services.CarFactory;
import com.sda.UsedCarDealerSpring.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
public class HomeController {
    private CarFactory carFactory;

    private CarService carService;


    @Autowired
    public HomeController(CarFactory carFactory, CarService carService) {
        this.carFactory = carFactory;
        this.carService = carService;
    }

    @GetMapping("/all")
    public List <Car> findAllCar() {
        return carService.findAllCar();
    }


    @GetMapping("/find")
    public List <Car> findAllCarByCompany(@RequestParam(required = false) String company, @RequestParam(required = false) Integer year) {
        return carService.findAllCarByCompany(company, year);
    }

    @GetMapping("/year")
    public List <Car> findAllCarByYear(@RequestParam Integer year) {
        return carService.findAllCarByYear(year);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody @Valid CreateCarRequest request) {
        carFactory.createCar(request);
    }


    @PutMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    public void editCar(@RequestBody @Valid EditCarRequest request , @RequestParam String id) {
        carFactory.editCar(request, id);

    }
}
