package com.example.crud.car.domain;


import com.example.crud.car.CarDTO.CarDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Entity
@Table (name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cars {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id_car;
    private String car_brand;
    private String model;
    private float price;

    public Cars(CarDTO carDTO){
        this.car_brand = carDTO.car_brand();
        this.model = carDTO.model();
        this.price = carDTO.price();
        this.id_car = carDTO.id_car();
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public UUID getId_car() {
        return id_car;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public float getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}
