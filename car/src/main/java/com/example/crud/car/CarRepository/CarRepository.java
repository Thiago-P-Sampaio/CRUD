package com.example.crud.car.CarRepository;

import com.example.crud.car.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CarRepository  extends JpaRepository <Cars, UUID> {}
