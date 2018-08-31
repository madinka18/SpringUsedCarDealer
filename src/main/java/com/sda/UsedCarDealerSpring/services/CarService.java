package com.sda.UsedCarDealerSpring.services;

import com.sda.UsedCarDealerSpring.model.Car;
import com.sda.UsedCarDealerSpring.repositories.CarRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Page<Car> findAll(Pageable pageable){
        return carRepository.findAllBy(pageable);
    }

    public List<Car> findAllCar() {
        return  carRepository.findAll();
    }

    public List <Car> findAllCarByCompany(String company, Integer year) {

        return  carRepository.findAllByCompanyOrYear(company, year);
    }

    public List<Car> findAllCarByYear(Integer year) {
        return carRepository.findAllByYear(year);
    }
}
