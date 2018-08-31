package com.sda.UsedCarDealerSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Getter
public class EditCarRequest {

    @NotNull
    @Size(min = 3)
    private String company;

    @NotNull
    @Size(min = 2)
    private String model;

    @NotNull
    @Size(min = 3)
    private String colour;

    @NotNull
    private Integer year;

    @NotNull
    private Integer mileage;

    @NotNull
    private Integer engine;

    @NotNull
    private  Integer price;

    @NotNull
    private  String id;

}
