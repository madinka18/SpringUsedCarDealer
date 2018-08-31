package com.sda.UsedCarDealerSpring.services;

import com.sda.UsedCarDealerSpring.model.Car;
import com.sda.UsedCarDealerSpring.model.CreateCarRequest;
import com.sda.UsedCarDealerSpring.model.EditCarRequest;
import com.sda.UsedCarDealerSpring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarFactory {
    private CarRepository repository;

    @Autowired
    public CarFactory(CarRepository repository) {
        this.repository = repository;
    }

    public void createCar(CreateCarRequest request){
        Car car = Car.builder()
                .company(request.getCompany())
                .model(request.getModel())
                .colour(request.getColour())
                .year(request.getYear())
                .mileage(request.getMileage())
                .engine(request.getEngine())
                .price(request.getPrice()).id(UUID.randomUUID().toString())
                .build();

        repository.save(car);
    }


    public void editCar(EditCarRequest request, String id) {

       Car car = Car.builder()
                .company(request.getCompany())
                .model(request.getModel())
                .colour(request.getColour())
                .year(request.getYear())
                .mileage(request.getMileage())
                .engine(request.getEngine())
                .price(request.getPrice())
                .id(request.getId())
                .build();

        repository.save(car);
    }
}
