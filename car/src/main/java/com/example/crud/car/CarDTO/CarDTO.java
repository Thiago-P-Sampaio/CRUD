package com.example.crud.car.CarDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CarDTO
        ( UUID id_car,
          @NotBlank String car_brand,
         @NotBlank String model,
         @NotNull float price) {
}
