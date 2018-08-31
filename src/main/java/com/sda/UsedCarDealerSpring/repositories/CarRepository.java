package com.sda.UsedCarDealerSpring.repositories;

import com.sda.UsedCarDealerSpring.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    Page<Car> findAllBy (Pageable pageable);

    List<Car> findAllByCompanyOrYear(String company, Integer year);

    List<Car> findAllByYear(Integer year);
}

