package com.example.crud.car.CarController;


import com.example.crud.car.CarDTO.CarDTO;
import com.example.crud.car.CarRepository.CarRepository;
import com.example.crud.car.domain.Cars;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("/car")
public class Controller {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public ResponseEntity findAllCars() {
        var allCars = carRepository.findAll();
        return ResponseEntity.ok(allCars);
    }

    @PostMapping
    public ResponseEntity CreateNewCar(@RequestBody @Valid CarDTO ModelData) {
        Cars newCar = new Cars(ModelData);
        carRepository.save(newCar);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id_car}")
    @Transactional
    public ResponseEntity UpdtCarInfo(@PathVariable("id_car") @Valid UUID id_car, @RequestBody @Valid CarDTO ModelData) {
        Optional<Cars> optionalCars = carRepository.findById(id_car);
        if(optionalCars.isPresent()){
         Cars cars = optionalCars.get();
         cars.setCar_brand(ModelData.car_brand());
         cars.setModel(ModelData.model());
         cars.setPrice(ModelData.price());
         carRepository.save(cars);
         return ResponseEntity.ok(cars);
        } else{
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping ("/{id_car}")
    public ResponseEntity DeleteCar (@PathVariable("id_car") @Valid UUID id_car) {
        if (carRepository.findById(id_car).isPresent()) {
            carRepository.deleteById(id_car);
            return  ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
}

