package com.sda.UsedCarDealerSpring.model;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Value
@Document(collection = "cars")
@Getter
public class Car {

    @Id
    private String id;

    private String company;

    private String model;

    private String colour;

    private Integer year;

    private Integer mileage;

    private Integer engine;

    private Integer price;



}
